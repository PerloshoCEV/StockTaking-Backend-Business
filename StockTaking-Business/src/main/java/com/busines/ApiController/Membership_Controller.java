package com.busines.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busines.ApiControllerInterface.Membership_ControllerInterface;
import com.busines.ApiService.Membership_Service;
import com.busines.EntityBBDD.T_Membership;
import com.busines.Entity_DTO.Membership_Dto;
import com.busines.Enum.MessageResult;
import com.busines.Response.ApiResponse;
import com.busines.Response.Metadata;

@RestController
public class Membership_Controller implements Membership_ControllerInterface
{
	@Autowired
	Membership_Service membershipService;

	public Membership_Controller()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/membership")
	public ApiResponse<Membership_Dto> createEntityController(T_Membership newMembership) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Membership_Dto> response = new ApiResponse<Membership_Dto>(meta);
				
		if (newMembership != null)
		{
			// Si no tiene id
			if(newMembership.getId() == null)
			{
				response.setResponse(membershipService.createBaseService(newMembership));
				
				if (response.getResponse() != null)
				{
					response.setMessage(MessageResult.Success);
				}
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allmemberships")
	public ApiResponse<List<Membership_Dto>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<Membership_Dto>> response = 
			new ApiResponse<List<Membership_Dto>>
				(membershipService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/membership")
	public ApiResponse<Membership_Dto> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Membership_Dto> response = new ApiResponse<Membership_Dto>(meta);

		response.setResponse(membershipService.findBaseByIdService(id));

		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@PutMapping(path = "/membership")
	@Override
	public ApiResponse<Membership_Dto> updateEntityController(T_Membership membershipToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Membership_Dto> response = new ApiResponse<Membership_Dto>(meta);
		
		response.setResponse(membershipService.updateBase(membershipToModify));
		
		if (response.getResponse() != null)
		{
			response.setMessage(MessageResult.Success);
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/membership")
	public ApiResponse<Membership_Dto> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<Membership_Dto> response = new ApiResponse<Membership_Dto>(meta);
		
		
		if(id != null)
		{
			Membership_Dto membershipToDelete = membershipService.findBaseByIdService(id);
				
			response.setResponse(membershipService.deleteBaseId(membershipToDelete));
			
			if (response.getResponse() != null)
			{
				response.setMessage(MessageResult.Success);
			}
		}
		return response;
	}
}
