package com.busines.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busines.EntityBBDD.T_Permission;

public interface Permission_Repository extends JpaRepository<T_Permission, Long>
{

}
