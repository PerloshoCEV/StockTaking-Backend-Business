package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_User;

@RequestMapping("/stocktaking")
public interface UserControllerInterface  extends BaseControllerInterface<T_User>
{
	
}
