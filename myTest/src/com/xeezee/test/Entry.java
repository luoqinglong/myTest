package com.xeezee.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("entry")
public class Entry {
	private final String title, description;

	public Entry(String title, String description) {
		this.title = title;
		this.description = description;
	}
}