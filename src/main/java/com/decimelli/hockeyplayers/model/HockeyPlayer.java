package com.decimelli.hockeyplayers.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class HockeyPlayer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String firstname;
	private String lastname;

	@ManyToOne(fetch = FetchType.LAZY)
	private HockeyTeam team;
	private int jerseyNumber;

	public HockeyPlayer() {
		//
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public HockeyTeam getTeam() {
		return team;
	}

	public void setTeam(HockeyTeam team) {
		this.team = team;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public UUID getId() {
		return id;
	}

}
