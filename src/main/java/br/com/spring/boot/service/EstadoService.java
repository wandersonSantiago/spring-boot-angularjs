package br.com.spring.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.boot.domain.Estado;
import br.com.spring.boot.exceptions.ObjectNotFoundException;
import br.com.spring.boot.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado save(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public Estado buscarPorId(Long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		return estado.orElseThrow(() -> new ObjectNotFoundException("Busca não encontrada para o Id : "
				+ id + " Tipo : " + Estado.class.getName()));
	}
}
