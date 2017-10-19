package com.practice.stream.model;

import java.util.Date;

public class Location {

	private Date lastSeen;
	private String country;

	public Location(Date lastSeen, String country) {
		this.lastSeen = lastSeen;
		this.country = country;
	}
}
