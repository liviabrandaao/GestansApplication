package service;

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

    @POST("paciente/adicionarautoavaliacao")
    Call<Autoavaliacao> insert(@Body Autoavaliacao autoavaliacao);

    @POST("medico/login")
    Call<Medico> loginMedico(@Body String chave, String senha);

    @POST("paciente/login")
    Call<Paciente> loginPaciente(@Body String cpf, String senha);

    //Lista as autoavaliacoes de pacientes associados a um medico específico
    @POST("autoavaliacoes/listar")
    Call<List<Autoavaliacao>> getAllAutoAvMedico(@Body String chave);

    /*
    @POST("/verificaChave")
    Call<String> chaveExiste(@Body String chave);
    */

    /*Serviço ainda não implementado */
    @POST("autoavaliacoes/listarIndividual")
    Call<List<Autoavaliacao>> getAllAutoAvPaciente(@Body String cpf);

}
