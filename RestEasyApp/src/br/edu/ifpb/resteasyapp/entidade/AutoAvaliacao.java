package br.edu.ifpb.resteasyapp.entidade;

import java.sql.Date;

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
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;


@XmlRootElement
@Entity
@Table(name = "tb_autoAvaliacao")
@NamedQuery(name = "AutoAvaliacao.getAll", query = "from AutoAvaliacao")
public class AutoAvaliacao {

	// Identificador auto-incrementável.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autoAvaliacao")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "cpf_paciente")
	private Paciente paciente;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "crm_medico")
	private Medico medico;
	
	@Column(name = "data_avaliacao")
	private Date dataAvaliacao;
	
	@Column(name = "dor_muscular")
	private String dorMuscular;
	
	@Column(name = "local_dor_muscular")
	private String localDor;
	
	@Column(name = "nivel_febre")
	private String nivelFebre;
	
	@Column(name = "sangramento")
	private String sangramento;
	
	@Column(name = "falta_de_ar")
	private String faltaDeAr;
	
	@Column(name = "cansaco")
	private String cansaco;
	
	@Column(name = "tosse")
	private String tosse;
	
	@Column(name = "dor_de_garganta")
	private String dorDeGarganta;
	
	@Column(name = "dor_de_cabeca")
	private String dorDeCabeca;
	
	@Column(name = "dormencia_nos_bracos")
	private String dormenciaNosBracos;
	
	@Column(name = "dormencia_nos_pernas")
	private String dormenciaNosPernas;
	
	@Column(name = "tontura")
	private String tontura;
	
	@Column(name = "desmaio")
	private String desmaio;
	
	@Column(name = "outros_sintomas")
	private String outrosSintomas;
	
	
	@XmlElement
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Paciente getCPF() {
		return paciente;
	}

	public void setCPF(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Medico getCRM() {
		return medico;
	}

	public void setCRM(Medico medico) {
		this.medico = medico;
	}
	
	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}
	
	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	
	public String getDorMuscular() {
		return dorMuscular;
	}

	public void setDorMuscular(String dorMuscular) {
		this.dorMuscular = dorMuscular;
	}

	
	public String getLocalDor() {
		return localDor;
	}

	
	public void setLocalDor(String localDor) {
		this.localDor = localDor;
	}

	
	public String getNivelFebre() {
		return nivelFebre;
	}

	
	public void setNivelFebre(String nivelFebre) {
		this.nivelFebre = nivelFebre;
	}

	
	public String getSangramento() {
		return sangramento;
	}

	
	public void setSangramento(String sangramento) {
		this.sangramento = sangramento;
	}

	
	public String GetFaltaDeAr() {
		return faltaDeAr;
	}

	
	public void setFaltaDeAr(String faltaDeAr) {
		this.faltaDeAr = faltaDeAr;
	}

	
	public String GetCansaco() {
		return cansaco;
	}

	
	public void setCansaco(String cansaco) {
		this.cansaco = cansaco;
	}

	
	public String GetTosse() {
		return tosse;
	}

	
	public void setTosse(String tosse) {
		this.tosse = tosse;
	}

	
	public String GetDorDeGarganta() {
		return dorDeGarganta;
	}

	
	public void setDorDeGarganta(String dorDeGarganta) {
		this.dorDeGarganta = dorDeGarganta;
	}

	
	public String GetDorDeCabeca() {
		return dorDeCabeca;
	}

	
	public void setDorDeCabeca(String dorDeCabeca) {
		this.dorDeCabeca = dorDeCabeca;
	}

	
	public String GetDormenciaNosBracos() {
		return dormenciaNosBracos;
	}

	
	public void setDormenciaNosBracos(String dormenciaNosBracos) {
		this.dormenciaNosBracos = dormenciaNosBracos;
	}

	
	public String GetDormenciaNasPernas() {
		return dormenciaNosPernas;
	}

	
	public void setDormenciaNasPernas(String dormenciaNosPernas) {
		this.dormenciaNosPernas = dormenciaNosPernas;
	}

	
	public String GetTontura() {
		return tontura;
	}

	
	public void setTontura(String tontura) {
		this.tontura = tontura;
	}

	
	public String GetDesmaio() {
		return desmaio;
	}

	
	public void setDesmaio(String desmaio) {
		this.desmaio = desmaio;
	}

	
	public String getOutrosSintomas() {
		return outrosSintomas;
	}

	
	public void setOutrosSintomas(String outrosSintomas) {
		this.outrosSintomas = outrosSintomas;
	}

	
	
}
	
	
	