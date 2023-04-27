package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stocktaking.EntityBBDD.T_Membership;

@RequestMapping("/stocktaking")
public interface MembershipControllerInterface extends BaseControllerInterface<T_Membership>
{

}
