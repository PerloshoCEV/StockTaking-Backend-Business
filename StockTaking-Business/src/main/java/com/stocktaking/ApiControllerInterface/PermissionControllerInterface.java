package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_Permission;

@RequestMapping("/stocktaking")
public interface PermissionControllerInterface extends BaseControllerInterface<T_Permission>
{
	
}
