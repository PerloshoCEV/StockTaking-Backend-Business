package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.Permission_ControllerInterface;
import com.stocktaking.ApiService.Permission_Service;
import com.stocktaking.EntityBBDD.T_Permission;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

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
	public ApiResponse<T_Permission> createEntityController(T_Permission newPermission) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_Permission> response = new ApiResponse<T_Permission>(meta);
				
		if (newPermission != null)
		{
			// Si no tiene id
			if(newPermission.getId() == null)
			{
				response.setResponse(permissionService.createBaseService(newPermission));
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allpermissions")
	public ApiResponse<List<T_Permission>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<T_Permission>> response = 
			new ApiResponse<List<T_Permission>>
				(permissionService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/permission")
	public ApiResponse<T_Permission> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_Permission> response = new ApiResponse<T_Permission>(meta);

		
		if(permissionService.findBaseByIdService(id).isPresent())
		{
			response.setResponse(permissionService.findBaseByIdService(id).get());
		}
		return response;
	}

	@PutMapping(path = "/permission")
	@Override
	public ApiResponse<T_Permission> updateEntityController(T_Permission permissionToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_Permission> response = new ApiResponse<T_Permission>(meta);
		
		if(permissionService.findBaseByIdService(permissionToModify.getId()).isPresent())
		{
			response.setResponse(permissionService.updateBase(permissionToModify));
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/permission")
	public ApiResponse<T_Permission> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_Permission> response = new ApiResponse<T_Permission>(meta);
		
		if(id != null)
		{
			if (permissionService.findBaseByIdService(id).isPresent())
			{
				T_Permission permissionToDelete = permissionService.findBaseByIdService(id).get();
				
				response.setResponse(permissionService.deleteBaseId(permissionToDelete));
			}
		}
		return response;
	}

}
