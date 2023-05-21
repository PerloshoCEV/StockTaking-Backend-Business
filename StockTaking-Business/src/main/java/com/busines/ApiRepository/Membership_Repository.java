package com.busines.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busines.EntityBBDD.T_Membership;

public interface Membership_Repository extends JpaRepository<T_Membership, Long>
{

}
