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

import br.com.spring.boot.domain.Cidade;
import br.com.spring.boot.dto.CidadeDTO;
import br.com.spring.boot.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService cidadeService;
	
	@PostMapping
	public Cidade save(@RequestBody Cidade cidade){
		return cidadeService.save(cidade);
	}
	
	@GetMapping("/estado/{id}")
	public ResponseEntity<List<CidadeDTO>> findAllByOrderByNome(@PathVariable Long id) {
		List<Cidade> cidades = cidadeService.findAllByEstadoIdOrderByNome(id);
		List<CidadeDTO> cidadeDTO = cidades.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(cidadeDTO);
	}
	
}
