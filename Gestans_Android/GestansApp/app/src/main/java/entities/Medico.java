package entities;

/**
 * Created by rebeca on 30/03/2017.
 */

public class Medico {

    private String nome;
    private String email;
    private String CPF;
    private String CRM;
    private String telefone;
    private String chave;
    private String senha;


    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medico)) return false;

        Medico medico = (Medico) o;

        if (getNome() != null ? !getNome().equals(medico.getNome()) : medico.getNome() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(medico.getEmail()) : medico.getEmail() != null)
            return false;
        if (getCPF() != null ? !getCPF().equals(medico.getCPF()) : medico.getCPF() != null)
            return false;
        if (getCRM() != null ? !getCRM().equals(medico.getCRM()) : medico.getCRM() != null)
            return false;
        if (getTelefone() != null ? !getTelefone().equals(medico.getTelefone()) : medico.getTelefone() != null)
            return false;
        if (getChave() != null ? !getChave().equals(medico.getChave()) : medico.getChave() != null)
            return false;
        return getSenha() != null ? getSenha().equals(medico.getSenha()) : medico.getSenha() == null;

    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getCPF() != null ? getCPF().hashCode() : 0);
        result = 31 * result + (getCRM() != null ? getCRM().hashCode() : 0);
        result = 31 * result + (getTelefone() != null ? getTelefone().hashCode() : 0);
        result = 31 * result + (getChave() != null ? getChave().hashCode() : 0);
        result = 31 * result + (getSenha() != null ? getSenha().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", CPF='" + CPF + '\'' +
                ", CRM='" + CRM + '\'' +
                ", telefone='" + telefone + '\'' +
                ", chave='" + chave + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}

