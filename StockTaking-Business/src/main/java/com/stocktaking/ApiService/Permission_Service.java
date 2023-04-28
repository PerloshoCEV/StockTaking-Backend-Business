package com.stocktaking.ApiService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.Permission_Repository;
import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_Permission;

@Service
public class Permission_Service implements Base_ServiceInterface<T_Permission>
{
	@Autowired
	Permission_Repository repository;
	
	@Override
	public T_Permission createBaseService(T_Permission newPermission) 
	{
		T_Permission permissionToSave = repository.save(newPermission);
		return permissionToSave;
	}

	@Override
	public List<T_Permission> readBaseAllService() 
	{
		return repository.findAll();
	}

	@Override
	public T_Permission readBaseId(Long id) 
	{
		return repository.getReferenceById(id);
	}

	@Override
	public T_Permission updateBase(T_Permission permission) 
	{
		T_Permission permissionToUpdated = repository.getReferenceById(permission.getId());
		permissionToUpdated.setAll
		(
				permission.getName(),
				permission.getDescription()
		);
		return repository.save(permissionToUpdated);
	}

	@Override
	public T_Permission deleteBaseId(T_Permission permissionToDelete) 
	{
		repository.delete(repository.getReferenceById(permissionToDelete.getId()));
		return permissionToDelete; 
	}

	@Override
	public Optional<T_Permission> findBaseByIdService(Long id) 
	{
		return repository.findById(id);
	}
}
