package com.busines.Entity_DTO;

import com.busines.EntityBBDD.T_Membership;
import com.busines.EntityBBDD.T_User;
import com.busines.Mapper.MapperInterface;

public class User_Dto implements MapperInterface<T_User>
{
	/*
		Zona de Atributos
	*/
	private Long id;
	private String name;
	private String lastName;
	private String secondLastName;
	private String email;
	private Integer age;
	private T_Membership membership;
	
	/*
		Zona de Constructores
	*/
	public User_Dto ()
	{
		
	}
	
	public User_Dto
	(
		Long id, 
		String name, 
		String lastName, 
		String secondLastName, 
		String email, 
		Integer age,
		T_Membership membership
	) 
	{
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.email = email;
		this.age = age;
		this.membership = membership;
	}

	public User_Dto (T_User entity)
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

	public T_Membership getMembership() {
		return membership;
	}

	public void setMembership(T_Membership membership) {
		this.membership = membership;
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
			this.membership = entity.getMembership();
		}
		catch (Exception e) 
		{
			return false;
		}
		
		return true;
	}
	

}
