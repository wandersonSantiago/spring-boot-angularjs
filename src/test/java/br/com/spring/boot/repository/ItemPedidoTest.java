package br.com.spring.boot.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.spring.boot.domain.ItemPedido;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemPedidoTest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Test
	public void save() {
		
	
	
	
	ItemPedido item1 = new ItemPedido(pedidoRepository.findById(1L).get(), produtoRepository.findById(1L).get(), 0.00, 1, 2000.00);
	ItemPedido item2 = new ItemPedido(pedidoRepository.findById(1L).get(), produtoRepository.findById(5L).get(), 0.00, 2, 80.00);

	List<ItemPedido> list = itemPedidoRepository.saveAll(Arrays.asList(item1,item2));
	
		assertNotNull(list);
		assertTrue(!list.isEmpty());
		
				
		
	}

}
