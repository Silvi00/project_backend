package com.project.hospital;

import com.project.hospital.consultatie.Consultatie;
import com.project.hospital.enums.Department;
import com.project.hospital.repo.ConsultatieRepo;
import com.project.hospital.repo.UserRepo;
import com.project.hospital.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(UserRepo userRepo) {
//		return args -> {
//			userRepo.save(new User(null,"Silvana","Ghemes","silvi@gmail.com","parola", Department.NEUROLOGIE));
//			userRepo.save(new User(null,"Eliss","Indricau","eliss@gmail.com","parola2", Department.CARDIOLOGIE));
//
//		};
//	}

//		@Bean
//	CommandLineRunner run(ConsultatieRepo consultatieRepo) {
//		return args -> {
//			consultatieRepo.save(new Consultatie("1234567890123","Ghemes","Silvana",new Date(),"simptome","diagnostic","prescriptie"));
//		};
//	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
