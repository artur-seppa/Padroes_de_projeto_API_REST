package ProjectREST.crm.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import ProjectREST.crm.Model.Cliente;
import ProjectREST.crm.Model.Endereco;
import ProjectREST.crm.Repository.ClienteRepository;
import ProjectREST.crm.Repository.EnderecoRepository;
import ProjectREST.crm.Service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	/*
	 *	injeta/instancia o ClienteService
	 *	no nosso controller. Exerce uma
	 *	instanciaçao única dele. 
	 */
	
	@Autowired
	private ClienteService clienteService;
	
	/*
	 *	@@GetMapping : a partir do http do site executamos
	 *	um get 
	 */
	
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> buscarTodos() {
		return ResponseEntity.ok(clienteService.buscarTodos());
	}
	
	/*
	 *	@PostMapping : a partir do http do site executamos
	 *	um post  
	 *
	 *	@RequestBody : obtem as informaçoes passadas pelo request
	 *	body, passada pelo JSON. Do requestBody detemos um dado
	 *	do tipo Pessoa.
	 *
	 *	@ResponseStatus : ao executar este metodo, imprime como status
	 *	de execuçao o valor de 201, referente a criçao de usuario
	 *	feito com sucesso.
	 */
	
	@PostMapping
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
		clienteService.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	/*
	 *	"/{id}" : passamos o id do usuario procurado pelo path
	 *	http do site.
	 *
	 * 	@PathVariable : obtem o id pelo path passado pelo http.
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		clienteService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
}
