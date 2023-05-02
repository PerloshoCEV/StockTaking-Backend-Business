package com.stocktaking.EntityBBDD;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_Project")
public class T_Project 
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
	@Column (name = "Description", unique = false, nullable = true)
	private String description;
	
	// Spring JPA le dice al Gestor de Bases de Datos que la siguiente variable Java será un Atributo / Campo de la entidad.
	@Column (name = "Url", unique = false, nullable = true)
	private String url;
	
	@OneToMany(mappedBy = "project")
	@JsonIgnoreProperties("project")
	private List<T_ProjectUserPermission> userPermissions = new ArrayList<>();

	/*
		Zona de Constructores
	*/
	public T_Project() 
	{
	}
	
	public T_Project
	(
		Long id, 
		String name, 
		String description, 
		String url
	) 
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.url = url;
	}
	
	public T_Project
	(
		Long id, 
		String name, 
		String description, 
		String url,
		List<T_ProjectUserPermission> userPermissions
	) 
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.url = url;
		this.userPermissions = userPermissions;
	}

	/*
		Zona de Getters & Setters
	*/
	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getUrl() 
	{
		return url;
	}

	public void setUrl(String url) 
	{
		this.url = url;
	}

	public List<T_ProjectUserPermission> getUserPermissions() 
	{
		return userPermissions;
	}

	public void setUserPermissions(List<T_ProjectUserPermission> userPermissions) 
	{
		this.userPermissions = userPermissions;
	}
	
	public void setAll
	(
		String newName, 
		String newDescription, 
		String newUrl
	) 
	{
		this.name = newName;
		this.description = newDescription;
		this.url = newUrl;
	}
	
}
