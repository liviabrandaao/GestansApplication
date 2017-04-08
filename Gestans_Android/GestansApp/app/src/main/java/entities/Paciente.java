package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rebeca on 30/03/2017.
 */

public class Paciente {
    private String nome;
    private String email;
    private String CPF;
    private int numeroDeSemanas;
    private String motivo;
    private String telefone;
    private String chave;
    private String senha;
    private ArrayList<Autoavaliacao> autoavaliacoes;

    public Paciente(String nome, String email, String CPF, int numeroDeSemanas, String telefone, String chave, String senha, String motivo) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
        this.numeroDeSemanas = numeroDeSemanas;
        this.telefone = telefone;
        this.chave = chave;
        this.senha = senha;
        this.motivo = motivo;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeSemanas() {
        return numeroDeSemanas;
    }

    public void setNumeroDeSemanas(int numeroDeSemanas) {
        this.numeroDeSemanas = numeroDeSemanas;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public ArrayList<Autoavaliacao> getAutoavaliacoes() {
        return autoavaliacoes;
    }

    public void setAutoavaliacoes(ArrayList<Autoavaliacao> autoavaliacoes) {
        this.autoavaliacoes = autoavaliacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;

        Paciente paciente = (Paciente) o;

        if (getNumeroDeSemanas() != paciente.getNumeroDeSemanas()) return false;
        if (getNome() != null ? !getNome().equals(paciente.getNome()) : paciente.getNome() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(paciente.getEmail()) : paciente.getEmail() != null)
            return false;
        if (getCPF() != null ? !getCPF().equals(paciente.getCPF()) : paciente.getCPF() != null)
            return false;
        if (getMotivo() != null ? !getMotivo().equals(paciente.getMotivo()) : paciente.getMotivo() != null)
            return false;
        if (getTelefone() != null ? !getTelefone().equals(paciente.getTelefone()) : paciente.getTelefone() != null)
            return false;
        if (getChave() != null ? !getChave().equals(paciente.getChave()) : paciente.getChave() != null)
            return false;
        return getSenha() != null ? getSenha().equals(paciente.getSenha()) : paciente.getSenha() == null;

    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getCPF() != null ? getCPF().hashCode() : 0);
        result = 31 * result + getNumeroDeSemanas();
        result = 31 * result + (getMotivo() != null ? getMotivo().hashCode() : 0);
        result = 31 * result + (getTelefone() != null ? getTelefone().hashCode() : 0);
        result = 31 * result + (getChave() != null ? getChave().hashCode() : 0);
        result = 31 * result + (getSenha() != null ? getSenha().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", CPF='" + CPF + '\'' +
                ", numeroDeSemanas=" + numeroDeSemanas +
                ", motivo='" + motivo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", chave='" + chave + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
