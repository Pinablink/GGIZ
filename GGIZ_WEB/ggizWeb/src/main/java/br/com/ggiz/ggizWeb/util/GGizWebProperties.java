package br.com.ggiz.ggizWeb.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@Configuration
@PropertySource({"classpath:message.properties"})
public class GGizWebProperties {
	
	  @Bean
	  @ConfigurationProperties(prefix="message")
	  public GGizWebMessage getMessage () {
		  return new GGizWebMessage();
	  }
}
