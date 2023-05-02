package com.stocktaking.ApiController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.ApiControllerInterface.User_ControllerInterface;
import com.stocktaking.ApiService.User_Service;
import com.stocktaking.EntityBBDD.T_User;
import com.stocktaking.Entity_DTO.User_Dto;
import com.stocktaking.Enum.MessageResult;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.Response.Metadata;

@RestController
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
	public ApiResponse<User_Dto> createEntityController(T_User newUser) 
	{
		Metadata meta = new Metadata();
		ApiResponse<User_Dto> response = new ApiResponse<User_Dto>(meta);
				
		if (newUser != null)
		{
			// Si no tiene id
			if(newUser.getId() == null)
			{
				response.setResponse(userService.createBaseService(newUser));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allusers")
	public ApiResponse<List<User_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<User_Dto>> response = 
			new ApiResponse<List<User_Dto>>
				(userService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/user")
	public ApiResponse<User_Dto> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<User_Dto> response = new ApiResponse<User_Dto>(meta);

		response.setResponse(userService.findBaseByIdService(id));

		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@PutMapping(path = "/user")
	@Override
	public ApiResponse<User_Dto> updateEntityController(T_User userToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<User_Dto> response = new ApiResponse<User_Dto>(meta);
		
		response.setResponse(userService.updateBase(userToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		return response;
	}

	@Override
	@DeleteMapping(path = "/user")
	public ApiResponse<User_Dto> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<User_Dto> response = new ApiResponse<User_Dto>(meta);
		
		
		if(id != null)
		{
			User_Dto userToDelete = userService.findBaseByIdService(id);
				
			response.setResponse(userService.deleteBaseId(userToDelete));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}
	
	@Override
	public ApiResponse<User_Dto> LogInController(String email, String password)
	{
		Metadata meta = new Metadata();
		ApiResponse<User_Dto> response = new ApiResponse<User_Dto>(meta);
		Optional<T_User> user = userService.findUserByEmailPasswordService(email, password);
		if(user.isPresent())
		{
			User_Dto userDto = new User_Dto(user.get());
			response.setResponse(userDto);
			response.setMessage(MessageResult.Success);;
		}
		return response;
	}
	
	@Override
	public ApiResponse<User_Dto> SignUpController(String email, String password)
	{
		Metadata meta = new Metadata();
		ApiResponse<User_Dto> response = new ApiResponse<User_Dto>(meta);
		Optional<T_User> user = userService.findUserByEmailPasswordService(email, password);
		if(user.isPresent())
		{
			response.setMessage(MessageResult.EntityExist);
		}
		else
		{
			T_User newUser = new T_User();
			User_Dto userDto;
			newUser.setAll
			(
				"", // Nombre
				"", // Apellido
				"", //Segundo apellido
				email, // email
				0, // edad
				password, // Password
				null // Membership
			);
			newUser.setPermissions(new ArrayList<>());
			userService.createBaseService(newUser);
			
			userDto = new User_Dto(newUser);
			
			response.setResponse(userDto);
			response.setMessage(MessageResult.Success);
		}
		return response;
	}
}
