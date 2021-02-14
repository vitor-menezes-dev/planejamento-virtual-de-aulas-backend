package br.com.planejamentovirtualaulas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.planejamentovirtualaulas.domains.BNCCInfantil;
import br.com.planejamentovirtualaulas.domains.CampoExperiencia;

@Repository
public interface BNCCInfantilRepository extends JpaRepository<BNCCInfantil, String>{


	@Transactional(readOnly = true)
	@Query("SELECT obj FROM BNCCInfantil obj INNER JOIN obj.campoExperiencia ce WHERE (obj.objetivo LIKE %:queryText%"
			+ " OR obj.abordagem LIKE %:queryText% "
			+ " OR obj.sugestao LIKE %:queryText%)"
			+ " AND ce IN :campoExperiencias")
	Page<BNCCInfantil> findByContainingQueryTextAndCampoExperienciasIn(@Param("queryText") String queryText,
			@Param("campoExperiencias") List<CampoExperiencia> campoExperiencias, Pageable pageable);

}
