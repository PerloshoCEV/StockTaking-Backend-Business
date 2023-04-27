package com.stocktaking.ApiServiceInterface;

import java.util.List;
import java.util.Optional;

public interface BaseServiceInterface <T>
{ 
	public T createBaseService(T newBase);
	

	public List<T> readBaseAllService();

	public T readBaseId(Long id);

	public T updateBase(T membership);

	public T deleteBaseId(T membershipToDelete);

	public Optional<T> findBaseByIdService(Long id);
}
