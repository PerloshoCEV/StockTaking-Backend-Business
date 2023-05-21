package com.busines.Entity_DTO;

import com.busines.EntityBBDD.T_Permission;
import com.busines.Mapper.MapperInterface;

public class Permission_Dto implements MapperInterface<T_Permission>
{
	/*
		Zona de Atributos
	*/
	private Long id;
	private String name;
	private String description;
	
	/*
		Zona de Constructores
	*/
	public Permission_Dto() 
	{

	}
	
	public Permission_Dto(T_Permission entity) 
	{
		this.mapper(entity);
	}
	
	
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

	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_Permission entity) 
	{
		try 
		{
			this.id = entity.getId();
			this.name = entity.getName();
			this.description = entity.getDescription();
		} 
		catch (Exception e) 
		{
			return false;
		}

		return true;
	}
}
