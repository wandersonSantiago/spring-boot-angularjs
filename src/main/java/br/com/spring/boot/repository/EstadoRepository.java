package br.com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.boot.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
