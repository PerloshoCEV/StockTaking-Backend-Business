package com.stocktaking.EntityBBDD;

import java.util.List;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_Membership")
public class T_Membership 
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
	@Column (name = "Price", unique = false, nullable = false)
	Double price;
	
	@OneToMany(mappedBy = "membership")
	@JsonManagedReference
	List<T_User> users;

	/*
		Zona de Constructores
	*/
	public T_Membership() 
	{
		super();
	}

	public T_Membership(String name, Double price) 
	{
		super();
		this.name = name;
		this.price = price;
	}
	
	public T_Membership(Long id, String name, Double price) 
	{
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public T_Membership(Long id, String name, Double price, List<T_User> users) 
	{
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<T_User> getUsers() {
		return users;
	}

	public void setUsers(List<T_User> users) {
		this.users = users;
	}

	public void setAll(String newName, Double newPrice) 
	{
		this.name = newName;
		this.price = newPrice;
	}
	
	public void setAllEntity(T_Membership entity) 
	{
		this.name = entity.getName();
		this.price = entity.getPrice();
	}
}
