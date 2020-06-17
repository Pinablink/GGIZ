package br.com.ggiz.ggizWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ggiz.ggizWeb.util.GGizWebProperties;

@SpringBootApplication
public class GgizWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GgizWebApplication.class, args);
	}

}
