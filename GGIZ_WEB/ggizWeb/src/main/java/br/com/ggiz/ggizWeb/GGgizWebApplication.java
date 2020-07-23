package br.com.ggiz.ggizWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.ggiz.ggizWeb.filter.GGizApiFilter;

@SpringBootApplication
public class GGgizWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GGgizWebApplication.class, args);
	}

}
