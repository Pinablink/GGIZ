package br.com.ggiz.ggizWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gnoticialer;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public interface GGNoticiaLerRepository 
	extends JpaRepository<Gnoticialer, Long> {

	
}
