package br.com.planejamentovirtualaulas.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.planejamentovirtualaulas.domains.CampoExperiencia;
import br.com.planejamentovirtualaulas.dtos.CampoExperienciaDTO;
import br.com.planejamentovirtualaulas.services.CampoExperienciaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/campoExperiencia")
public class CampoExperienciaResource {

	@Autowired
	private CampoExperienciaService serv;

	@ApiOperation(value = "Busca por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<CampoExperiencia> find(@PathVariable Integer id) {
		CampoExperiencia obj = serv.find(id);
		return ResponseEntity.ok(obj);
	}

	@ApiOperation(value = "Busca todas")
	@GetMapping
	public ResponseEntity<List<CampoExperienciaDTO>> findAll() {
		List<CampoExperiencia> lista = serv.findAll();
		List<CampoExperienciaDTO> listaDto = lista.stream().map(CampoExperienciaDTO::new).collect(Collectors.toList());
		listaDto.sort((o1, o2) -> o1.getNome().compareToIgnoreCase(o2.getNome()));
		return ResponseEntity.ok().body(listaDto);
	}

}
