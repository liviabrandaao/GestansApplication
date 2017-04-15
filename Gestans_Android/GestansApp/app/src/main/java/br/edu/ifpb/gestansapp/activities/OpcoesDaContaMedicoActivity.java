package br.edu.ifpb.gestansapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OpcoesDaContaMedicoActivity extends AppCompatActivity {

    @BindView(R.id.fbtnVoltarMenuMed)
    FloatingActionButton fbtnVoltar;
    @BindView(R.id.btnAtualizarInfoContaMed)
    Button btnAtualizarInfo;
    @BindView(R.id.btnDeletarContaMed) Button btnDeletarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes_da_conta_medico);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        final String chaveMed = extras.getString("chave");

        fbtnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpcoesDaContaMedicoActivity.this, MenuMedicoActivity.class);
                intent.putExtra("chave",chaveMed);
                startActivity(intent);
            }
        });

        btnAtualizarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update info
            }
        });

        btnDeletarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletarMedico(chaveMed);
            }
        });
    }

    public void deletarMedico(String chave){
        final String chaveM = chave;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja deletar sua conta?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(),"Chave ou senha inválidos!", Toast.LENGTH_SHORT).show(); //teste
                        /*
                        new Thread(new Runnable() {

                            @Override
                            public void run() {

                                Call<Void> call = ServerConnection.getInstance().getService().delete(chaveM);

                                call.enqueue(new Callback<Void>() {
                                    @Override
                                    public void onResponse(Call<Void> call, Response<Void> response) {
                                        try {

                                            if (response.isSuccessful()) {
                                                Toast.makeText(getBaseContext(), "Conta deletada com sucesso!", Toast.LENGTH_LONG).show();

                                                Intent intent = new Intent(OpcoesDaContaMedicoActivity.this, MainActivity.class);
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
