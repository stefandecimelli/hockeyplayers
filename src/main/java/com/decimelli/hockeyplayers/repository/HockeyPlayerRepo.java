package com.decimelli.hockeyplayers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decimelli.hockeyplayers.model.HockeyPlayer;
import com.decimelli.hockeyplayers.model.HockeyTeam;

public interface HockeyPlayerRepo extends JpaRepository<HockeyPlayer, Long> {
	List<HockeyPlayer> findByTeam(HockeyTeam team);
}
