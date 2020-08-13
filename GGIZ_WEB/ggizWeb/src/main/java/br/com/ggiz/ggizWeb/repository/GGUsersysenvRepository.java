package br.com.ggiz.ggizWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gusersysenv;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public interface GGUsersysenvRepository 
	extends JpaRepository<Gusersysenv, Long> {

	public Gusersysenv findByUsersys(String usersys);
}
