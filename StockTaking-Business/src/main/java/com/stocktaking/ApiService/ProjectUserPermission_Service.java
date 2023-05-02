package com.stocktaking.ApiService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.ProjectUserPermission_Repository;
import com.stocktaking.ApiRepository.ProjectUserPermission_SQL_Repository;
import com.stocktaking.EntityBBDD.T_ProjectUserPermission;
import com.stocktaking.Entity_DTO.ProjectUserPermission_Dto;

@Service
public class ProjectUserPermission_Service 
{
	@Autowired
	ProjectUserPermission_Repository repositoryJpa;
	
	@Autowired
	ProjectUserPermission_SQL_Repository repositorySql;
	
	/*
		Método CreateService.
	*/
	public ProjectUserPermission_Dto createService(Long projectId, Long userId, Long permissionId, int level) 
	{
		ProjectUserPermission_Dto userPermissionToSave = null;
		try
		{
			userPermissionToSave = repositorySql.insert(projectId, userId, permissionId, level);
		}
		catch (Exception e)
		{
			e.printStackTrace(); // Muestro por consola la pila detallada de errores.
		}
		
		return userPermissionToSave;
	}

	/*
		Método readBaseAllService.
	*/
	public List<ProjectUserPermission_Dto> readAllService() 
	{
		List<T_ProjectUserPermission> listSql = repositoryJpa.findAll();
		List<ProjectUserPermission_Dto> listDto = new ArrayList<ProjectUserPermission_Dto>();
		
		for (T_ProjectUserPermission t_ProjectUserPermission : listSql) 
		{
			listDto.add(new ProjectUserPermission_Dto(t_ProjectUserPermission));
		}
		
		return listDto;
	}

	public ProjectUserPermission_Dto readById(ProjectUserPermission_Dto id) 
	{
		return repositorySql.findById(id.getProjectId(), id.getUserId(), id.getPermissionId());
	}

	public ProjectUserPermission_Dto update(ProjectUserPermission_Dto modifyEntity) 
	{
		return repositorySql.update
					(
						modifyEntity.getProjectId(), 
						modifyEntity.getUserId(), 
						modifyEntity.getPermissionId(), 
						modifyEntity.getLevel()
					);
	}

	public ProjectUserPermission_Dto deleteId(ProjectUserPermission_Dto deleteEntity) 
	{
		return repositorySql.delete(deleteEntity.getProjectId(), deleteEntity.getUserId(), deleteEntity.getPermissionId());
	}

}
