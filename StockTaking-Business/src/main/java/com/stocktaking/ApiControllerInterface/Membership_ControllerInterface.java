package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_Membership;
import com.stocktaking.Entity_DTO.Membership_Dto;

@RequestMapping("/stocktaking")
public interface Membership_ControllerInterface extends Base_ControllerInterface<T_Membership, Membership_Dto>
{

}
