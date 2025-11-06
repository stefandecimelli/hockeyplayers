package com.decimelli.hockeyplayers.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.decimelli.hockeyplayers.controller.dto.HockeyPlayerRecord;
import com.decimelli.hockeyplayers.controller.dto.HockeyTeamRecord;
import com.decimelli.hockeyplayers.model.HockeyPlayer;
import com.decimelli.hockeyplayers.model.HockeyTeam;
import com.decimelli.hockeyplayers.repository.HockeyPlayerRepo;
import com.decimelli.hockeyplayers.repository.HockeyTeamRepo;

@RestController
public class HockeyPlayerController {

	private final HockeyPlayerRepo database;
	private final HockeyTeamRepo teamDatabase;

	public HockeyPlayerController(HockeyPlayerRepo database, HockeyTeamRepo teamDatabase) {
		this.database = database;
		this.teamDatabase = teamDatabase;
	}

	@PostMapping("/player")
	public HockeyPlayerRecord createPlayer(@RequestBody HockeyPlayerRecord player) {
		HockeyPlayer entity = new HockeyPlayer();
		entity.setFirstname(player.firstname());
		entity.setLastname(player.lastname());
		entity.setJerseyNumber(player.jerseyNumber());
		HockeyTeam teamEntity = teamDatabase.findByName(player.team().name());
		entity.setTeam(teamEntity);
		entity = database.save(entity);
		return new HockeyPlayerRecord(
				entity.getId(),
				entity.getFirstname(),
				entity.getLastname(),
				new HockeyTeamRecord(entity.getTeam().getId(), entity.getTeam().getName()),
				entity.getJerseyNumber());
	}

	@GetMapping("/players")
	public Set<HockeyPlayerRecord> getAllPlayers() {
		Set<HockeyPlayerRecord> players = new HashSet<>();
		database.findAll().forEach(entity -> players.add(new HockeyPlayerRecord(
				entity.getId(),
				entity.getFirstname(),
				entity.getLastname(),
				new HockeyTeamRecord(entity.getTeam().getId(), entity.getTeam().getName()),
				entity.getJerseyNumber())));
		return players;
	}
}
