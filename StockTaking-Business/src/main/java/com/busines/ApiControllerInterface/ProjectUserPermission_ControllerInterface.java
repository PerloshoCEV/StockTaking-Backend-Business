package com.busines.ApiControllerInterface;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.busines.Entity_DTO.ProjectUserPermission_Dto;
import com.busines.Response.ApiResponse;

public interface ProjectUserPermission_ControllerInterface 
{
	ApiResponse<ProjectUserPermission_Dto> createEntityController(@RequestBody ProjectUserPermission_Dto newProjectUserPermission) ;
	ApiResponse<List<ProjectUserPermission_Dto>> readAllEntityController();
	ApiResponse<ProjectUserPermission_Dto> readEntityIdController(@RequestBody ProjectUserPermission_Dto id);
	ApiResponse<ProjectUserPermission_Dto> updateEntityController(@RequestBody ProjectUserPermission_Dto modifyProjectUserPermission);
	ApiResponse<ProjectUserPermission_Dto> deleteEntityId(@RequestBody ProjectUserPermission_Dto id);
	
}
