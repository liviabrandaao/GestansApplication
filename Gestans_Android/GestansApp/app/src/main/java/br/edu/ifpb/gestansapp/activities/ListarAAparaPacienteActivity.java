package br.edu.ifpb.gestansapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindView;
import entities.Autoavaliacao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ServerConnection;

public class ListarAAparaPacienteActivity extends AppCompatActivity {

    private String cpfPaciente;
    @BindView(R.id.lvAAPaciente) ListView lvAA;
    ArrayAdapter<Autoavaliacao> adapter;
    List<Autoavaliacao> autoavaliacoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_aapara_paciente);

        Bundle extras = getIntent().getExtras();
        cpfPaciente = extras.getString("cpf");

        autoavaliacoes = new ArrayList<Autoavaliacao>();
        adapter = new ArrayAdapter<Autoavaliacao>(this, android.R.layout.simple_list_item_activated_1, autoavaliacoes);
        lvAA.setAdapter(adapter);

        listarAutoAv(cpfPaciente);
    }

    public void listarAutoAv(final String cpf){

        new Thread(new Runnable() {
            @Override
            public void run() {

                Call<List<Autoavaliacao>> call = ServerConnection.getInstance().getService().getAllAutoAvPaciente(cpf);

                Log.i(this.getClass().getName(), "Calling list");

                call.enqueue(new Callback<List<Autoavaliacao>>() {
                    @Override
                    public void onResponse(Call<List<Autoavaliacao>> call, Response<List<Autoavaliacao>> response) {

                        try{

                            if(response.isSuccessful()){
                                List<Autoavaliacao> autoavsResponse = response.body();

                                autoavaliacoes.addAll(autoavsResponse);
                                adapter.notifyDataSetChanged();
                            }
                            else{
                                Log.e(this.getClass().toString(), "Error on calling");
                            }


                        }
                        catch (Exception e){
                            Log.e(this.getClass().toString(), "Error on calling");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Autoavaliacao>> call, Throwable t) {
                        Log.e("onFailure", "Error");
                    }
                });
            }
        }).start();
    }

}
