package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_User;

public interface User_Repository extends JpaRepository<T_User, Long>
{

}
