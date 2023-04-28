package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.stocktaking.ApiControllerInterface.User_ControllerInterface;
import com.stocktaking.ApiService.User_Service;
import com.stocktaking.EntityBBDD.T_User;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

public class User_Controller implements User_ControllerInterface
{
	@Autowired
	User_Service userService;
	
	public User_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/user")
	public ApiResponse<T_User> createEntityController(T_User newUser) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_User> response = new ApiResponse<T_User>(meta);
				
		if (newUser != null)
		{
			// Si no tiene id
			if(newUser.getId() == null)
			{
				response.setResponse(userService.createBaseService(newUser));
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allusers")
	public ApiResponse<List<T_User>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<T_User>> response = 
			new ApiResponse<List<T_User>>
				(userService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/user")
	public ApiResponse<T_User> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_User> response = new ApiResponse<T_User>(meta);

		
		if(userService.findBaseByIdService(id).isPresent())
		{
			response.setResponse(userService.findBaseByIdService(id).get());
		}
		return response;
	}

	@PutMapping(path = "/user")
	@Override
	public ApiResponse<T_User> updateEntityController(T_User userToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_User> response = new ApiResponse<T_User>(meta);
		
		if(userService.findBaseByIdService(userToModify.getId()).isPresent())
		{
			response.setResponse(userService.updateBase(userToModify));
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/user")
	public ApiResponse<T_User> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_User> response = new ApiResponse<T_User>(meta);
		
		if(id != null)
		{
			if (userService.findBaseByIdService(id).isPresent())
			{
				T_User userToDelete = userService.findBaseByIdService(id).get();
				
				response.setResponse(userService.deleteBaseId(userToDelete));
			}
		}
		return response;
	}


}
