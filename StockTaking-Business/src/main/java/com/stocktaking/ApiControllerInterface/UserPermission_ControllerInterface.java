package com.stocktaking.ApiControllerInterface;

import java.util.List;

import com.stocktaking.EntityBBDD.EmbKey_User_Permission;
import com.stocktaking.EntityBBDD.T_UserPermission;
import com.stocktaking.Response.ApiResponse;

public interface UserPermission_ControllerInterface 
{
	ApiResponse<T_UserPermission> createEntityController(T_UserPermission newUserPermission) ;
	ApiResponse<List<T_UserPermission>> readAllEntityController();
	ApiResponse<T_UserPermission> readEntityIdController(EmbKey_User_Permission id);
	ApiResponse<T_UserPermission> updateEntityController(T_UserPermission userPermissionToModify);
	ApiResponse<T_UserPermission> deleteEntityId(EmbKey_User_Permission id);
	
}
