package com.example.appStudents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AppStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppStudentsApplication.class, args);
	}

	/*@Bean
	public WebMvcConfigurer corsConfigure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistration registry) {
				registry.addMapping("/")  // Permite todas las rutas
						.allowedOrigins("*")  // Permite cualquier origen
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos permitidos
						.allowedHeaders("*");  // Permite todos los encabezados
			}
		};
	}*/

}
