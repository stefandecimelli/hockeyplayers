package com.decimelli.hockeyplayers.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.decimelli.hockeyplayers.controller.dto.HockeyTeamRecord;
import com.decimelli.hockeyplayers.model.HockeyTeam;
import com.decimelli.hockeyplayers.repository.HockeyTeamRepo;

@RestController
public class HockeyTeamController {

	private final HockeyTeamRepo database;

	@Autowired
	public HockeyTeamController(HockeyTeamRepo database) {
		this.database = database;
	}

	@GetMapping("/teams")
	public Set<HockeyTeamRecord> getAllTeams() {
		Set<HockeyTeamRecord> teams = new HashSet<>();
		database.findAll().forEach(entity -> teams.add(new HockeyTeamRecord(
			entity.getId(),
			entity.getName()
		)));
		return teams;
	}

	@PostMapping("/team")
	public HockeyTeamRecord getTeamByName(@RequestBody HockeyTeamRecord team) {
		HockeyTeam entity = new HockeyTeam(team.name());
		try {
			HockeyTeam savedEntity = database.save(entity);
			return new HockeyTeamRecord(savedEntity.getId(), savedEntity.getName());
		} catch (DataIntegrityViolationException e) {
			throw e;
		}
	}
}
