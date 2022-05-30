package ProjectREST.crm.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * @Entity: refere ao Banco de Dados JPA que 
 * esta classe Endereco deve ser salva no BD do sistema
 */

@Entity
public class Endereco {
	
	/*
	 * @Id: o Spring Boot compreende que o atributo
	 * gerado como id é uma chave primaria do BD.
	 */
	
	@Id
	private long cep;
	private String estado;
	private String cidade;
	private String endereco;
	
	public Endereco() {
		super();
	}
	
	public Endereco(long cep, String estado, String cidade, String endereco) {
		super();
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.endereco = endereco;
	}
	
	public long getCep() {
		return cep;
	}
	public void setCep(long cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
