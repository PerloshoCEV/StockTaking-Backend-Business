package com.stocktaking.EntityBBDD;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmbKey_User_Permission implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column (name = "User_ID")
	private Long userId;
	
	@Column (name = "Permission_ID")
	private Long permissionId;

	/*
		Zona de Constructores
	*/
	// Constructor Vacío ()
	public EmbKey_User_Permission() 
	{
		super();
	}

	// Constructor completo ()
	public EmbKey_User_Permission(Long userId, Long permissionId) 
	{
		super();
		this.userId = userId;
		this.permissionId = permissionId;
	}


	/*
		Zona de Métodos Getters / Setters
	*/
	public Long getUserId() 
	{
		return userId;
	}

	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getPermissionId() 
	{
		return permissionId;
	}

	public void setPermissionId(Long permissionId) 
	{
		this.permissionId = permissionId;
	}
	
	public void setAll(Long userId, Long permissionId)
	{
		this.userId = userId;
		this.permissionId = permissionId;
	}
	
	/*
		Zona de Métodos a implementar
	*/
	@Override
    public boolean equals(Object other) {
        if (this == other) 
    	{
        	return true;
    	}
 
        if (other == null || getClass() != other.getClass())
            return false;
 
        EmbKey_User_Permission that = (EmbKey_User_Permission) other;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(permissionId, that.permissionId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(userId, permissionId);
    }
}
