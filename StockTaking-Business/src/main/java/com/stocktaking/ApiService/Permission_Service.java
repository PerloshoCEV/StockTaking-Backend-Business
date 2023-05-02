package com.stocktaking.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.Permission_Repository;
import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_Permission;
import com.stocktaking.Entity_DTO.Permission_Dto;

@Service
public class Permission_Service implements Base_ServiceInterface<T_Permission, Permission_Dto>
{
	@Autowired
	Permission_Repository repository;
	
	@Override
	public Permission_Dto createBaseService(T_Permission newPermission) 
	{
		Permission_Dto permissionDto = null;
		try
		{
			T_Permission permissionToSave = repository.save(newPermission);
			
			permissionDto = new Permission_Dto(permissionToSave);
		}
		catch(Exception e)
		{
			
		}
		
		
		return permissionDto;
	}

	@Override
	public List<Permission_Dto> readBaseAllService() 
	{
		List<T_Permission> listPermissions =  repository.findAll();
		List<Permission_Dto> listPermissionsDto = new ArrayList<Permission_Dto>();
		
		for (T_Permission t_Permission : listPermissions) 
		{
			Permission_Dto permissionDto = new Permission_Dto(t_Permission);
			listPermissionsDto.add(permissionDto);
		}
		
		return listPermissionsDto;
	}

	@Override
	public Permission_Dto readBaseId(Long id) 
	{
		T_Permission permissionToRead = repository.getReferenceById(id);
		Permission_Dto permissionDto = null;
		
		if (permissionToRead != null)
		{
			permissionDto = new Permission_Dto(permissionToRead);
		}
		
		return permissionDto;
	}

	@Override
	public Permission_Dto updateBase(T_Permission permission) 
	{
		T_Permission permissionToUpdate = repository.getReferenceById(permission.getId());
		Permission_Dto permissionDto = null;
		
		permissionToUpdate.setAll
			(
				permission.getName(), 
				permission.getDescription()
			);
		try
		{
			permissionToUpdate = repository.save(permissionToUpdate);
			
			permissionDto = new Permission_Dto(permissionToUpdate);
		}
		catch (Exception e)
		{
			
		}
		
		
		return permissionDto;
		
	}

	@Override
	public Permission_Dto deleteBaseId(Permission_Dto permissionToDelete) 
	{
		Long id = permissionToDelete.getId();
		
		try
		{
			repository.delete(repository.getReferenceById(id));
		}
		catch (Exception e)
		{
			return null;
		}
		
		return permissionToDelete;
	}

	@Override
	public Permission_Dto findBaseByIdService(Long id) 
	{
		Permission_Dto permissionDto = null;
		Optional<T_Permission> finder = repository.findById(id);
		if (finder.isPresent())
		{
			permissionDto = new Permission_Dto(finder.get());
		}
		
		return permissionDto;
	}

}
