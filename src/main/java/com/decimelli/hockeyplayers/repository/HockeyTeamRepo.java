package com.decimelli.hockeyplayers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decimelli.hockeyplayers.model.HockeyTeam;

public interface HockeyTeamRepo extends JpaRepository<HockeyTeam, Long> {
	HockeyTeam findByName(String name);
}
