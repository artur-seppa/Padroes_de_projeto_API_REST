package ProjectREST.crm.Service;

import ProjectREST.crm.Model.Cliente;

/*
 *	Exerce um contrato de funcionamento do serviços
 *	do Cliente no Banco de Dados 
 */

public interface ClienteService {

	Iterable<Cliente> buscarTodos();

	Cliente buscarPorId(Long id);

	void inserir(Cliente cliente);

	void atualizar(Long id, Cliente cliente);

	void deletar(Long id);
	
}
