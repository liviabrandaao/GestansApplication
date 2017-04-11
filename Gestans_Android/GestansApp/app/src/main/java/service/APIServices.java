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
 * Created by rebeca on 11/04/2017.
 */

public interface APIServices {
    @POST("medico/cadastrar")
    Call<Medico> insert(@Body Medico medico);

    @POST("paciente/cadastrar")
    Call<Paciente> insert(@Body Paciente paciente);

    @POST("medico/login")
    Call<Medico> login(@Body Medico medicoRecebido);

    @POST("paciente/login")
    Call<Paciente> login(@Body Paciente pacienteRecebida);

    @GET("autoavaliacoes/listar")
    Call<List<Autoavaliacao>> getAll();

}
