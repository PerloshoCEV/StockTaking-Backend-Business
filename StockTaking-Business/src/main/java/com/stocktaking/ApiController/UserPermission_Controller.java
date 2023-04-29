package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.UserPermission_ControllerInterface;
import com.stocktaking.ApiService.UserPermission_Service;
import com.stocktaking.EntityBBDD.EmbKey_User_Permission;
import com.stocktaking.EntityBBDD.T_UserPermission;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
@RequestMapping("/stocktaking")
public class UserPermission_Controller implements UserPermission_ControllerInterface
{
	@Autowired
	UserPermission_Service userPermissionService;

	public UserPermission_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/userPermission")
	public ApiResponse<T_UserPermission> createEntityController(T_UserPermission newUserPermission) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_UserPermission> response = new ApiResponse<T_UserPermission>(meta);
				
		if (newUserPermission != null)
		{
			// Si no tiene id
			if(newUserPermission.getId() == null)
			{
				response.setResponse(userPermissionService.createBaseService(newUserPermission));
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/alluserPermissions")
	public ApiResponse<List<T_UserPermission>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<T_UserPermission>> response = 
			new ApiResponse<List<T_UserPermission>>
				(userPermissionService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/userPermission")
	public ApiResponse<T_UserPermission> readEntityIdController(EmbKey_User_Permission id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_UserPermission> response = new ApiResponse<T_UserPermission>(meta);

		
		if(userPermissionService.findBaseByIdService(id).isPresent())
		{
			response.setResponse(userPermissionService.findBaseByIdService(id).get());
		}
		return response;
	}

	@PutMapping(path = "/userPermission")
	@Override
	public ApiResponse<T_UserPermission> updateEntityController(T_UserPermission userPermissionToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_UserPermission> response = new ApiResponse<T_UserPermission>(meta);
		
		if(userPermissionService.findBaseByIdService(userPermissionToModify.getId()).isPresent())
		{
			response.setResponse(userPermissionService.updateBase(userPermissionToModify));
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/userPermission")
	public ApiResponse<T_UserPermission> deleteEntityId(EmbKey_User_Permission id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_UserPermission> response = new ApiResponse<T_UserPermission>(meta);
		
		if(id != null)
		{
			if (userPermissionService.findBaseByIdService(id).isPresent())
			{
				T_UserPermission userPermissionToDelete = userPermissionService.findBaseByIdService(id).get();
				
				response.setResponse(userPermissionService.deleteBaseId(userPermissionToDelete));
			}
		}
		return response;
	}
}
