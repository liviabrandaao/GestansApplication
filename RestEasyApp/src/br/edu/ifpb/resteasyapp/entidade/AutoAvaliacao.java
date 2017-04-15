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
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Paciente paciente;
	
	@Column(name = "data_avaliacao")
	private Date dataAvaliacao;
	
	@Column(name = "dor_muscular")
	private String dorMuscular;
	
	@Column(name = "local_dor_muscular")
	private String localDor;
	
	@Column(name = "nivel_febre")
	private String nivelFrebre;
	
	@Column(name = "sangramento")
	private boolean sangramento;
	
	@Column(name = "falta_de_ar")
	private boolean faltaDeAr;
	
	@Column(name = "cansaco")
	private boolean cansaco;
	
	@Column(name = "tosse")
	private boolean tosse;
	
	@Column(name = "dor_de_garganta")
	private boolean dorDeGarganta;
	
	@Column(name = "dor_de_cabeca")
	private boolean dorDeCabeca;
	
	@Column(name = "dormencia_nos_bracos")
	private boolean dormenciaNosBracos;
	
	@Column(name = "dormencia_nos_pernas")
	private boolean dormenciaNosPernas;
	
	@Column(name = "tontura")
	private boolean tontura;
	
	@Column(name = "desmaio")
	private boolean desmaio;
	
	@Column(name = "outros_sintomas")
	private String outrosSintomas;
	
	
	@XmlElement
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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

	
	public String getNivelFrebre() {
		return nivelFrebre;
	}

	
	public void setNivelFrebre(String nivelFrebre) {
		this.nivelFrebre = nivelFrebre;
	}

	
	public boolean getSangramento() {
		return sangramento;
	}

	
	public void setSangramento(boolean sangramento) {
		this.sangramento = sangramento;
	}

	
	public boolean GetFaltaDeAr() {
		return faltaDeAr;
	}

	
	public void setFaltaDeAr(boolean faltaDeAr) {
		this.faltaDeAr = faltaDeAr;
	}

	
	public boolean GetCansaco() {
		return cansaco;
	}

	
	public void setCansaco(boolean cansaco) {
		this.cansaco = cansaco;
	}

	
	public boolean GetTosse() {
		return tosse;
	}

	
	public void setTosse(boolean tosse) {
		this.tosse = tosse;
	}

	
	public boolean GetDorDeGarganta() {
		return dorDeGarganta;
	}

	
	public void setDorDeGarganta(boolean dorDeGarganta) {
		this.dorDeGarganta = dorDeGarganta;
	}

	
	public boolean GetDorDeCabeca() {
		return dorDeCabeca;
	}

	
	public void setDorDeCabeca(boolean dorDeCabeca) {
		this.dorDeCabeca = dorDeCabeca;
	}

	
	public boolean GetDormenciaNosBracos() {
		return dormenciaNosBracos;
	}

	
	public void setDormenciaNosBracos(boolean dormenciaNosBracos) {
		this.dormenciaNosBracos = dormenciaNosBracos;
	}

	
	public boolean GetDormenciaNosPernas() {
		return dormenciaNosPernas;
	}

	
	public void setDormenciaNosPernas(boolean dormenciaNosPernas) {
		this.dormenciaNosPernas = dormenciaNosPernas;
	}

	
	public boolean GetTontura() {
		return tontura;
	}

	
	public void setTontura(boolean tontura) {
		this.tontura = tontura;
	}

	
	public boolean GetDesmaio() {
		return desmaio;
	}

	
	public void setDesmaio(boolean desmaio) {
		this.desmaio = desmaio;
	}

	
	public String getOutrosSintomas() {
		return outrosSintomas;
	}

	
	public void setOutrosSintomas(String outrosSintomas) {
		this.outrosSintomas = outrosSintomas;
	}

	
	
}
	
	
	