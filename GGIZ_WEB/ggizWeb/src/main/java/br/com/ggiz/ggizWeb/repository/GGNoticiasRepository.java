package br.com.ggiz.ggizWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gnoticia;


/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public interface GGNoticiasRepository 
		extends JpaRepository<Gnoticia, Long> {

}
