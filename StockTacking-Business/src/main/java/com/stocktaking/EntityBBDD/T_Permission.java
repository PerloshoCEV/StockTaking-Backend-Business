package com.stocktaking.EntityBBDD;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_Permission")
public class T_Permission 
{
	
	/*
		Zona de Atributos
	*/
	@Id // Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable java será el Atributo / Campo clave de la entidad.
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Spring JPA le dice al Gestor de Bases de Datos que el Atributo será autogenerado.
	Long id; // Variable - Atributo / Campo -> id (Primary Key).
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Name", unique = true, nullable = false)
	@NaturalId
	String name;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Description", unique = false, nullable = false)
	String description;
	
	@OneToMany(mappedBy = "permission", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<T_User_Permission> users = new ArrayList<>();

	/*
		Zona de Constructores
	*/
	public T_Permission() {
		super();
	}

	public T_Permission(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public T_Permission(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public T_Permission(Long id, String name, String description, List<T_User_Permission> users) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.users = users;
	}

	/*
		Zona de Getters & Setters
	*/
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<T_User_Permission> getUsers() {
		return users;
	}

	public void setUsers(List<T_User_Permission> users) {
		this.users = users;
	}

	public void setAll(String newName, String newDescription) 
	{
		this.name = newName;
		this.description = newDescription;
	}
	
}
