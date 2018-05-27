package br.com.spring.boot.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.spring.boot.domain.Pagamento;
import br.com.spring.boot.domain.PagamentoComBoleto;
import br.com.spring.boot.domain.PagamentoComCartao;
import br.com.spring.boot.domain.Pedido;
import br.com.spring.boot.domain.enums.EstadoPagamento;
import br.com.spring.boot.service.ClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidoPagamentoTest {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Test
	public void save() throws ParseException {
		
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), clienteService.buscarPorId(3L), enderecoRepository.findById(1L).get()); 
	Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:32"), clienteService.buscarPorId(3L), enderecoRepository.findById(1L).get());
	
	Pagamento pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
	pedido1.setPagamento(pagamento1);
	
	Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("20/10/2017 00:00"), null);
	pedido2.setPagamento(pagamento2);
		
	List<Pedido> p = pedidoRepository.saveAll( Arrays.asList(pedido1,pedido2));
	List<Pagamento> pag = pagamentoRepository.saveAll(Arrays.asList(pagamento1,pagamento2));
	
		assertNotNull(p);
		assertTrue(!p.isEmpty());
		
		assertNotNull(pag);
		assertTrue(!pag.isEmpty());
		
			
		
	}

}
