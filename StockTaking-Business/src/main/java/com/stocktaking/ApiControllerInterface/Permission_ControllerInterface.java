package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_Permission;
import com.stocktaking.Entity_DTO.Permission_Dto;

@RequestMapping("/busines")
public interface Permission_ControllerInterface extends Base_ControllerInterface<T_Permission, Permission_Dto>
{
	
}
