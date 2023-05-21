package com.busines.ApiRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busines.EntityBBDD.T_Project;

public interface Project_Repository extends JpaRepository<T_Project, Long>
{

}
