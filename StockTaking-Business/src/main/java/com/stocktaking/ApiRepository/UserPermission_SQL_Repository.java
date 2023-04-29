package com.stocktaking.ApiRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.stocktaking.EntityBBDD.T_UserPermission;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.stocktaking"})
public class UserPermission_SQL_Repository 
{
	@Value("${spring.datasource.url}")
    private String dbUrl;
	
	@Value("${spring.datasource.username}")
    private String dbUsername;

	@Value("${spring.datasource.password}")
    private String dbPassword;
    
	/*
	  Método para la consulta Insert:
	  INSERT INTO T_User_Permission 
	  	(USER_ID, PERMISSION_ID, LEVEL) 
	  VALUES 
	  	(1, 1, 1)
	*/
	public T_UserPermission insert (Long userId, Long permissionId, int level)
	{
		T_UserPermission newUserPermission = new T_UserPermission();
		
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
        {
            Statement statement = connection.createStatement();
            String sql = 
            		"INSERT INTO T_User_Permission " +
            		"(USER_ID, PERMISSION_ID, LEVEL) " +
            		"VALUES " +
            		"(" + userId + ", " + permissionId + ", " + level +")";
            statement.executeUpdate(sql);
        }
		catch (Exception e) {
			return null;
		}
		return newUserPermission;
	}
}
