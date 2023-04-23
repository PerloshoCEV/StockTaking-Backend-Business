package com.stocktaking.Repository;

import java.util.Optional;

import com.stocktaking.EntityBBDD.T_User;

public interface User_Repository extends BaseRepository<T_User>
{

	Optional<T_User> findByEmail(String email);

	Optional<T_User> findByEmailAndPassword(String email, String password);

}
