package com.stocktaking.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktaking.EntityBBDD.T_Project;

public interface Project_Repository extends JpaRepository<T_Project, Long>
{

}
