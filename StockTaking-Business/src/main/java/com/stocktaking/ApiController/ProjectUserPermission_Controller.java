package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.ProjectUserPermission_ControllerInterface;
import com.stocktaking.ApiService.Permission_Service;
import com.stocktaking.ApiService.ProjectUserPermission_Service;
import com.stocktaking.ApiService.Project_Service;
import com.stocktaking.ApiService.User_Service;
import com.stocktaking.Entity_DTO.ProjectUserPermission_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
@RequestMapping("/busines")
public class ProjectUserPermission_Controller implements ProjectUserPermission_ControllerInterface
{
	@Autowired
	ProjectUserPermission_Service projectUserPermissionService;
	@Autowired
	Project_Service projectService;
	@Autowired
	User_Service userService;
	@Autowired
	Permission_Service permissionService;
	
	public ProjectUserPermission_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/projectUserPermission")
	public ApiResponse<ProjectUserPermission_Dto> createEntityController(ProjectUserPermission_Dto newProyectUserPermission) 
	{
		Metadata meta = new Metadata();
		ApiResponse<ProjectUserPermission_Dto> response = new ApiResponse<ProjectUserPermission_Dto>(meta);
		
		boolean AllCheckValid = true;
		Long projectId = newProyectUserPermission.getProjectId();
		Long userId = newProyectUserPermission.getUserId();
		Long permissionId = newProyectUserPermission.getPermissionId();
		Integer level = newProyectUserPermission.getLevel();
		
		/*
			Chequeos de valores
		*/
		// Compruebo el proyecto:
		if (projectId != null) // Si se ha introducido el proyecto
		{
			// Si no existe el proyecto:
			if (projectService.findBaseByIdService(projectId) == null)
			{
				AllCheckValid = false;
			}
		}
		else // Si no se ha introducido el proyecto
		{
			AllCheckValid = false;
		}
		
		// Compruebo el usuario:
		if (userId != null) // Si no se ha introducido el usuario
		{
			// Si no existe el usuario
			if (userService.findBaseByIdService(userId) == null)
			{
				AllCheckValid = false;
			}
		}
		else // Si no se ha introducido el usuario
		{
			AllCheckValid = false;
		}
		
		// Compruebo el permiso
		if (permissionId != null) // Si se ha introducido el permiso
		{
			// Si no existe el permiso
			if (permissionService.findBaseByIdService(permissionId) == null)
			{
				AllCheckValid = false;
			}
		}
		else // Si no se ha introducido el permiso
		{
			AllCheckValid = false;
		}
		
		// Compruebo el nivel
		if (level == null || level == -1 ) // Si no se ha introducido el nivel:
		{
			level = 0;
		}
		/*
			Si sigue siendo valida la comprobación:
		*/
		if (AllCheckValid)
		{
			response.setResponse(projectUserPermissionService.createService(projectId, userId, permissionId, level));
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
		
	}

	@Override
	@GetMapping(path = "/allProjectUserPermissions")
	public ApiResponse<List<ProjectUserPermission_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<ProjectUserPermission_Dto>> response = 
			new ApiResponse<List<ProjectUserPermission_Dto>>
				(projectUserPermissionService.readAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/projectUserPermission")
	public ApiResponse<ProjectUserPermission_Dto> readEntityIdController(ProjectUserPermission_Dto id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<ProjectUserPermission_Dto> response = new ApiResponse<ProjectUserPermission_Dto>(meta);

		response.setResponse(projectUserPermissionService.readById(id));

		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		return response;
	}

	@PutMapping(path = "/projectUserPermission")
	@Override
	public ApiResponse<ProjectUserPermission_Dto> updateEntityController(ProjectUserPermission_Dto userPermissionToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<ProjectUserPermission_Dto> response = new ApiResponse<ProjectUserPermission_Dto>(meta);
		
		response.setResponse(projectUserPermissionService.update(userPermissionToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		return response;
	}

	@Override
	@DeleteMapping(path = "/projectUserPermission")
	public ApiResponse<ProjectUserPermission_Dto> deleteEntityId(ProjectUserPermission_Dto id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<ProjectUserPermission_Dto> response = new ApiResponse<ProjectUserPermission_Dto>(meta);
		
		if(id != null)
		{
			response.setResponse(projectUserPermissionService.deleteId(id));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}
}
