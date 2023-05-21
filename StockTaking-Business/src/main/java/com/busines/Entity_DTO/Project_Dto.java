package com.busines.Entity_DTO;

import com.busines.EntityBBDD.T_Project;
import com.busines.Mapper.MapperInterface;

public class Project_Dto implements MapperInterface<T_Project>
{
	/*
		Zona de Atributos
	*/
	private Long id;
	private String name;
	private String description;
	private String url;
	
	/*
		Zona de Constructores
	*/
	public Project_Dto() 
	{
		
	}
	
	public Project_Dto(Long id, String name, String description, String url) 
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.url = url;
	}
	
	public Project_Dto(T_Project entity) 
	{
		this.mapper(entity);
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_Project entity) 
	{
		try
		{
			this.id = entity.getId();
			this.name = entity.getName();
			this.description = entity.getDescription();
			this.url = entity.getUrl();
		}
		catch (Exception e) 
		{
			return false;
		}
		
		return true;
	}

}
