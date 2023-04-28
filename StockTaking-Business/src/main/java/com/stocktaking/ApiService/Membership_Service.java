package com.stocktaking.ApiService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_Membership;
import com.stocktaking.ApiRepository.Membership_Repository;

@Service
public class Membership_Service implements Base_ServiceInterface<T_Membership>
{
	@Autowired
	Membership_Repository repository;
	
	@Override
	public T_Membership createBaseService(T_Membership newMembership) 
	{
		T_Membership membershipToSave = repository.save(newMembership);
		return membershipToSave;
	}

	@Override
	public List<T_Membership> readBaseAllService() 
	{
		return repository.findAll();
	}

	@Override
	public T_Membership readBaseId(Long id) 
	{
		return repository.getReferenceById(id);
	}

	@Override
	public T_Membership updateBase(T_Membership membership) 
	{
		T_Membership membershipToUpdated = repository.getReferenceById(membership.getId());
		membershipToUpdated.setAll
			(
					membership.getName(),
					membership.getPrice()
			);
		return repository.save(membershipToUpdated);
	}

	@Override
	public T_Membership deleteBaseId(T_Membership membershipToDelete) 
	{
		repository.delete(repository.getReferenceById(membershipToDelete.getId()));
		return membershipToDelete; 
	}

	@Override
	public Optional<T_Membership> findBaseByIdService(Long id) 
	{
		return repository.findById(id);
	}
	
}