package br.com.planejamentovirtualaulas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.planejamentovirtualaulas.domains.BNCCInfantil;
import br.com.planejamentovirtualaulas.dtos.BNCCInfantilDTO;
import br.com.planejamentovirtualaulas.resources.utils.URL;
import br.com.planejamentovirtualaulas.services.BNCCInfantilService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/BNCC")
public class BNCCResource {
	
	@Autowired
	private BNCCInfantilService serv;
	
	@ApiOperation(value="Busca por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<BNCCInfantil> find(@PathVariable String id) {
		BNCCInfantil obj = serv.find(id);
		return ResponseEntity.ok(obj);
	}
	
	@ApiOperation(value="Busca todas")
	@GetMapping
	public ResponseEntity<Page<BNCCInfantilDTO>> findPage(
			@RequestParam(value = "queryText", defaultValue = "") String queryText,
			@RequestParam(value = "campoExperiencias", defaultValue = "1,2,3,4,5") String campoExperiencias,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "campoExperiencia.nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {
		List<Integer> idsCampoExperiencias = URL.decodeIntList(campoExperiencias);
		String queryTextDecode=URL.decodeParam(queryText);
		Page<BNCCInfantil> lista = serv.search(queryTextDecode, idsCampoExperiencias , page,linesPerPage, orderBy,direction.toUpperCase());
		Page<BNCCInfantilDTO> listaDto =  lista.map(obj -> new BNCCInfantilDTO(obj));
		return ResponseEntity.ok().body(listaDto);
	}
	

}
