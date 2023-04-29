package com.stocktaking.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktaking.ApiRepository.User_Repository;
import com.stocktaking.ApiServiceInterface.Base_ServiceInterface;
import com.stocktaking.EntityBBDD.T_User;
import com.stocktaking.Entity_DTO.User_Dto;

@Service
public class User_Service implements Base_ServiceInterface<T_User, User_Dto>
{
	@Autowired
	User_Repository repository;
	
	@Override
	public User_Dto createBaseService(T_User newUser) 
	{
		T_User userToSave = repository.save(newUser);
		
		User_Dto userDto = new User_Dto(userToSave);
		
		return userDto;
	}

	@Override
	public List<User_Dto> readBaseAllService() 
	{
		List<T_User> listUsers =  repository.findAll();
		List<User_Dto> listUsersDto = new ArrayList<User_Dto>();
		
		for (T_User t_User : listUsers) 
		{
			User_Dto userDto = new User_Dto(t_User);
			listUsersDto.add(userDto);
		}
		
		return listUsersDto;
		
	}

	@Override
	public User_Dto readBaseId(Long id) 
	{
		T_User userToRead = repository.getReferenceById(id);
		
		User_Dto userDto = new User_Dto(userToRead);
		
		return userDto;
	}

	@Override
	public User_Dto updateBase(T_User user) 
	{
		T_User userToUpdate = repository.getReferenceById(user.getId());
		userToUpdate.setAll
			(
				user.getName(), 
				user.getLastName(),
				user.getSecondLastName(),
				user.getEmail(),
				user.getAge(),
				user.getPassword(),
				user.getMembership()
			);
		userToUpdate = repository.save(userToUpdate);
		
		User_Dto userDto = new User_Dto(userToUpdate);
		
		return userDto;
		
	}

	@Override
	public User_Dto deleteBaseId(User_Dto userToDelete) 
	{
		
		Long id = userToDelete.id;
		
		repository.delete(repository.getReferenceById(id));
		
		return userToDelete;
	}

	@Override
	public User_Dto findBaseByIdService(Long id) 
	{
		User_Dto userDto = null;
		Optional<T_User> finder = repository.findById(id);
		if (finder.isPresent())
		{
			userDto = new User_Dto(finder.get());
		}
		
		return userDto;
	}
}
