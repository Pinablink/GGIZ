package br.com.ggiz.ggizWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ggiz.ggizWeb.repository.entity.Gtpusuario;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public interface GGTpUsuarioRepository 
	extends JpaRepository<Gtpusuario, Long>{
	
	public Gtpusuario findByDescricao (String descricao);
}
