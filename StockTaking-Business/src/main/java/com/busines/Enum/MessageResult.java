package com.busines.Enum;

public enum MessageResult 
{
	Success,
	Error,
    EntityExist;
    
	public static final MessageResult DEFAULT = Error; // definir el valor por defecto
}
