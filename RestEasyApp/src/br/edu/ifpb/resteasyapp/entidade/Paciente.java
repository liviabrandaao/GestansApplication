package br.edu.ifpb.resteasyapp.entidade;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

import br.edu.ifpb.resteasyapp.dao.MedicoDAO;
import br.edu.ifpb.resteasyapp.dao.PacienteDAO;

@XmlRootElement
@Entity
@Table(name = "tb_paciente")
@NamedQuery(name = "Paciente.getAll", query = "from Paciente")
public class Paciente {


	
	@Id
	@Column(name = "cpf_paciente" , unique = true, nullable = false)
	private String cpf;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "chave_medico")
	private Medico medico;
		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paciente")
	private Integer id;
	
	@Column(name = "senha_paciente", nullable = false)
	private String senha;
	
	@Column(name = "nome_paciente", nullable = false)
	private String nome;
	
	@Column(name = "email_paciente")
	private String email;
	
	@Column(name = "telefone_paciente" , nullable = false)
	private String telefone;
	
	@Column(name = "tempo_Gestacao" , nullable = false)
	private Integer tempoGestacao;
	
	@Column(name = "situacao_paciente" , nullable = false)
	private String situacao;
	
	
	@XmlElement
	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}	
	
	public Medico getChave() {
		return medico;
	}
	
	public void setChave(Medico medico) {
		this.medico = medico;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
	
	public int getTempoDeGestacao() {
		return tempoGestacao;
	}

	public void setTempoDeGestacao(int tempoGestacao) {
		this.tempoGestacao = tempoGestacao;
	}	
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}
