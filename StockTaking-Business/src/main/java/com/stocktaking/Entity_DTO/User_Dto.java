package com.stocktaking.Entity_DTO;

import com.stocktaking.EntityBBDD.T_User;
import com.stocktaking.Mapper.MapperInterface;

public class User_Dto implements MapperInterface<T_User>
{
	/*
		Zona de Atributos
	*/
	public Long id;
	String name;
	String lastName;
	String secondLastName;
	String email;
	Integer age;
	
	/*
		Zona de Constructores
	*/
	public User_Dto ()
	{
		
	}
	
	public User_Dto (T_User entity)
	{
		this.mapper(entity);
	}
	
	/*
		Zona de Implementaciones de interfaces
	*/
	@Override
	public boolean mapper(T_User entity) 
	{
		try
		{
			this.id = entity.getId();
			this.name = entity.getName();
			this.lastName = entity.getLastName();
			this.secondLastName = entity.getSecondLastName();
			this.email = entity.getEmail();
			this.age = entity.getAge();
		}
		catch (Exception e) 
		{
			return false;
		}
		
		return true;
	}

}
