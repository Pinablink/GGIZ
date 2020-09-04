package br.com.ggizcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ggizcom.entity.Gbroadcast;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public interface GGBroadcastRespository 
	extends JpaRepository<Gbroadcast, Long>{
	
	public Gbroadcast findBymsgenvbroad(String msgenvbroad);
}
