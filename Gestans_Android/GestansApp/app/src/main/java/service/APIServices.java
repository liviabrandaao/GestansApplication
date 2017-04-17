package service;

import android.support.design.widget.BaseTransientBottomBar;

import java.util.List;

import entities.Autoavaliacao;
import entities.Medico;
import entities.Paciente;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by rebeca
 */

public interface APIServices {
    @POST("medico/cadastrar")
    Call<Medico> insert(@Body Medico medico);

    @POST("paciente/cadastrar")
    Call<Paciente> insert(@Body Paciente paciente);

    @POST("medico/deletar")
    Call<Void> deleteMed(@Body String crm);

    @POST("paciente/deletar")
    Call<Void> delete(@Body String cpf);

    @POST("autoAvaliacao/inserir")
    Call<Autoavaliacao> insert(@Body Autoavaliacao autoavaliacao);

    @POST("medico/login")
    Call<Medico> loginMedico(@Body String chave, String senha);

    @POST("paciente/login")
    Call<Paciente> loginPaciente(@Body String cpf, String senha);

    //Lista as autoavaliacoes de pacientes associados a um medico específico
    @POST("autoAvaliacao/listar/crm/{crm}")
    Call<List<Autoavaliacao>> getAllAutoAvMedico(@Body @Path("crm") String crm);

    /*Serviço ainda não implementado */
    @POST("autoAvaliacao/listar/cpf/{cpf}")
    Call<List<Autoavaliacao>> getAllAutoAvPaciente(@Body @Path("cpf") String cpf);

    @POST("autoAvaliacao/deletar")
    Call<Void> deleteAutoAv(@Body Autoavaliacao autoavaliacao);

    @POST("medico/get")
    Call<Medico> getMedico(@Body String crm);

    @POST("paciente/get")
    Call<Paciente> getPaciente(@Body String cpf);

    @POST("medico/alterar")
    Call<Void> updateMed(@Body String crm, Medico medico);

    @POST("paciente/alterar")
    Call<Void> updatePac(@Body String cpf, Paciente paciente);



}
