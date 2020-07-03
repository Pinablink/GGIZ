package br.com.ggiz.ggizWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gusuario;


/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public interface GGUsuarioRepository 
	extends JpaRepository<Gusuario, Long> {

	public Gusuario findByNome (String nome);
	public Gusuario findByNomeAndEmail (String nome, String email);
}
