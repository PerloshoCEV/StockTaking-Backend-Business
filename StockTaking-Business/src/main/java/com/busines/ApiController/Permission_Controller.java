package com.busines.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busines.ApiControllerInterface.Permission_ControllerInterface;
import com.busines.ApiService.Permission_Service;
import com.busines.EntityBBDD.T_Permission;
import com.busines.Entity_DTO.Permission_Dto;
import com.busines.Enum.MessageResult;
import com.busines.Response.ApiResponse;
import com.busines.Response.Metadata;

@RestController
public class Permission_Controller implements Permission_ControllerInterface
{
	@Autowired
	Permission_Service permissionService;
	
	public Permission_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/permission")
	public ApiResponse<Permission_Dto> createEntityController(T_Permission newPermission) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Permission_Dto> response = new ApiResponse<Permission_Dto>(meta);
				
		if (newPermission != null)
		{
			// Si no tiene id
			if(newPermission.getId() == null)
			{
				response.setResponse(permissionService.createBaseService(newPermission));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allpermissions")
	public ApiResponse<List<Permission_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<Permission_Dto>> response = 
			new ApiResponse<List<Permission_Dto>>
				(permissionService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/permission")
	public ApiResponse<Permission_Dto> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Permission_Dto> response = new ApiResponse<Permission_Dto>(meta);

		response.setResponse(permissionService.findBaseByIdService(id));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@PutMapping(path = "/permission")
	@Override
	public ApiResponse<Permission_Dto> updateEntityController(T_Permission permissionToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Permission_Dto> response = new ApiResponse<Permission_Dto>(meta);
		
		response.setResponse(permissionService.updateBase(permissionToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		return response;
	}

	@Override
	@DeleteMapping(path = "/permission")
	public ApiResponse<Permission_Dto> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Permission_Dto> response = new ApiResponse<Permission_Dto>(meta);
		
		if(id != null)
		{
			if (permissionService.findBaseByIdService(id) != null)
			{
				Permission_Dto permissionToDelete = permissionService.findBaseByIdService(id);
				
				response.setResponse(permissionService.deleteBaseId(permissionToDelete));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}
}
