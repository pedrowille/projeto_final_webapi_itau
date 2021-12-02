package br.com.contaBancaria.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contaBancaria.models.Cliente;
import br.com.contaBancaria.repository.ClienteRepository;

@Service
public class ClienteService {
	

	@Autowired
	private ClienteRepository repository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		
		String cpf = cliente.getCpf();
		cpf = cpf.replace(".", "").replace("-", "");
		cliente.setCpf(cpf);
		
		return repository.save(cliente);
	
		
	}

	public List<Cliente> buscarTodos() {
		return repository.findAll();
	}

	public Optional<Cliente> buscarPorId(Long id) {
		return repository.findById(id);
	}
      
	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);
	}

}
