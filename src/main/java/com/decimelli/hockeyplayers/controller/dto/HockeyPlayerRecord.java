package com.decimelli.hockeyplayers.controller.dto;

import java.io.Serializable;
import java.util.UUID;

public record HockeyPlayerRecord(
		UUID id,
		String firstname,
		String lastname,
		HockeyTeamRecord team,
		int jerseyNumber) implements Serializable {
}
