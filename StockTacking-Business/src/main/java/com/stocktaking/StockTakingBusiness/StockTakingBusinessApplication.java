package com.stocktaking.StockTakingBusiness;

import org.springframework.boot.SpringApplication;
import com.stocktaking.EntityBBDD.T_Membership;
import com.stocktaking.Repository.BaseRepository;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.stocktaking.Service.BaseService;
@SpringBootApplication
public class StockTakingBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockTakingBusinessApplication.class, args);
		BaseRepository<T_Membership> d1 =  new BaseRepository<T_Membership>()
		BaseService<T_Membership> test = new BaseService<T_Membership>(d1);
	}

}
