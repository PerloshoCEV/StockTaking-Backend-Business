package com.busines.Entity_DTO;

import com.busines.EntityBBDD.T_Membership;
import com.busines.Mapper.MapperInterface;

public class Membership_Dto implements MapperInterface<T_Membership>
{
	/*
		Zona de Atributos
	*/
	private Long id;
	private String name;
	private String description;
	private Double price;
	
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
			this.price = entity.getPrice();
		}
		catch (Exception e) 
		{
			return false;
		}
		
		return true;
	}
}
