package com.xeezee.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("entry")
public class EntryE {
	private final String title, description;

	public EntryE(String title, String description) {
		this.title = title;
		this.description = description;
	}
}