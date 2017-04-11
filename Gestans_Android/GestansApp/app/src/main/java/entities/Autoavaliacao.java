package entities;


import java.text.DateFormat;
import java.util.Date;

/**
 * Created by rebeca on 30/03/2017.
 */

public class Autoavaliacao {

    private String dtAvaliacao;
    private String nivelDorMuscular;
    private String nivelFebre;
    private String localDorMuscular;
    private boolean sangramento;
    private boolean faltadear;
    private boolean cansaco;
    private boolean tosse;
    private boolean dordegarganta;
    private boolean dordecabeca;
    private boolean dormenciabracos;
    private boolean dormenciapernas;
    private boolean tonturas;
    private boolean desmaios;
    private String outrosSintomas;

    public Autoavaliacao(String dtAvaliacao, String nivelDorMuscular, String nivelFebre, String localDorMuscular,
                         boolean sangramento, boolean faltadear, boolean cansaco, boolean tosse, boolean dordegarganta,
                         boolean dordecabeca, boolean dormenciabracos, boolean dormenciapernas, boolean tonturas, boolean desmaios,
                         String outrosSintomas) {
        this.dtAvaliacao = dtAvaliacao;
        this.nivelDorMuscular = nivelDorMuscular;
        this.nivelFebre = nivelFebre;
        this.localDorMuscular = localDorMuscular;
        this.sangramento = sangramento;
        this.faltadear = faltadear;
        this.cansaco = cansaco;
        this.tosse = tosse;
        this.dordegarganta = dordegarganta;
        this.dordecabeca = dordecabeca;
        this.dormenciabracos = dormenciabracos;
        this.dormenciapernas = dormenciapernas;
        this.tonturas = tonturas;
        this.desmaios = desmaios;
        this.outrosSintomas = outrosSintomas;
    }

    public String getDtAvaliacao() {
        String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
        dtAvaliacao = currentDateTimeString;
        return dtAvaliacao;
    }

    public void setDtAvaliacao(String dtAvaliacao) {
        this.dtAvaliacao = dtAvaliacao;
    }

    public String getNivelDorMuscular() {
        return nivelDorMuscular;
    }

    public void setNivelDorMuscular(String nivelDorMuscular) {
        this.nivelDorMuscular = nivelDorMuscular;
    }

    public String getNivelFebre() {
        return nivelFebre;
    }

    public void setNivelFebre(String nivelFebre) {
        this.nivelFebre = nivelFebre;
    }

    public String getLocalDorMuscular() {
        return localDorMuscular;
    }

    public void setLocalDorMuscular(String localDorMuscular) {
        this.localDorMuscular = localDorMuscular;
    }

    public boolean isSangramento() {
        return sangramento;
    }

    public void setSangramento(boolean sangramento) {
        this.sangramento = sangramento;
    }

    public boolean isFaltadear() {
        return faltadear;
    }

    public void setFaltadear(boolean faltadear) {
        this.faltadear = faltadear;
    }

    public boolean isCansaco() {
        return cansaco;
    }

    public void setCansaco(boolean cansaco) {
        this.cansaco = cansaco;
    }

    public boolean isTosse() {
        return tosse;
    }

    public void setTosse(boolean tosse) {
        this.tosse = tosse;
    }

    public boolean isDordegarganta() {
        return dordegarganta;
    }

    public void setDordegarganta(boolean dordegarganta) {
        this.dordegarganta = dordegarganta;
    }

    public boolean isDordecabeca() {
        return dordecabeca;
    }

    public void setDordecabeca(boolean dordecabeca) {
        this.dordecabeca = dordecabeca;
    }

    public boolean isDormenciabracos() {
        return dormenciabracos;
    }

    public void setDormenciabracos(boolean dormenciabracos) {
        this.dormenciabracos = dormenciabracos;
    }

    public boolean isDormenciapernas() {
        return dormenciapernas;
    }

    public void setDormenciapernas(boolean dormenciapernas) {
        this.dormenciapernas = dormenciapernas;
    }

    public boolean isTonturas() {
        return tonturas;
    }

    public void setTonturas(boolean tonturas) {
        this.tonturas = tonturas;
    }

    public boolean isDesmaios() {
        return desmaios;
    }

    public void setDesmaios(boolean desmaios) {
        this.desmaios = desmaios;
    }

    public String getOutrosSintomas() {
        return outrosSintomas;
    }

    public void setOutrosSintomas(String outrosSintomas) {
        this.outrosSintomas = outrosSintomas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autoavaliacao)) return false;

        Autoavaliacao that = (Autoavaliacao) o;

        if (isSangramento() != that.isSangramento()) return false;
        if (isFaltadear() != that.isFaltadear()) return false;
        if (isCansaco() != that.isCansaco()) return false;
        if (isTosse() != that.isTosse()) return false;
        if (isDordegarganta() != that.isDordegarganta()) return false;
        if (isDordecabeca() != that.isDordecabeca()) return false;
        if (isDormenciabracos() != that.isDormenciabracos()) return false;
        if (isDormenciapernas() != that.isDormenciapernas()) return false;
        if (isTonturas() != that.isTonturas()) return false;
        if (isDesmaios() != that.isDesmaios()) return false;
        if (getDtAvaliacao() != null ? !getDtAvaliacao().equals(that.getDtAvaliacao()) : that.getDtAvaliacao() != null)
            return false;
        if (getNivelDorMuscular() != null ? !getNivelDorMuscular().equals(that.getNivelDorMuscular()) : that.getNivelDorMuscular() != null)
            return false;
        if (getNivelFebre() != null ? !getNivelFebre().equals(that.getNivelFebre()) : that.getNivelFebre() != null)
            return false;
        if (getLocalDorMuscular() != null ? !getLocalDorMuscular().equals(that.getLocalDorMuscular()) : that.getLocalDorMuscular() != null)
            return false;
        return getOutrosSintomas() != null ? getOutrosSintomas().equals(that.getOutrosSintomas()) : that.getOutrosSintomas() == null;

    }

    @Override
    public int hashCode() {
        int result = getDtAvaliacao() != null ? getDtAvaliacao().hashCode() : 0;
        result = 31 * result + (getNivelDorMuscular() != null ? getNivelDorMuscular().hashCode() : 0);
        result = 31 * result + (getNivelFebre() != null ? getNivelFebre().hashCode() : 0);
        result = 31 * result + (getLocalDorMuscular() != null ? getLocalDorMuscular().hashCode() : 0);
        result = 31 * result + (isSangramento() ? 1 : 0);
        result = 31 * result + (isFaltadear() ? 1 : 0);
        result = 31 * result + (isCansaco() ? 1 : 0);
        result = 31 * result + (isTosse() ? 1 : 0);
        result = 31 * result + (isDordegarganta() ? 1 : 0);
        result = 31 * result + (isDordecabeca() ? 1 : 0);
        result = 31 * result + (isDormenciabracos() ? 1 : 0);
        result = 31 * result + (isDormenciapernas() ? 1 : 0);
        result = 31 * result + (isTonturas() ? 1 : 0);
        result = 31 * result + (isDesmaios() ? 1 : 0);
        result = 31 * result + (getOutrosSintomas() != null ? getOutrosSintomas().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Autoavaliacao{" +
                "dtAvaliacao='" + dtAvaliacao + '\'' +
                ", nivelDorMuscular='" + nivelDorMuscular + '\'' +
                ", nivelFebre='" + nivelFebre + '\'' +
                ", localDorMuscular='" + localDorMuscular + '\'' +
                ", sangramento=" + sangramento +
                ", faltadear=" + faltadear +
                ", cansaco=" + cansaco +
                ", tosse=" + tosse +
                ", dordegarganta=" + dordegarganta +
                ", dordecabeca=" + dordecabeca +
                ", dormenciabracos=" + dormenciabracos +
                ", dormenciapernas=" + dormenciapernas +
                ", tonturas=" + tonturas +
                ", desmaios=" + desmaios +
                ", outrosSintomas='" + outrosSintomas + '\'' +
                '}';
    }
}
