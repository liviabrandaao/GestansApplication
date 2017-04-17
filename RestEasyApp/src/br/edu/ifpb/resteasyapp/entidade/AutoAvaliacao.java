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
	
	@Column(name = "dt_Avaliacao")
	private String dtAvaliacao;
	
	@Column(name = "nivel_Dor_Muscular")
	private String nivelDorMuscular;
	
	@Column(name = "nivel_febre")
	private String nivelFebre;
	
	@Column(name = "local_dor_muscular")
	private String localDorMuscular;
	
	@Column(name = "sangramento")
	private String sangramento;
	
	@Column(name = "falta_de_ar")
	private String faltadear;
	
	@Column(name = "cansaco")
	private String cansaco;
	
	@Column(name = "tosse")
	private String tosse;
	
	@Column(name = "dor_de_garganta")
	private String dordegarganta;
	
	@Column(name = "dor_de_cabeca")
	private String dordecabeca;
	
	@Column(name = "dormencia_nos_bracos")
	private String dormenciabracos;
	
	@Column(name = "dormencia_nos_pernas")
	private String dormenciapernas;
	
	@Column(name = "tonturas")
	private String tonturas;
	
	@Column(name = "desmaios")
	private String desmaios;
	
	@Column(name = "outros_sintomas")
	private String outrosSintomas;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "cpf_paciente")
	private Paciente paciente;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "crm_medico")
	private Medico medico;
	
		
	
	@XmlElement
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDataAvaliacao() {
		return dtAvaliacao;
	}
	
	public void setDataAvaliacao(String dtAvaliacao) {
		this.dtAvaliacao = dtAvaliacao;
	}
	
	public String getDorMuscular() {
		return nivelDorMuscular;
	}

	public void setDorMuscular(String nivelDorMuscular) {
		this.nivelDorMuscular = nivelDorMuscular;
	}
	
	public String getNivelFebre() {
		return nivelFebre;
	}
	
	public void setNivelFebre(String nivelFebre) {
		this.nivelFebre = nivelFebre;
	}
	
	public String getLocalDor() {
		return localDorMuscular;
	}

	
	public void setLocalDor(String localDorMuscular) {
		this.localDorMuscular = localDorMuscular;
	}

	public String getSangramento() {
		return sangramento;
	}

	
	public void setSangramento(String sangramento) {
		this.sangramento = sangramento;
	}

	public String GetFaltaDeAr() {
		return faltadear;
	}

	
	public void setFaltaDeAr(String faltadear) {
		this.faltadear = faltadear;
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
		return dordegarganta;
	}

	
	public void setDorDeGarganta(String dordegarganta) {
		this.dordegarganta = dordegarganta;
	}

	public String GetDorDeCabeca() {
		return dordecabeca;
	}

	
	public void setDorDeCabeca(String dordecabeca) {
		this.dordecabeca = dordecabeca;
	}

	public String GetDormenciaNosBracos() {
		return dormenciabracos;
	}

	
	public void setDormenciaNosBracos(String dormenciabracos) {
		this.dormenciabracos = dormenciabracos;
	}

	
	public String GetDormenciaNasPernas() {
		return dormenciapernas;
	}

	
	public void setDormenciaNasPernas(String dormenciapernas) {
		this.dormenciapernas = dormenciapernas;
	}
	
	public String GetTontura() {
		return tonturas;
	}

	
	public void setTontura(String tonturas) {
		this.tonturas = tonturas;
	}

	
	public String GetDesmaio() {
		return desmaios;
	}

	
	public void setDesmaio(String desmaios) {
		this.desmaios = desmaios;
	}
	

	public String GetOutrosSintomas() {
		return outrosSintomas;
	}

	
	public void setPutrosSintomas(String outrosSintomas) {
		this.outrosSintomas = outrosSintomas;
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
	
	

	
	

	

	
	

	
	
	

	
	
	
	

	
	

	
	public String getOutrosSintomas() {
		return outrosSintomas;
	}

	
	public void setOutrosSintomas(String outrosSintomas) {
		this.outrosSintomas = outrosSintomas;
	}

	
	
}
	
	
	