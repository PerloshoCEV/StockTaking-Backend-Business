package com.stocktaking.ApiRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_User;

public interface User_Repository extends JpaRepository<T_User, Long>
{
	Optional<T_User> findByEmail(String email);

	Optional<T_User> findByEmailAndPassword(String email, String password);
}
