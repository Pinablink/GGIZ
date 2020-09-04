package br.com.ggizcom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ggizcom.entity.Gbroadcastctr;



/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public interface GGBroadcastctrRepository  
		extends JpaRepository<Gbroadcastctr, Long>  {
	
	public List<Gbroadcastctr> findByEnvbroad(String perm);

}
