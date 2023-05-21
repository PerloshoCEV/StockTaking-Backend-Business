package com.busines.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.busines.EntityBBDD.T_Membership;
import com.busines.Entity_DTO.Membership_Dto;

@RequestMapping("/busines")
public interface Membership_ControllerInterface extends Base_ControllerInterface<T_Membership, Membership_Dto>
{

}
