package com.busines.Entity_DTO;

import com.busines.EntityBBDD.EmbKey_ProjectUserPermission;
import com.busines.EntityBBDD.T_ProjectUserPermission;

public class ProjectUserPermission_Dto 
{
	private Long projectId;
	private Long userId;
	private Long permissionId;
	private Integer level=-1;
	
	public ProjectUserPermission_Dto() 
	{
		this.level = -1;
	}
	
	public ProjectUserPermission_Dto(Long projectId, Long userId, Long permissionId, Integer level) 
	{
		this.projectId = projectId;
		this.userId = userId;
		this.permissionId = permissionId;
		this.level = level;
	}
	
	public ProjectUserPermission_Dto(EmbKey_ProjectUserPermission keyEmb, Integer level) 
	{
		this.projectId = keyEmb.getProjectId();
		this.userId = keyEmb.getUserId();
		this.permissionId = keyEmb.getPermissionId();
		this.level = level;
	}
	
	public ProjectUserPermission_Dto(T_ProjectUserPermission entityBase) 
	{
		this.projectId = entityBase.getId().getProjectId();
		this.userId = entityBase.getId().getUserId();
		this.permissionId = entityBase.getId().getPermissionId();
		this.level = entityBase.getLevel();
	}

	public Long getProjectId() 
	{
		return projectId;
	}

	public void setProjectId(Long projectId) 
	{
		this.projectId = projectId;
	}

	public Long getUserId() {
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

	public int getLevel() 
	{
		return level;
	}

	public void setLevel(Integer level) 
	{
		this.level = level;
	}
	
	
}
