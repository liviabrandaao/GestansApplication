package br.edu.ifpb.gestansapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import entities.Paciente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ServerConnection;

public class OpcoesContaPacienteActivity extends AppCompatActivity {

    @BindView(R.id.btnPacVoltarMenu) FloatingActionButton btnVoltar;
    @BindView(R.id.btnPacAtualizarConta) Button btnAtualizarConta;
    @BindView(R.id.btnPacDeletarConta) Button btnDeletarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_conta_paciente);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        final String cpfPaciente = extras.getString("cpf");

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpcoesContaPacienteActivity.this, MenuPacienteActivity.class);
                intent.putExtra("cpf",cpfPaciente);
                startActivity(intent);
            }
        });

        btnAtualizarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update paciente
            }
        });

        btnDeletarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletarPaciente(cpfPaciente);
            }
        });
    }

    public void deletarPaciente(String cpf){
        final String cpfP = cpf;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja deletar sua conta?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(),"CPF ou senha inválidos!", Toast.LENGTH_SHORT).show();
                        /*
                        new Thread(new Runnable() {

                            @Override
                            public void run() {

                                Call<Void> call = ServerConnection.getInstance().getService().delete(cpfP);

                                call.enqueue(new Callback<Void>() {
                                    @Override
                                    public void onResponse(Call<Void> call, Response<Void> response) {
                                        try {

                                            if (response.isSuccessful()) {
                                                Toast.makeText(getBaseContext(), "Conta deletada com sucesso!", Toast.LENGTH_LONG).show();

                                                Intent intent = new Intent(OpcoesContaPacienteActivity.this, MainActivity.class);
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
}
