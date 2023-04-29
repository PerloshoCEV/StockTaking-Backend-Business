package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_User;
import com.stocktaking.Entity_DTO.User_Dto;

@RequestMapping("/stocktaking")
public interface User_ControllerInterface  extends Base_ControllerInterface<T_User, User_Dto>
{
	
}
