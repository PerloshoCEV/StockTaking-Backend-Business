package com.busines.ApiControllerInterface;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.busines.Response.ApiResponse;


public interface Base_ControllerInterface <T, DTO>
{
	/*
		Método interfaz: Post Create
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<DTO> createEntityController (@RequestBody T newEntity);
	
	/*
		Método interfaz: Get Read (All)
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<List<DTO>> readAllEntityController ();
	
	/*
		Método interfaz: Get Read (Por Id)
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<DTO> readEntityIdController (@RequestParam Long id);
	
	/*
		Método interfaz: Put Update
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<DTO> updateEntityController(@RequestBody T membershipToModify);
	
	/*
		Método interfaz: Delete
		Recibe:
		Objetivo:
		Devuelve:
	*/
	ApiResponse<DTO> deleteEntityId (@RequestParam Long id); 
}
