package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Membership;

public interface MembershipRepository extends JpaRepository<T_Membership, Long>
{

}
