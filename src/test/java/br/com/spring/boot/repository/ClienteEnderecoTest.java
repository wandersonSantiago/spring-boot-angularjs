package br.com.spring.boot.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.spring.boot.domain.Cliente;
import br.com.spring.boot.domain.Endereco;
import br.com.spring.boot.domain.enums.TipoCliente;
import br.com.spring.boot.service.CidadeService;
import br.com.spring.boot.service.ClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteEnderecoTest {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private CidadeService cidadeService;
	
	@Test
	public void save() {
		
		
		Cliente cliente = new Cliente(null, "Wanderson Santiago", "wandersonsantiago86@gmail.com", "34826591845", TipoCliente.PESSOA_FISICA,null);
		
		Endereco endereco = new Endereco(null, "Av. Rebouças", "3300", "Apartamento 124", "Centro", "13174371", cliente, cidadeService.buscarPorId(1L));
		
		cliente.getTelefones().addAll(Arrays.asList("19989074067","1984757547"));
		
		Cliente cli = clienteService.insert(cliente);
		
		Endereco end = enderecoRepository.save(endereco);

		assertTrue(end !=null);
		assertEquals(endereco, end);
		
		assertTrue(cli != null);		
		assertEquals(cli, cliente);
		
	}

}
