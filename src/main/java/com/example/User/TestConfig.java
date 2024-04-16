package com.example.User;


import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@RequestMapping(value = "/usuarios")


public class TestConfig implements CommandLineRunner {
	
	
	
	@Autowired
	  private UserRepository userRepository;
	
	
	@Override  
	 public void run(String... args) throws Exception {
	Usuario us1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
	Usuario us2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
	
	userRepository.saveAll(Arrays.asList(us1, us2));
	
	}
	
}
