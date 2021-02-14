package br.com.planejamentovirtualaulas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.planejamentovirtualaulas.domains.CampoExperiencia;

@Repository
public interface CampoExperienciaRepository extends JpaRepository<CampoExperiencia, Integer>{

}
