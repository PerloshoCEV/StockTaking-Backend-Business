package com.busines.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busines.ApiRepository.Project_Repository;
import com.busines.ApiServiceInterface.Base_ServiceInterface;
import com.busines.EntityBBDD.T_Project;
import com.busines.Entity_DTO.Project_Dto;

@Service
public class Project_Service implements Base_ServiceInterface<T_Project, Project_Dto>
{
	@Autowired
	Project_Repository repository;
	
	@Override
	public Project_Dto createBaseService(T_Project newProject) 
	{
		Project_Dto projectDto = null;
		try
		{
			T_Project projectToSave = repository.save(newProject);
			
			projectDto = new Project_Dto(projectToSave);
		}
		catch(Exception e)
		{
			
		}
		
		return projectDto;
	}

	@Override
	public List<Project_Dto> readBaseAllService() 
	{
		List<T_Project> listProjects =  repository.findAll();
		List<Project_Dto> listProjectsDto = new ArrayList<Project_Dto>();
		
		for (T_Project t_Project : listProjects) 
		{
			Project_Dto projectDto = new Project_Dto(t_Project);
			listProjectsDto.add(projectDto);
		}
		
		return listProjectsDto;
		
	}

	@Override
	public Project_Dto readBaseId(Long id) 
	{
		T_Project projectToRead = repository.getReferenceById(id);
		Project_Dto projectDto = null;
		
		if (projectToRead != null)
		{
			projectDto = new Project_Dto(projectToRead);
		}
		
		return projectDto;
	}

	@Override
	public Project_Dto updateBase(T_Project project) 
	{
		T_Project projectToUpdate = repository.getReferenceById(project.getId());
		Project_Dto projectDto = null;
		projectToUpdate.setAll
			(
				project.getName(), 
				project.getDescription(),
				project.getUrl()
				
			);
		try
		{
			projectToUpdate = repository.save(projectToUpdate);
			
			projectDto = new Project_Dto(projectToUpdate);
		}
		catch(Exception e)
		{
			
		}
				
		return projectDto;
		
	}

	@Override
	public Project_Dto deleteBaseId(Project_Dto projectToDelete) 
	{
		
		Long id = projectToDelete.getId();
		
		try
		{
			repository.delete(repository.getReferenceById(id));
		}
		catch (Exception e)
		{
			return null;
		}
		
		return projectToDelete;
	}

	@Override
	public Project_Dto findBaseByIdService(Long id) 
	{
		Project_Dto projectDto = null;
		Optional<T_Project> finder = repository.findById(id);
		if (finder.isPresent())
		{
			projectDto = new Project_Dto(finder.get());
		}
		
		return projectDto;
	}
}
