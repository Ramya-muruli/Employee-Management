package com.java.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PerformannceComments")
public class PerformannceComments {

	private long id;
	private String text;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public PerformannceComments() {

	}

	public PerformannceComments(String text) {
		super();
		this.text = text;
	}

}
