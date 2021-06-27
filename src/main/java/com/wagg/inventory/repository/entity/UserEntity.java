package com.wagg.inventory.repository.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastname;
	private LocalDate birthDate;
	@ManyToOne
	@JoinColumn(name = "position_id")
	private PositionEntity position;
	private LocalDate joiningDate;
	@OneToMany(mappedBy = "registerUser", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductEntity> registeredProducts;
	@OneToMany(mappedBy = "editorUser", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductEntity> editedProducts;
	
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public PositionEntity getPosition() {
		return position;
	}
	public void setPosition(PositionEntity position) {
		this.position = position;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	
}
