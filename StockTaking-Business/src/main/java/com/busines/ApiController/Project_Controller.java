package com.busines.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busines.ApiControllerInterface.Project_ControllerInterface;
import com.busines.ApiService.Project_Service;
import com.busines.EntityBBDD.T_Project;
import com.busines.Entity_DTO.Project_Dto;
import com.busines.Enum.MessageResult;
import com.busines.Response.ApiResponse;
import com.busines.Response.Metadata;

@RestController
@RequestMapping("/busines")
public class Project_Controller implements Project_ControllerInterface
{
	@Autowired
	Project_Service projectService;
	
	public Project_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/project")
	public ApiResponse<Project_Dto> createEntityController(T_Project newProject) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Project_Dto> response = new ApiResponse<Project_Dto>(meta);
				
		if (newProject != null)
		{
			// Si no tiene id
			if(newProject.getId() == null)
			{
				response.setResponse(projectService.createBaseService(newProject));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allprojects")
	public ApiResponse<List<Project_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<Project_Dto>> response = 
			new ApiResponse<List<Project_Dto>>
				(projectService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/project")
	public ApiResponse<Project_Dto> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Project_Dto> response = new ApiResponse<Project_Dto>(meta);

		response.setResponse(projectService.findBaseByIdService(id));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@PutMapping(path = "/project")
	@Override
	public ApiResponse<Project_Dto> updateEntityController(T_Project projectToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Project_Dto> response = new ApiResponse<Project_Dto>(meta);
		
		response.setResponse(projectService.updateBase(projectToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/project")
	public ApiResponse<Project_Dto> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Project_Dto> response = new ApiResponse<Project_Dto>(meta);
		
		
		if(id != null)
		{
			if (projectService.findBaseByIdService(id) != null)
			{
				Project_Dto projectToDelete = projectService.findBaseByIdService(id);
				
				response.setResponse(projectService.deleteBaseId(projectToDelete));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}
}
