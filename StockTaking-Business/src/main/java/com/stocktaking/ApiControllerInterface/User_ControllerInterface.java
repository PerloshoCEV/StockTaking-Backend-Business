package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_User;

@RequestMapping("/stocktaking")
public interface User_ControllerInterface  extends Base_ControllerInterface<T_User>
{
	
}
