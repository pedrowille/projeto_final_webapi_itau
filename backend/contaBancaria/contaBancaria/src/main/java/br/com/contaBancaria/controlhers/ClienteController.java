package br.com.contaBancaria.controlhers;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.contaBancaria.models.Cliente;
import br.com.contaBancaria.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<Cliente> buscarTodos(){
		return service.buscarTodos();
	
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {				
		
		Optional<Cliente> cliente = service.buscarPorId(id);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok( cliente.get() );
		}
		
		return ResponseEntity.notFound().build();
	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody Cliente cliente) {
		return service.salvar(cliente);
	}
	
	
	@PutMapping
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) {
			
			Optional<Cliente> cli = service.buscarPorId(cliente.getId());
			
			if( cli.isPresent() ) {
				BeanUtils.copyProperties(cliente, cli.get(), "id"); //cliente é o objeto que veio do frontend
	            													//cli é o objeto que buscamos na base de dados
				return ResponseEntity.ok( service.salvar( cli.get() ));
				
			}
			
			return ResponseEntity.notFound().build();
	
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> excluir(@PathVariable Long id) {
		
		Optional<Cliente> cli = service.buscarPorId(id);
		
		if(cli.isPresent()) {
			service.excluir(id);
			return 	ResponseEntity.noContent().build();		
		}
		
		return ResponseEntity.notFound().build();
   }
	
}
