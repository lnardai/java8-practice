package com.practice.stream.model;


public interface Agent {
	String getName();

	void activate();

	boolean isActivated();

	default Skill getSkill() {
		return Skill.ROOKIE;
	}
}
