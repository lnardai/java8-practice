package com.practice.stream.model;


public interface ForeignAgent {
	String getName();

	default Skill getSkill() {
		return null;
	}
}
