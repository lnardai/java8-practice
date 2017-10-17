package com.practice.stream.model;

public class SecretAgentModel {
	private String name;
	private boolean active;
	private Location location;
	private Skill skill;

	private SecretAgentModel(String name, boolean active, Location location, Skill skill) {
		this.name = name;
		this.active = active;
		this.location = location;
		this.skill = skill;
	}



}
