package br.com.spring.boot.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.boot.domain.Estado;
import br.com.spring.boot.dto.EstadoDTO;
import br.com.spring.boot.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;
	
	@PostMapping
	public Estado save(@RequestBody Estado estado){
		return estadoService.save(estado);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(estadoService.buscarPorId(id));
	}
	
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> findAllByOrderByNome() {
		List<Estado> estados = estadoService.findAllByOrderByNome();
		List<EstadoDTO> estadoDTO = estados.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(estadoDTO);
	}
}
