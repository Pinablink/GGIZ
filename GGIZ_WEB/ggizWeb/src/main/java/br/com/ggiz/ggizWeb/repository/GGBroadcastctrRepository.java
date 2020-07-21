package br.com.ggiz.ggizWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ggiz.ggizWeb.repository.entity.Gbroadcastctr;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public interface GGBroadcastctrRepository 
	extends JpaRepository<Gbroadcastctr, Long>  {
	
	public List<Gbroadcastctr> findByEnvbroad(String perm);
}
