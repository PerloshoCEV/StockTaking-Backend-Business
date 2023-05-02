package com.stocktaking.ApiControllerInterface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stocktaking.EntityBBDD.T_User;
import com.stocktaking.Entity_DTO.User_Dto;
import com.stocktaking.Response.ApiResponse;

@RequestMapping("/busines")
public interface User_ControllerInterface extends Base_ControllerInterface<T_User, User_Dto>
{
	@GetMapping(path = "/login")
	public ApiResponse<User_Dto> LogInController(@RequestParam String email, @RequestParam String password);
	
	@PostMapping(path = "/signup")
	public ApiResponse<User_Dto> SignUpController(@RequestParam String email, @RequestParam String password);
	
}
