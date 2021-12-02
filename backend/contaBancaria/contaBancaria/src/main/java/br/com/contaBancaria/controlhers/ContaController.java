package br.com.contaBancaria.controlhers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.contaBancaria.models.Conta;
import br.com.contaBancaria.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	private ContaService service;
	
	@GetMapping
	public List<Conta> buscarTodos(){
		return service.buscarTodos();
		
	}
	@DeleteMapping("conta/{numro}")
	public ResponseEntity<Conta> excluir(@PathVariable Long numero) {
		
		Optional<Conta> co = service.buscarPorNumero(numero);
		
		if(co.isPresent()) {
			service.excluir(numero);
			return 	ResponseEntity.noContent().build();		
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
