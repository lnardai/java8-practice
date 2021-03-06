package com.practice.stream.model;

public class Diplomat implements Agent {
	private String name;
	private boolean active;
	private Location location;
	private Skill skill;

	public Diplomat(String name, boolean active, Location location, Skill skill) {
		this.name = name;
		this.active = active;
		this.location = location;
		this.skill = skill;
	}

	@Override
	public String getName() {
		return name;
	}



	@Override
	public void activate() {
		this.active = true;
	}

	@Override
	public boolean isActivated() {
		return active;
	}

	@Override
	public Skill getSkill() {
		return skill;
	}
}
