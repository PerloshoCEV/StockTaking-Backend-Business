package com.stocktaking.Service;

import org.springframework.stereotype.Service;

import com.stocktaking.EntityBBDD.T_Membership;
import com.stocktaking.EntityInterface.EntityBaseInterface;
import com.stocktaking.Repository.BaseRepository;

/*
	Servicio genérico para cualquier clase base.
*/
@Service
public class BaseService <T>
{
	// Repositorio genérico
	BaseRepository<T> baseRepository;
	EntityBaseInterface<T> entitybase;
	
	public BaseService (BaseRepository<T> repository)
	{
		this.baseRepository = repository;
	}
	
	public T createBaseService( T member)
	{
		T entityToSave = baseRepository.save(member);
		return entityToSave;
	}
}
