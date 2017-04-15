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

/**
 * Created by rebeca
 */

public interface APIServices {
    @POST("medico/cadastrar")
    Call<Medico> insert(@Body Medico medico);

    @POST("paciente/cadastrar")
    Call<Paciente> insert(@Body Paciente paciente);

    @POST("paciente/deletar")
    Call<Void> delete(@Body String cpf);

    @POST("medico/deletar")
    Call<Void> deleteMed(@Body String crm);

    @POST("paciente/adicionarautoavaliacao")
    Call<Autoavaliacao> insert(@Body Autoavaliacao autoavaliacao);

    @POST("medico/login")
    Call<Medico> loginMedico(@Body String chave, String senha);

    @POST("paciente/login")
    Call<Paciente> loginPaciente(@Body String cpf, String senha);

    //Lista as autoavaliacoes de pacientes associados a um medico específico
    @POST("autoavaliacoes/listar")
    Call<List<Autoavaliacao>> getAllAutoAvMedico(@Body String crm);

    @POST("autoavaliacoes/deletar")
    Call<Void> deleteAutoAv(@Body Autoavaliacao autoavaliacao);

    @POST("medico/get")
    Call<Medico> getMedico(@Body String crm);

    @POST("medico/alterar")
    Call<Void> updateMed(@Body String crm, Medico medico);
    /*
    @POST("/verificaChave")
    Call<String> chaveExiste(@Body String chave);
    */

    /*Serviço ainda não implementado */
    @POST("autoavaliacoes/listarIndividual")
    Call<List<Autoavaliacao>> getAllAutoAvPaciente(@Body String cpf);

}
