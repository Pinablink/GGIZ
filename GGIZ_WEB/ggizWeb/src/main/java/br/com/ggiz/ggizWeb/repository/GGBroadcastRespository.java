package br.com.ggiz.ggizWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ggiz.ggizWeb.repository.entity.Gbroadcast;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public interface GGBroadcastRespository 
	extends JpaRepository<Gbroadcast, Long>{

	
}
