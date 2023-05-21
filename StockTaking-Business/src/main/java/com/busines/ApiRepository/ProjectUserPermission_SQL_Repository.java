package com.busines.ApiRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.busines.Entity_DTO.ProjectUserPermission_Dto;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.busines"})
public class ProjectUserPermission_SQL_Repository 
{
	// Pillo la url de la BBDD desde el application.properties
	@Value("${spring.datasource.url}")
    private String dbUrl; 
	
	// Pillo el username de la BBDD desde el application.properties
	@Value("${spring.datasource.username}")
    private String dbUsername;

	// Pillo la contraseña de la BBDD desde el application.properties
	@Value("${spring.datasource.password}")
    private String dbPassword;
    
	/*
	  Método para la consulta Insert:
	  INSERT INTO T_PROJECT_USER_PERMISSION  
	  	(PROJECT_ID, USER_ID, PERMISSION_ID, LEVEL)
	  VALUES 
	  	(projectId, userId, permissionId, level)
	*/
	public ProjectUserPermission_Dto insert(Long projectId, Long userId, Long permissionId, int level) 
	{
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
		try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
		{
			// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
            String sql = 
            		"INSERT INTO T_PROJECT_USER_PERMISSION " +
            		"(PROJECT_ID, USER_ID, PERMISSION_ID, LEVEL) " +
            		"VALUES (?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
            //a conticuación, los parámetros:
            statement.setLong(1, projectId);
            statement.setLong(2, userId);
            statement.setLong(3, permissionId);
            statement.setInt(4, level);
            
            // Ejecutamos el comando, y si el resultado ha dado más de una fila:
            if (statement.executeUpdate() > 0) 
            {
            	// Devolvemos el nuevo registro creado.
                return new ProjectUserPermission_Dto(projectId, userId, permissionId, level);
            }
        } 
		catch (Exception e) // Si algo del try falla:
		{
            e.printStackTrace(); // Muestro por consola la pila detallada de errores.
        }
        return null;
    }
	
	/*
		Método para la consulta UPDATE:
		UPDATE T_PROJECT_USER_PERMISSION  
		SET Level = level
		WHERE
		  	PROJECT_ID = projectId AND
		  	USER_ID = userId AND
		  	PERMISSION_ID = permissionId
	*/
	public ProjectUserPermission_Dto update(Long projectId, Long userId, Long permissionId, int level) 
	{
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
	    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
	    {
	    	// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
	        String sql = 
	        		"UPDATE T_PROJECT_USER_PERMISSION " +
	        		"SET LEVEL = ? " +
    				"WHERE " +
	        			"PROJECT_ID = ? AND " +
	        			"USER_ID = ? AND " +
	        			"PERMISSION_ID = ?";
	        
	        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
	        //a conticuación, los parámetros:
	        statement.setInt(1, level);
	        statement.setLong(2, projectId);
	        statement.setLong(3, userId);
	        statement.setLong(4, permissionId);
	        
	        // Si el resultado da más de un registro:
	        if (statement.executeUpdate() > 0) 
	        {
	        	// Devolvemos el registro
	            return new ProjectUserPermission_Dto(projectId, userId, permissionId, level);
	        }
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	/*
		Método para la consulta DELETE:
		DELETE FROM T_PROJECT_USER_PERMISSION  
		WHERE
		  	PROJECT_ID = projectId AND
		  	USER_ID = userId AND
		  	PERMISSION_ID = permissionId
	*/
	public ProjectUserPermission_Dto delete(Long projectId, Long userId, Long permissionId) 
	{
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
	    ProjectUserPermission_Dto entityToDelete = findById(projectId, userId, permissionId);
	    
	    // Si se ha encontrado el registro:
	    if (entityToDelete != null) 
	    {
	    	// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
	    	try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
		    {
		        String sql = 
		        		"DELETE FROM T_PROJECT_USER_PERMISSION " +
	    				"WHERE " +
	        				"PROJECT_ID = ? AND " +
	        				"USER_ID = ? AND " +
	        				"PERMISSION_ID = ?";
		        
		        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
		        //a conticuación, los parámetros:
		        statement.setLong(1, projectId);
		        statement.setLong(2, userId);
		        statement.setLong(3, permissionId);
		        
		        statement.executeUpdate();
		        // No hace falta if, ya que estamos dentro de un if que compueba si existe.
		        // devolvemos el registro.
	            return entityToDelete;
		    } 
	    	catch (Exception e) 
		    {
		        e.printStackTrace();
		    }
	    }
	    
	    return null;
	}
	
	public ProjectUserPermission_Dto findById(Long projectId, Long userId, Long permissionId) 
	{
		// Intentamos: (Realizamos la conexión con la BBDD [url BBD, UsuarioBBDD, ContraseñaBBDD]):
		// Todas esas configuraciones las pilla directamente del application.properties
	    try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) 
	    {
	    	// El String SQL: Usamos values ? para que se inserten por parámetros 
			// En vez de por concatenación, por seguridad de SQL-injection.
	        String sql = 
	        		"SELECT LEVEL " +
	        		"FROM T_PROJECT_USER_PERMISSION " +
	        		"WHERE PROJECT_ID = ? AND USER_ID = ? AND PERMISSION_ID = ?";
	        
	        PreparedStatement statement = connection.prepareStatement(sql); // Preparamos el comando
	        //a conticuación, los parámetros:
	        statement.setLong(1, projectId);
	        statement.setLong(2, userId);
	        statement.setLong(3, permissionId);
	        
	        // Almacenamos el resultado en resultSet
	        ResultSet resultSet = statement.executeQuery();
	        // Si podemos posicionarnos en el siguiente registro, empezando desde el principio (Primer registro)
	        if (resultSet.next()) 
	        {      
	            // Devolvemos el Dto con la clave pedida (que ya se ha verificado su existencia) 
	        	// con el valor que hay en la columna LEVEL del registro en el que estamos.
	            return new ProjectUserPermission_Dto(projectId, userId, permissionId, resultSet.getInt("LEVEL"));
	        }
	    } 
	    catch (Exception e) // Si algo del try falla:
	    {
	        e.printStackTrace(); // Muestro por consola la pila detallada de errores.
	    }
	    return null;
	}
}
