package br.edu.ifpb.resteasyapp.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement
@Entity
@Table(name = "tb_medico")
@NamedQuery(name = "Medico.getAll", query = "from Medico")
public class Medico {

	// Identificador auto-incrementável.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medico")
	private Integer id;
	
	@Column(name = "nome_medico" , nullable = false)
	private String nome;
	
	@Column(name = "email_medico")
	private String email;
	
	@Column(name = "cpf_medico" , nullable = false)
	private Integer cpf;
	
	@Column(name = "crm_medico" , nullable = false)
	private Integer crm;
	
	@Column(name = "telefone_medico" , nullable = false)
	private Integer telefone;
	
	@Column(name = "chave_medico", unique = true , nullable = false)
	private Integer chave;
	
	@XmlElement
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCPF() {
		return cpf;
	}

	public void setCPF(int cpf) {
		this.cpf = cpf;
	}	
	
	public int getCRM() {
		return crm;
	}

	public void setCRM(int crm) {
		this.crm = crm;
	}	
	
	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}	
	
	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}	
}
	
