package com.pontic_studio.myproperty.Models;

public class User {
	private int id;
	private String username;
	private String password;
	private boolean isOwner; // optiunea pentru Owner

	public User(int id, String username, String password, boolean isOwner)
	{
		this.id	= id;
		this.username = username;
		this.password = password;
		this.isOwner = isOwner;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setOwner(boolean owner) {
		isOwner = owner;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isOwner() {
		return isOwner;
	}

	public String toString(){
		return "UserModel{" + "id=" + id + "," +" name=" + username + '\'' + " password=******* " + '\'' + "isOwner" + '\'' + isOwner;
	}
}
