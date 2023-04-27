package com.stocktaking.Response;

import com.stocktaking.Enum.MessageResult;

public class Metadata 
{
	private Pagination pagination;
	private MessageResult message;
	
	public Metadata() 
	{
		message = MessageResult.Success;
	}
	
	public Metadata(Pagination pag) 
	{
		pagination = pag;
	}

	public Pagination getPagination() 
	{
		return pagination;
	}

	public void setPagination(Pagination pagination) 
	{
		this.pagination = pagination;
	}

	public MessageResult getMessage() 
	{
		return message;
	}

	public void setMessage(MessageResult message) 
	{
		this.message = message;
	}
}
