package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.EmbKey_User_Permission;
import com.stocktaking.EntityBBDD.T_User_Permission;


public interface UserPermission_Repository extends JpaRepository<T_User_Permission, EmbKey_User_Permission>
{

}
