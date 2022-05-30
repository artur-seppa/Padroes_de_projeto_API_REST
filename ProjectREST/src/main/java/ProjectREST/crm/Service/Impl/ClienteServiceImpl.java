package ProjectREST.crm.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjectREST.crm.Model.Cliente;
import ProjectREST.crm.Model.Endereco;
import ProjectREST.crm.Model.Telefone;
import ProjectREST.crm.Repository.ClienteRepository;
import ProjectREST.crm.Repository.EnderecoRepository;
import ProjectREST.crm.Repository.TelefoneRepository;
import ProjectREST.crm.Service.ClienteService;

/*
 *	Exerce a implementaçao dos serviços que o
 *	Banco de dados deve fazer. 
 */

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		//METODO PRE FABRICADO DO JPA
		// .finAll : obtem todas as Pessoas do BD
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// Buscar Cliente por ID.
		// Optional : caso nao tenha o cliente com esse id
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			Endereco novoEndereco = cliente.getEndereco();
			enderecoRepository.save(novoEndereco);
			cliente.setEndereco(novoEndereco);
			
			Telefone novoTelefone = cliente.getTelefone();
			telefoneRepository.save(novoTelefone);
			cliente.setTelefone(novoTelefone);
			
			clienteRepository.save(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
		clienteRepository.deleteById(id);
	}
	
	private void salvarClienteComCep(Cliente cliente) {
		Endereco novoEndereco = cliente.getEndereco();
		enderecoRepository.save(novoEndereco);
		
		Telefone novoTelefone = cliente.getTelefone();
		telefoneRepository.save(novoTelefone);
		cliente.setTelefone(novoTelefone);
		
		cliente.setEndereco(novoEndereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		clienteRepository.save(cliente);
	}
}
