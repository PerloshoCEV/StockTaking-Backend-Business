package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Permission;

public interface PermissionRepository extends JpaRepository<T_Permission, Long>
{

}
