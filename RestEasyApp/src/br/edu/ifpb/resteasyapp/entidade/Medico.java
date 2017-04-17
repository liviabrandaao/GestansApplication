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
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medico")
	private Integer id;
	
	@Column(name = "nome_medico" , nullable = false)
	private String nome;
	
	@Column(name = "email_medico")
	private String email;
	
	@Column(name = "cpf_medico")
	private String CPF;
	
	@Column(name = "crm_medico" , nullable = false)
	private String CRM;
	
	@Column(name = "telefone_medico" , nullable = false)
	private String telefone;
	
	@Id
	@Column(name = "chave_medico", unique = true , nullable = false)
	private String chave;
	
	@Column(name = "senha_medico", nullable = false)
	private String senha;
	
	
	
	
	
	@XmlElement
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}	
	
	public String getCRM() {
		return CRM;
	}

	public void setCRM(String CRM) {
		this.CRM = CRM;
	}	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
	
	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	
	
	
	
}
	
