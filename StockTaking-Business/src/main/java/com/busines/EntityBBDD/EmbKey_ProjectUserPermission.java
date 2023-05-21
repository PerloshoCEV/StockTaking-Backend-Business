package com.busines.EntityBBDD;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmbKey_ProjectUserPermission implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column (name = "Project_ID")
	private Long projectId;
	
	@Column (name = "User_ID")
	private Long userId;
	
	@Column (name = "Permission_ID")
	private Long permissionId;

	/*
		Zona de Constructores
	*/
	// Constructor Vacío ()
	public EmbKey_ProjectUserPermission() 
	{
		super();
	}

	// Constructor completo ()
	public EmbKey_ProjectUserPermission(Long userId, Long permissionId, Long projectId) 
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
	
	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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
 
        EmbKey_ProjectUserPermission that = 
        		(EmbKey_ProjectUserPermission) other;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(permissionId, that.permissionId);
    }
 
    @Override
    public int hashCode() 
    {
        return Objects.hash(userId, permissionId);
    }
}
