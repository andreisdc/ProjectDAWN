package com.pontic_studio.myproperty.Models;

public class Client {

	private int idClient;
	private String name;
	private String surname;
	private int idUser;

	public Client(int idClient, String name, String surname, int idUser) {
		this.idClient = idClient;
		this.name = name;
		this.surname = surname;
		this.idUser = idUser;
	}

	public int getIdClient() {
		return idClient;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
