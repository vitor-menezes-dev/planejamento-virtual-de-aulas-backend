package br.com.planejamentovirtualaulas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.planejamentovirtualaulas.domains.BNCCInfantil;
import br.com.planejamentovirtualaulas.domains.CampoExperiencia;
import br.com.planejamentovirtualaulas.repositories.BNCCInfantilRepository;
import br.com.planejamentovirtualaulas.repositories.CampoExperienciaRepository;
import br.com.planejamentovirtualaulas.services.exceptions.ObjectNotFoundException;

@Service
public class BNCCInfantilService {
	
	@Autowired
	private BNCCInfantilRepository repo;
	
	@Autowired 
	private CampoExperienciaRepository campoExperienciaRepo;
	
	public BNCCInfantil find(String id) {
		Optional<BNCCInfantil> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + BNCCInfantil.class.getSimpleName()));

	}

	
	public List<BNCCInfantil> findAll() {
		return repo.findAll();
	}


	public Page<BNCCInfantil> search(String queryText, List<Integer> idsCampoExperiencias, Integer page,
			Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<CampoExperiencia> campoExperiencias = campoExperienciaRepo.findAllById(idsCampoExperiencias);
		return repo.findByContainingQueryTextAndCampoExperienciasIn(queryText,campoExperiencias,pageRequest);
	}

}
