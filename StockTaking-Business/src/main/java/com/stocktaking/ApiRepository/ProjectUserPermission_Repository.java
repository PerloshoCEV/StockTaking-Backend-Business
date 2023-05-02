package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.EmbKey_ProjectUserPermission;
import com.stocktaking.EntityBBDD.T_ProjectUserPermission;


public interface ProjectUserPermission_Repository extends JpaRepository<T_ProjectUserPermission, EmbKey_ProjectUserPermission>
{

}
