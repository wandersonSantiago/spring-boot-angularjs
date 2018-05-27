package br.com.spring.boot.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.spring.boot.domain.Cidade;
import br.com.spring.boot.domain.Estado;
import br.com.spring.boot.service.CidadeService;
import br.com.spring.boot.service.EstadoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CidadeEstadoTest {
	
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private CidadeService cidadeService;
	
	@Test
	public void save() {
		Estado estado = new Estado(null, "São Paulo");
		Estado est = estadoService.save(estado);
		
		assertTrue(est !=null);
		assertEquals(estado, est);
		
		Cidade cidade = new Cidade(null, "Sumaré", estado);
		Cidade cid = cidadeService.save(cidade);
		
		assertTrue(cid != null);		
		assertEquals(cid, cidade);
		
	}

}
