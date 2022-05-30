package ProjectREST.crm.Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * @Entity: refere ao Banco de Dados JPA que 
 * esta classe Pessoa deve ser salva no BD do sistema
 */

@Entity
public class Cliente {

	/*
	 * @Id: o Spring Boot compreende que o atributo
	 * gerado como id é uma chave primaria do BD.
	 * 
	 * @GeneratedValue: gera e incrementa os valores
	 * de id automaticamente.
	 * 
	 * GenerationType.IDENTITY : determina que o id deve ser 
	 * incrementado automaticamente no Banco de Dados
	 * 
	 * @ManyToOne: um mesmo usuario pode compartilhar do mesmo 
	 * endereco.
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	private String cpf;
	
	@ManyToOne
	private Endereco endereco;
	
	@ManyToOne
	private Telefone telefone;
	
	public Cliente() {
		super();
	}
	
	public Cliente(long id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return id == other.id;
	}
	
}

