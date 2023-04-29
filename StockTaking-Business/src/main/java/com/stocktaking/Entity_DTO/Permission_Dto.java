package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_Permission;
import com.stocktaking.Mapper.MapperInterface;

public class Permission_Dto implements MapperInterface<T_Permission>
{
	/*
		Zona de Atributos
	*/
	public Long id;
	String name;
	String description;
	
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
