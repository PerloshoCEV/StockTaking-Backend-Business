package com.stocktaking.ApiControllerInterface;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.stocktaking.Response.ApiResponse;


public interface Base_ControllerInterface <T>
{
	/*
		Método interfaz: Post Create
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<T> createEntityController (@RequestBody T newEntity);
	
	/*
		Método interfaz: Get Read (All)
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<List<T>> readAllEntityController ();
	
	/*
		Método interfaz: Get Read (Por Id)
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<T> readEntityIdController (@RequestParam Long id);
	
	/*
		Método interfaz: Put Update
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<T> updateEntityController(@RequestBody T membershipToModify);
	
	/*
		Método interfaz: Delete
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<T> deleteEntityId (@RequestParam Long id); 
}
