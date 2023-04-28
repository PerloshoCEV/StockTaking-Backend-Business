package com.stocktaking.ApiService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.User_Repository;
import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_User;

@Service
public class User_Service implements Base_ServiceInterface<T_User>
{
	@Autowired
	User_Repository repository;
	
	@Override
	public T_User createBaseService(T_User newUser) 
	{
		T_User userToSave = repository.save(newUser);
		return userToSave;
	}

	@Override
	public List<T_User> readBaseAllService() 
	{
		return repository.findAll();
	}

	@Override
	public T_User readBaseId(Long id) 
	{
		return repository.getReferenceById(id);
	}

	@Override
	public T_User updateBase(T_User user) 
	{
		T_User userToUpdated = repository.getReferenceById(user.getId());
		userToUpdated.setAll
			(
				user.getName(), 
				user.getLastName(),
				user.getSecondLastName(),
				user.getEmail(),
				user.getAge(),
				user.getPassword(),
				user.getMembership()
			);
		return repository.save(userToUpdated);
	}

	@Override
	public T_User deleteBaseId(T_User userToDelete) 
	{
		repository.delete(repository.getReferenceById(userToDelete.getId()));
		return userToDelete; 
	}

	@Override
	public Optional<T_User> findBaseByIdService(Long id) 
	{
		return repository.findById(id);
	}

}
