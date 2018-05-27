package br.com.spring.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.boot.domain.Cidade;
import br.com.spring.boot.exceptions.ObjectNotFoundException;
import br.com.spring.boot.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade save(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	public Cidade buscarPorId(Long id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		return cidade.orElseThrow(() -> new ObjectNotFoundException(" Objeto não encontrado para o id : " + id 
				+ " Tipo: " + Cidade.class.getName()));
	}
}
