package com.wagg.inventory.repository.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long stock;
	private LocalDate registrationDate;
	private LocalDate editionDate;
	@ManyToOne
	@JoinColumn(name = "register_user")
	private UserEntity registerUser;
	@ManyToOne
	@JoinColumn(name = "editor_User")
	private UserEntity editorUser;
	
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
	public UserEntity getRegisterUser() {
		return registerUser;
	}
	public void setRegisterUser(UserEntity registerUser) {
		this.registerUser = registerUser;
	}
	public UserEntity getEditorUser() {
		return editorUser;
	}
	public void setEditorUser(UserEntity editorUser) {
		this.editorUser = editorUser;
	}
	
}
