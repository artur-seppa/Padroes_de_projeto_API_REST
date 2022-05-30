package ProjectREST.crm.Model;

import javax.persistence.Id;
import javax.persistence.Entity;

/*
 * @Entity: refere ao Banco de Dados JPA que 
 * esta classe Telefone deve ser salva no BD do sistema
 */

@Entity
public class Telefone {

	/*
	 * @Id: o Spring Boot compreende que o atributo
	 * gerado como id é uma chave primaria do BD.
	 */
	
	@Id
	private String telefone;
	private String ddd;
	
	public Telefone() {
		super();
	}

	public Telefone(String ddd, String telefone) {
		super();
		this.ddd = ddd;
		this.telefone = telefone;
	}
	
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
	
}
