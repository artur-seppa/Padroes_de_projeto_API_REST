package ProjectREST.crm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjectREST.crm.Model.Telefone;

/*
 *	A class Repository opera como um Banco de Dados
 *	do sistema. Ele funciona como uma interface e 
 *	detém dos métodos do Spring JPA(opera o 
 *	funcionamento e organizaçao do BD).
 *
 *	JpaRepository<Telefone, Long> = instanciamos a herança do JPA 
 *	pra essa interface EnderecoRepository e passamos que a JPA deve
 *	administrar as instancias da class Endereco ao lado de cada id do
 *	tipo long
 *
 *	@Repository : detemina que é um repositorio do
 *	Banco de Dados JPA
 */

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, String>{

}
