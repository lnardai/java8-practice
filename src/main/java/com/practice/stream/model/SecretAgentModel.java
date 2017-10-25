package com.practice.stream.model;

public class SecretAgentModel implements Agent {
	private String name;
	private boolean active;
	private Location location;
	private Skill skill;

	public SecretAgentModel(String name, Location location, Skill skill) {
		this.name = name;
		this.active = false;
		this.location = location;
		this.skill = skill;
	}

	public void activate(){
		this.active = true;
	}

	@Override public String getName() {
		return name;
	}

	@Override
	public Skill getSkill() {
		return skill;
	}
}
