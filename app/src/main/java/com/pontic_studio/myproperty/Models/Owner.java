package com.pontic_studio.myproperty.Models;

public class Owner {
	private int idOwner;
	private String name;
	private String surname;
	private int idUser;

	public Owner(int idOwner, String name, String surname, int idUser) {
		this.idOwner = idOwner;
		this.name = name;
		this.surname = surname;
		this.idUser = idUser;
	}

	public int getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(int idOwner) {
		this.idOwner = idOwner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
