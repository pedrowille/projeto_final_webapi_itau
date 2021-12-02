package br.com.contaBancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contaBancaria.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
	

}
