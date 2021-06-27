package com.wagg.inventory.dto;

import java.time.LocalDate;

public class ProductDto {
	
	private Long id;
	private String name;
	private Long stock;
	private LocalDate registrationDate;
	private LocalDate editionDate;
	private Long registerUser;
	private Long editorUser;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	public LocalDate getEditionDate() {
		return editionDate;
	}
	public void setEditionDate(LocalDate editionDate) {
		this.editionDate = editionDate;
	}
	public Long getRegisterUser() {
		return registerUser;
	}
	public void setRegisterUser(Long registerUser) {
		this.registerUser = registerUser;
	}
	public Long getEditorUser() {
		return editorUser;
	}
	public void setEditorUser(Long editorUser) {
		this.editorUser = editorUser;
	}
	
}
