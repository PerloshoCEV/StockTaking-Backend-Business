package com.stocktaking.EntityBBDD;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity // Spring le dice al Gestor de Bases de Datos que la siguiente clase es una entidad (Tabla).
@Table(name = "T_User_Permission")
public class T_User_Permission 
{
	/*
		Zona de Atributos
	*/
	@EmbeddedId
	private EmbKey_User_Permission id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	private T_User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("permissionId")
	private T_Permission permission;
	
	@Column(name = "Level")
	private Integer level;

	/*
		Zona de Constructores
	*/
	public T_User_Permission() 
	{
		super();
	}
	
	public T_User_Permission(T_User user, T_Permission permission, Integer level) {
		super();
		this.user = user;
		this.permission = permission;
		this.level = level;
	}
	
	public T_User_Permission(EmbKey_User_Permission id, T_User user, T_Permission permission, Integer level) 
	{
		super();
		this.id = id;
		this.user = user;
		this.permission = permission;
		this.level = level;
	}

	/*
		Zona de Getters & Setters
	*/
	public EmbKey_User_Permission getId() {
		return id;
	}

	public void setId(EmbKey_User_Permission id) {
		this.id = id;
	}

	public T_User getUser() {
		return user;
	}

	public void setUser(T_User user) {
		this.user = user;
	}

	public T_Permission getPermission() {
		return permission;
	}

	public void setPermission(T_Permission permission) {
		this.permission = permission;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	
}
