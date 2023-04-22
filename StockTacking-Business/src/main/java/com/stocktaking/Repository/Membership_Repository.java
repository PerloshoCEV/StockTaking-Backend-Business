package com.stocktaking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Membership;

public interface Membership_Repository extends JpaRepository<T_Membership, Long>
{

}
