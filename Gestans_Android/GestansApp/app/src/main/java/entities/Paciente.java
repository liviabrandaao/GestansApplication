package entities;

import java.util.List;

/**
 * Created by rebeca on 30/03/2017.
 */

public class Paciente {
    private String nome;
    private String email;
    private String CPF;
    private int numeroDeSemanas;
    private String telefone;
    private String chave;
    private List<Autoavaliacao> autoavaliacaoList;

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
        if (!getCPF().equals(paciente.getCPF())) return false;
        if (getTelefone() != null ? !getTelefone().equals(paciente.getTelefone()) : paciente.getTelefone() != null)
            return false;
        return getChave().equals(paciente.getChave());

    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + getCPF().hashCode();
        result = 31 * result + getNumeroDeSemanas();
        result = 31 * result + (getTelefone() != null ? getTelefone().hashCode() : 0);
        result = 31 * result + getChave().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "chave='" + chave + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", CPF='" + CPF + '\'' +
                ", numeroDeSemanas=" + numeroDeSemanas +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
