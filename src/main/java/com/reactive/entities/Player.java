package com.reactive.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "player")
public class Player {
	@Id
	private int id;
	@Column("full_name")
	private String fullName;
	private int age;
	@Column("playing")
	private String playing;

	public Player(int id, String fullName, int age, String playing) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.playing = playing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlaying() {
		return playing;
	}

	public void setPlaying(String playing) {
		this.playing = playing;
	}

}
