package br.com.spring.boot.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.spring.boot.domain.Categoria;
import br.com.spring.boot.domain.Produto;
import br.com.spring.boot.service.CategoriaService;
import br.com.spring.boot.service.ProdutoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoTest {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CategoriaService categoriaService;
	
	@Test
	public void save() {
		Produto produto = new Produto(null, "teclado", 500.00);
		Produto produto2 = new Produto(null, "Mouse", 900.00);
		
		Categoria categoria = new Categoria(null, "Informatica");
		
		Categoria cat = categoriaService.insert(categoria);
		assertTrue(cat != null);
		
		produto.getCategorias().add(cat);
		produto2.getCategorias().add(cat);
		
		Produto prod = produtoService.save(produto);
		Produto prod2 = produtoService.save(produto2);
		
		assertTrue(prod !=null);
		assertEquals(produto, prod);
		
		assertTrue(prod2 !=null);
		assertEquals(produto2, prod2);
		
	}
}
