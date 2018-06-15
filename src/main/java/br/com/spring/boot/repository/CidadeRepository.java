package br.com.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.boot.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	
	@Transactional(readOnly=true)
	List<Cidade> findAllByOrderByNome();

	@Transactional(readOnly=true)
	List<Cidade> findAllByEstadoIdOrderByNome(Long id);
}
