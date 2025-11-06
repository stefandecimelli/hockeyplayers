package com.decimelli.hockeyplayers.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decimelli.hockeyplayers.model.HockeyTeam;

public interface HockeyTeamRepo extends JpaRepository<HockeyTeam, UUID> {
	HockeyTeam findByName(String name);
}
