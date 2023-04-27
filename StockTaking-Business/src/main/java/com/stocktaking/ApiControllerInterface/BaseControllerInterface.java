package com.stocktaking.ApiControllerInterface;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.stocktaking.Response.ApiResponse;


public interface BaseControllerInterface <T>
{
	/*
		Método interfaz: Post Create
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<T> createMembershipController (@RequestBody T newMembership);
	
	/*
		Método interfaz: Get Read (All)
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<List<T>> readAllMembershipController ();
	
	/*
		Método interfaz: Get Read (Por Id)
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<T> readMembershipIdController (@RequestParam Long id);
	
	/*
		Método interfaz: Put Update
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<T> updateMembershipController(@RequestBody T membershipToModify);
	
	/*
		Método interfaz: Delete
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<T> deleteMembershipId (@RequestParam Long id); 
}
