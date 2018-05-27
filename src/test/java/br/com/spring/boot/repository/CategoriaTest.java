package br.com.spring.boot.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.spring.boot.domain.Categoria;
import br.com.spring.boot.dto.CategoriaDTO;
import br.com.spring.boot.service.CategoriaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaTest {

	@Autowired
	private CategoriaService categoriaService;
	
	@Test
	public void buscarPorId() {
		Categoria categoria =  categoriaService.findById(1L);
		assertEquals(categoria, categoria);
	}
	
	@Test
	public void update() {
		
		CategoriaDTO ctDTO = new CategoriaDTO();		
		ctDTO.setId(43L);
		ctDTO.setNome("Eletrodomestico");
		
		Categoria cat = categoriaService.fromDTO(ctDTO);
		Categoria catRecuperadaSave = categoriaService.update(cat);
		
		
		
		assertEquals(catRecuperadaSave, categoriaService.findById(43L));
	}
	
	@Test
	public void save() {
		
		CategoriaDTO ctDTO = new CategoriaDTO();		
		ctDTO.setId(null);
		ctDTO.setNome("Eletrodomestico");
		
		Categoria cat = categoriaService.fromDTO(ctDTO);
		Categoria catRecuperadaSave = categoriaService.insert(cat);
		
		
		assertFalse(catRecuperadaSave == null);
		assertTrue(catRecuperadaSave != null);
	}
}
