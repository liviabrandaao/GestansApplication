package br.edu.ifpb.resteasyapp.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement
@Entity
@Table(name = "tb_paciente")
@NamedQuery(name = "Paciente.getAll", query = "from Paciente")
public class Paciente {

	// Identificador auto-incrementável.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paciente")
	private Integer id;
	
	@Column(name = "nome_paciente", nullable = false)
	private String nome;
	
	@Column(name = "email_paciente")
	private String email;
	
	@Column(name = "cpf_paciente" , nullable = false)
	private Integer cpf;
	
	@Column(name = "telefone_paciente" , nullable = false)
	private Integer telefone;
	
	@Column(name = "tempo_Gestacao" , nullable = false)
	private Integer tempoGestacao;
	
	@Column(name = "situacao_paciente" , nullable = false)
	private String situacao;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_chave_medico") // 
	private Medico chave;
	
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
	
	
	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
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
	
	public Medico getChave() {
		return chave;
	}

}
