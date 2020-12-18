package br.com.ggiz.ggizWeb.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.ggiz.ggizWeb.repository.entity.Gnoticia;


/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public interface GGNoticiasRepository 
		extends JpaRepository<Gnoticia, Long> {

	@Query(value="SELECT * FROM gnoticia ORDER BY dtcriacao DESC", nativeQuery=true)
	public List<Gnoticia> getOrderNewsDate ();
}
