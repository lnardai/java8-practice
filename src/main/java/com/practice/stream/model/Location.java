package com.practice.stream.model;

import java.util.Date;

public class Location {

	private Date lastSeen;
	private String continent;

	public Location(Date lastSeen, String continent) {
		this.lastSeen = lastSeen;
		this.continent = continent;
	}
}
