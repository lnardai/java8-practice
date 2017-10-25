package com.practice.stream.model;


public interface Agent {
	String getName();

	default Skill getSkill() {
		return Skill.ROOKIE;
	}
}
