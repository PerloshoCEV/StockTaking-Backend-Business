package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_Membership;
import com.stocktaking.Mapper.MapperInterface;

public class Membership_Dto implements MapperInterface<T_Membership>
{
	/*
		Zona de Atributos
	*/
	public Long id;
	String name;
	String description;
	Double price;
	
	/*
		Zona de Constructores
	*/
	public Membership_Dto()
	{
		
	}
	
	public Membership_Dto(T_Membership entity)
	{
		this.mapper(entity);
	}
	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_Membership entity) 
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
