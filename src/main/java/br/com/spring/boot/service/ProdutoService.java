package br.com.spring.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.spring.boot.domain.Categoria;
import br.com.spring.boot.domain.Produto;
import br.com.spring.boot.exceptions.ObjectNotFoundException;
import br.com.spring.boot.repository.CategoriaRepository;
import br.com.spring.boot.repository.ProdutoRepository;

@Service
public class ProdutoService {

	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto save(Produto produto) {		
		return produtoRepository.save(produto);
	}
	
	public Produto findById(Long id){
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: ID : " + id
				+ " Tipo : " + Produto.class.getName()));
	}
		
	public Page<Produto> search(String nome, List<Long> ids, PageRequest page){
		
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return produtoRepository.search(nome, categorias, page);
	}
}
