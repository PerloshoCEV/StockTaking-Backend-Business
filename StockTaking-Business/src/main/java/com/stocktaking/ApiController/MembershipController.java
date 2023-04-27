package com.stocktaking.ApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktaking.EntityBBDD.T_Membership;
import com.stocktaking.Response.Metadata;
import com.stocktaking.Response.ApiResponse;
import com.stocktaking.ApiControllerInterface.MembershipControllerInterface;
import com.stocktaking.ApiService.MembershipService;

@RestController
public class MembershipController implements MembershipControllerInterface
{
	@Autowired
	MembershipService membershipService;

	public MembershipController()
	{
		super();
	}
	
	@Override
	@PostMapping(path = "/membership")
	public ApiResponse<T_Membership> createEntityController(T_Membership newMembership) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_Membership> response = new ApiResponse<T_Membership>(meta);
				
		if (newMembership != null)
		{
			// Si no tiene id
			if(newMembership.getId() == null)
			{
				response.setResponse(membershipService.createBaseService(newMembership));
			}
		}
		return response;
	}

	@Override
	@GetMapping(path = "/allmemberships")
	public ApiResponse<List<T_Membership>> readAllEntityController() 
	{
		Metadata meta = new Metadata();
		ApiResponse<List<T_Membership>> response = 
			new ApiResponse<List<T_Membership>>
				(membershipService.readBaseAllService(), meta);
		
		return response;
	}

	@Override
	@GetMapping(path = "/membership")
	public ApiResponse<T_Membership> readEntityIdController(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_Membership> response = new ApiResponse<T_Membership>(meta);

		
		if(membershipService.findBaseByIdService(id).isPresent())
		{
			response.setResponse(membershipService.findBaseByIdService(id).get());
		}
		return response;
	}

	@PutMapping(path = "/membership")
	@Override
	public ApiResponse<T_Membership> updateEntityController(T_Membership membershipToModify) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_Membership> response = new ApiResponse<T_Membership>(meta);
		
		if(membershipService.findBaseByIdService(membershipToModify.getId()).isPresent())
		{
			response.setResponse(membershipService.updateBase(membershipToModify));
		}
		
		return response;
	}

	@Override
	@DeleteMapping(path = "/membership")
	public ApiResponse<T_Membership> deleteEntityId(Long id) 
	{
		Metadata meta = new Metadata();
		ApiResponse<T_Membership> response = new ApiResponse<T_Membership>(meta);
		
		if(id != null)
		{
			if (membershipService.findBaseByIdService(id).isPresent())
			{
				T_Membership membershipToDelete = membershipService.findBaseByIdService(id).get();
				
				response.setResponse(membershipService.deleteBaseId(membershipToDelete));
			}
		}
		return response;
	}

}
