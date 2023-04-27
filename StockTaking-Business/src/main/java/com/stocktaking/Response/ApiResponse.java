package com.stocktaking.Response;

public class ApiResponse <T> 
{
	/*
		Variables
	*/
	private T response;
	private Metadata metadata;
	
	/*
		Constructores
	*/
	public ApiResponse(Metadata metadataToSend)
	{
		response = null;
		metadata = metadataToSend;
	}
	
	public ApiResponse(T responseToSend, Metadata metadataToSend)
	{
		response = responseToSend;
		metadata = metadataToSend;
	}
	
	/*
		Getters & Setters
	*/
	public T getResponse() 
	{
		return response;
	}

	public void setResponse(T response) 
	{
		this.response = response;
	}

	public Metadata getMetadata() 
	{
		return metadata;
	}

	public void setMetadata(Metadata metadata) 
	{
		this.metadata = metadata;
	}
}

