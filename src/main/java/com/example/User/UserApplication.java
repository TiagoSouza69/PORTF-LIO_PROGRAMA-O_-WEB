package com.example.User;




import org.modelmapper.ModelMapper;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;





@SpringBootApplication
public class UserApplication  {
	
	
	
	@Bean
	public ModelMapper modelmapper() {
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setSkipNullEnabled(true);
		return modelmapper;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		
		
		
		
		
	}
	
	

}


