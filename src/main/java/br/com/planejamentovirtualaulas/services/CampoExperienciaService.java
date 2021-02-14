package br.com.planejamentovirtualaulas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.planejamentovirtualaulas.domains.CampoExperiencia;
import br.com.planejamentovirtualaulas.repositories.CampoExperienciaRepository;
import br.com.planejamentovirtualaulas.services.exceptions.ObjectNotFoundException;

@Service
public class CampoExperienciaService {
	
	@Autowired
	private CampoExperienciaRepository repo;
	
	
	public CampoExperiencia find(Integer id) {
		Optional<CampoExperiencia> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CampoExperiencia.class.getSimpleName()));

	}

	
	public List<CampoExperiencia> findAll() {
		return repo.findAll();
	}

}
