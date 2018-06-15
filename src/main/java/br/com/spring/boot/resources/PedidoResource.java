package br.com.spring.boot.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.spring.boot.domain.Pedido;
import br.com.spring.boot.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj){
		obj = pedidoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(pedidoService.buscarPorId(id));
	}
	
	@GetMapping
	public ResponseEntity<Page<Pedido>> findAllPage(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="instante") String orderBy,
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		
		Page<Pedido> pedidos = pedidoService.findPage(PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy));
	
		return ResponseEntity.ok().body(pedidos);
	}
}
