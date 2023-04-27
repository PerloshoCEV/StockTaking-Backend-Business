package com.stocktaking.Response;

public class Metadata 
{
	private Pagination pagination;
	
	public Metadata() 
	{
	
	}
	
	public Metadata(Pagination pag) 
	{
		pagination = pag;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
