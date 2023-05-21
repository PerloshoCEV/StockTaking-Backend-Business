package com.busines.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busines.ApiRepository.Membership_Repository;
import com.busines.ApiServiceInterface.Base_ServiceInterface;
import com.busines.EntityBBDD.T_Membership;
import com.busines.Entity_DTO.Membership_Dto;

@Service
public class Membership_Service implements Base_ServiceInterface<T_Membership, Membership_Dto>
{
	@Autowired
	Membership_Repository repository;
	
	@Override
	public Membership_Dto createBaseService(T_Membership newMembership) 
	{
		T_Membership membershipToSave = repository.save(newMembership);
		
		Membership_Dto membershipDto = new Membership_Dto(membershipToSave);
		
		return membershipDto;
	}

	@Override
	public List<Membership_Dto> readBaseAllService() 
	{
		List<T_Membership> listMemberships =  repository.findAll();
		List<Membership_Dto> listMembershipsDto = new ArrayList<Membership_Dto>();
		
		for (T_Membership t_Membership : listMemberships) 
		{
			Membership_Dto membershipDto = new Membership_Dto(t_Membership);
			listMembershipsDto.add(membershipDto);
		}
		
		return listMembershipsDto;
		
	}

	@Override
	public Membership_Dto readBaseId(Long id) 
	{
		T_Membership membershipToRead = repository.getReferenceById(id);
		
		Membership_Dto membershipDto = new Membership_Dto(membershipToRead);
		
		return membershipDto;
	}

	@Override
	public Membership_Dto updateBase(T_Membership membership) 
	{
		T_Membership membershipToUpdate = repository.getReferenceById(membership.getId());
		membershipToUpdate.setAll
			(
				membership.getName(), 
				membership.getDescription(),
				membership.getPrice()
			);
		membershipToUpdate = repository.save(membershipToUpdate);
		
		Membership_Dto membershipDto = new Membership_Dto(membershipToUpdate);
		
		return membershipDto;
		
	}

	@Override
	public Membership_Dto deleteBaseId(Membership_Dto membershipToDelete) 
	{
		
		Long id = membershipToDelete.getId();
		
		try
		{
			repository.delete(repository.getReferenceById(id));
		}
		catch (Exception e)
		{
			return null;
		}
		
		return membershipToDelete;
	}

	@Override
	public Membership_Dto findBaseByIdService(Long id) 
	{
		Membership_Dto membershipDto = null;
		Optional<T_Membership> finder = repository.findById(id);
		if (finder.isPresent())
		{
			membershipDto = new Membership_Dto(finder.get());
		}
		
		return membershipDto;
	}
}
