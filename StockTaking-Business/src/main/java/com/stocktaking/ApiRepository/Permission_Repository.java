package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Permission;

public interface Permission_Repository extends JpaRepository<T_Permission, Long>
{

}
