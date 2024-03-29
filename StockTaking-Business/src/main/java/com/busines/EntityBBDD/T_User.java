package com.busines.EntityBBDD;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_User")
public class T_User 
{
	/*
		Zona de Atributos
	*/
	@Id // Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable java será el Atributo / Campo clave de la entidad.
	@GeneratedValue(strategy = GenerationType.TABLE) // Spring JPA le dice al Gestor de Bases de Datos que el Atributo será autogenerado.
	private Long id; // Variable - Atributo / Campo -> id (Primary Key).
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Name", unique = false, nullable = true)
	private String name;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "LastName", unique = false, nullable = true)
	private String lastName;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "SecondLastName", unique = false, nullable = true)
	private String secondLastName;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Email", unique = true, nullable = false)
	private String email;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Age", unique = false, nullable = true)
	private Integer age;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Password", unique = false, nullable = false)
	private String password;
	
	@ManyToOne()
	@JsonBackReference
	private T_Membership membership;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties("user")
	private List<T_ProjectUserPermission> projectPermissions = new ArrayList<>();

	/*
		Zona de Constructores
	*/
	public T_User() {
		super();
	}

	public T_User(Long id, String name, String lastName, String secondLastName, String email, Integer age,
			String password, T_Membership membership) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.email = email;
		this.age = age;
		this.password = password;
		this.membership = membership;
	}

	public T_User(Long id, String name, String lastName, String secondLastName, String email, Integer age,
			String password, T_Membership membership, List<T_ProjectUserPermission> projectPermissions) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.email = email;
		this.age = age;
		this.password = password;
		this.membership = membership;
		this.projectPermissions = projectPermissions;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public T_Membership getMembership() {
		return membership;
	}

	public void setMembership(T_Membership membership) {
		this.membership = membership;
	}

	public List<T_ProjectUserPermission> getPermissions() {
		return projectPermissions;
	}

	public void setPermissions(List<T_ProjectUserPermission> permissions) {
		this.projectPermissions = permissions;
	}

	public void setAll
	(
		String newName, 
		String newLastName, 
		String newSecondLastName, 
		String newEmail, 
		Integer newAge,
		String newPassword, 
		T_Membership newMembership
	) 
	{
		this.name = newName;
		this.lastName = newLastName;
		this.secondLastName = newSecondLastName;
		this.email = newEmail;
		this.age = newAge;
		this.password = newPassword;
		this.membership = newMembership;
		
	}
	
	
}
