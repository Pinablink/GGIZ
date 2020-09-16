package br.com.ggizcom.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ggizcom.entity.Gbroadcastctr;



/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@Repository
public interface GGBroadcastctrRepository  
		extends JpaRepository<Gbroadcastctr, Long>  {
	
	public List<Gbroadcastctr> findByEnvbroad(String perm);

}
