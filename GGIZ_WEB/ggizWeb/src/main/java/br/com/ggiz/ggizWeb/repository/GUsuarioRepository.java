package br.com.ggiz.ggizWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ggiz.ggizWeb.repository.entity.GUsuario;


/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public interface GUsuarioRepository 
	extends JpaRepository<GUsuario, Long> {

	public GUsuario findByNome (String nome);
}
