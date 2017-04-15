package br.edu.ifpb.gestansapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        lvAA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListarAAparaPacienteActivity.this);
                builder.setMessage("Deletar?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(),"Crm ou senha inválidos!", Toast.LENGTH_SHORT).show(); //teste

                        /*
                        Autoavaliacao autoav = (Autoavaliacao)lvAA.getItemAtPosition(position);
                       new Thread(new Runnable() {

                            @Override
                            public void run() {

                                Call<Void> call = ServerConnection.getInstance().getService().deleteAutoAv(autoAv);

                                call.enqueue(new Callback<Void>() {
                                    @Override
                                    public void onResponse(Call<Void> call, Response<Void> response) {
                                        try {

                                            if (response.isSuccessful()) {
                                                Toast.makeText(getBaseContext(), "Autoavaliação deletada com sucesso!", Toast.LENGTH_LONG).show();

                                                Intent intent = new Intent(ListaAAParaPacienteActivity.this, MenuPacienteActivity.class);
                                                intent.putExtra(cpfPaciente);
                                                startActivity(intent);
                                                finish();
                                            } else {
                                                Log.e(this.getClass().toString(), "Error on calling " + response.code() );
                                            }
                                        } catch (Exception e) {
                                            Log.e(this.getClass().toString(), e.getMessage());
                                        }

                                    }

                                    @Override
                                    public void onFailure(Call<Void> call, Throwable t) {
                                        Toast.makeText(getApplicationContext(), "Conexão falhou" ,Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }
                        }).start();*/
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                                dialog.dismiss();
                            }
                        });
                // Create the AlertDialog object and return it
                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });

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
