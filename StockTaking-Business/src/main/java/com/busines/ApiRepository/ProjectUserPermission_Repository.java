package com.busines.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busines.EntityBBDD.EmbKey_ProjectUserPermission;
import com.busines.EntityBBDD.T_ProjectUserPermission;


public interface ProjectUserPermission_Repository extends JpaRepository<T_ProjectUserPermission, EmbKey_ProjectUserPermission>
{

}
