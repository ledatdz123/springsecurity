package com.example.securityapplication;

import com.example.securityapplication.model.Role;
import com.example.securityapplication.model.UserApp;
import com.example.securityapplication.repository.RoleRepository;
import com.example.securityapplication.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SecurityapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityapplicationApplication.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
		return args -> {
			Role adminRole = roleRepository.save(new Role(1,"ADMIN"));
			roleRepository.save(new Role(2,"USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			UserApp admin = new UserApp(1,"az@gmail.com" , passwordEncoder.encode("password"), roles);

			userRepository.save(admin);
		};
	}
}
