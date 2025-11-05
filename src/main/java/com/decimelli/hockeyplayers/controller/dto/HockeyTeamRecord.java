package com.decimelli.hockeyplayers.controller.dto;

import java.io.Serializable;
import java.util.UUID;

public record HockeyTeamRecord(UUID id, String name) implements Serializable {

}
