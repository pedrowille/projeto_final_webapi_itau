package br.com.contaBancaria.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.contaBancaria.models.Conta;
import br.com.contaBancaria.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repository;
	
	public List<Conta> buscarTodos(){
		return repository.findAll();
	}
	
	public Optional<Conta> buscarPorNumero(Long numero) {
		return repository.findById(numero);
	}
      

   
	 @Transactional
		public void excluir(Long numero) {
			repository.deleteById(numero);
		}
}
