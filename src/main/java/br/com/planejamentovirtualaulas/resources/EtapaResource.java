package br.com.planejamentovirtualaulas.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.planejamentovirtualaulas.domains.enums.Etapa;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/etapa")
public class EtapaResource {
	
	@ApiOperation(value="Busca por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Etapa> find(@PathVariable Integer id) {
		Etapa etapa = Etapa.toEnum(id);
		return ResponseEntity.ok(etapa);
	}
	
	@ApiOperation(value="Busca todas")
	@GetMapping
	public ResponseEntity<Etapa[]> findAll() {
		return ResponseEntity.ok().body(Etapa.values());
	}
	

}
