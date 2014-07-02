package com.xeezee.test;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("blog")
public class Blog {
	@XStreamAlias("author")
	private final Author writer;
	private final List entries = new ArrayList();

	public Blog(Author writer) {
		this.writer = writer;
	}

	public void add(Entry entry) {
		this.entries.add(entry);
	}

	public List getContent() {
		return this.entries;
	}
}