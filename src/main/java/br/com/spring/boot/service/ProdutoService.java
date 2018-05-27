package br.com.spring.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.boot.domain.Produto;
import br.com.spring.boot.repository.ProdutoRepository;

@Service
public class ProdutoService {

	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public Produto save(Produto produto) {		
		return produtoRepository.save(produto);
	}
	
	public Produto buscarPorId(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElse(null);
	}
		
}
