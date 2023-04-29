package com.stocktaking.ApiService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.UserPermission_Repository;
import com.stocktaking.ApiRepository.UserPermission_SQL_Repository;
import com.stocktaking.EntityBBDD.EmbKey_User_Permission;
import com.stocktaking.EntityBBDD.T_UserPermission;

@Service
public class UserPermission_Service 
{
	@Autowired
	UserPermission_Repository repositoryJpa;
	
	@Autowired
	UserPermission_SQL_Repository repositorySql;
	
	public T_UserPermission createBaseService(T_UserPermission newUserPermission) 
	{
		Long userId = newUserPermission.getUser().getId();
		Long permissionId = newUserPermission.getPermission().getId();
		int level = newUserPermission.getLevel();
		
		T_UserPermission userPermissionToSave = repositorySql.insert(userId, permissionId, level);
		return userPermissionToSave;
	}

	public List<T_UserPermission> readBaseAllService() 
	{
		return repositoryJpa.findAll();
	}

	public T_UserPermission readBaseId(EmbKey_User_Permission id) 
	{
		return repositoryJpa.getReferenceById(id);
	}

	public T_UserPermission updateBase(T_UserPermission userPermission) 
	{
		T_UserPermission userPermissionToUpdated = repositoryJpa.getReferenceById(userPermission.getId());
		/*
		userPermissionToUpdated.setAll
			(
					userPermission.getName(),
					userPermission.getPrice()
			);
			*/
		return repositoryJpa.save(userPermissionToUpdated);
	}

	public T_UserPermission deleteBaseId(T_UserPermission userPermissionToDelete) 
	{
		repositoryJpa.delete(repositoryJpa.getReferenceById(userPermissionToDelete.getId()));
		return userPermissionToDelete; 
	}

	public Optional<T_UserPermission> findBaseByIdService(EmbKey_User_Permission id) 
	{
		return repositoryJpa.findById(id);
	}
}
