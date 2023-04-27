package com.stocktaking.Mapper;

/*
	Todos los DTO van a implementar esta interface
*/
public interface MapperInterface <ENTITY, DTO>
{
	boolean mapper(ENTITY entity, DTO dto);
}
