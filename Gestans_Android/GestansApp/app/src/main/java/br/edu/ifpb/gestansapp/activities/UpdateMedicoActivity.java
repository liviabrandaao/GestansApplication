package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.nearby.messages.internal.Update;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import entities.Medico;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ServerConnection;

public class UpdateMedicoActivity extends AppCompatActivity {

    @BindView(R.id.btnMedVoltarOpt) FloatingActionButton btnVoltarOpt;
    @BindView(R.id.edtMedNomeUp) EditText edtNome;
    @BindView(R.id.edtMedEmailUp) EditText edtEmail;
    @BindView(R.id.edtMedUpCPF) EditText edtCPF;
    @BindView(R.id.edtMedCRMUp) EditText edtCRM;
    @BindView(R.id.edtMedTelUp) EditText edtTel;
    @BindView(R.id.edtMedSenhaUp) EditText edtSenha;
    @BindView(R.id.edtMedChaveUp) EditText edtChave;
    @BindView(R.id.btnAtualizar) Button btnAtualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_medico);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        final String crmMed = extras.getString("crm");

        preenchecamposMed(crmMed);

        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarMed(crmMed);
            }
        });

        btnVoltarOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateMedicoActivity.this,MenuMedicoActivity.class);
                intent.putExtra("crm",crmMed);
                startActivity(intent);
            }
        });
    }

    public void preenchecamposMed(String crmMed){
        final String crm = crmMed;
        new Thread(new Runnable() {

            @Override
            public void run() {

                ServerConnection.getInstance().getService().getMedico(crm);

                Call<Medico> call = ServerConnection.getInstance().getService().getMedico(crm);

                Log.i(this.getClass().getName(), "Preenchendo campos");

                call.enqueue(new Callback<Medico>() {
                    @Override
                    public void onResponse(Call<Medico> call, Response<Medico> response) {

                        try {

                            if (response.isSuccessful()) {

                                Medico medico = response.body();
                                edtNome.setText(medico.getNome());
                                edtEmail.setText(medico.getEmail());
                                edtCPF.setText(medico.getCPF());
                                edtCRM.setText(medico.getCRM());
                                edtTel.setText(medico.getTelefone());
                                edtSenha.setText(medico.getSenha());
                                edtChave.setText(medico.getChave());

                            } else {
                                Log.e(this.getClass().toString(), "Error on calling " + response.code());
                            }
                        } catch (Exception e) {
                            Log.e(this.getClass().toString(), e.getMessage().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Medico> call, Throwable t) {
                        Log.e("onFailure", "Error" + t.getMessage());
                    }
                });
            }
        }).start();
    }

    public void atualizarMed(String crmMed){
        final Medico medico = new Medico(edtNome.getText().toString(), edtEmail.getText().toString(), edtCPF.getText().toString(),
                edtCRM.getText().toString(), edtTel.getText().toString(), edtSenha.getText().toString(), edtChave.getText().toString());

        final String crm = crmMed;

        new Thread(new Runnable() {

            @Override
            public void run() {

                Call<Void> call = ServerConnection.getInstance().getService().updateMed(crm, medico);


                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        try {

                            if (response.isSuccessful()) {

                                Toast.makeText(getApplicationContext(), "Informações alteradas com sucesso!"
                                        ,Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(UpdateMedicoActivity.this, MenuMedicoActivity.class);
                                intent.putExtra("chave", edtChave.getText().toString());
                                startActivity(intent);

                            } else {
                                Log.e(this.getClass().toString(), "Error on calling " + response.code() );
                            }
                        } catch (Exception e) {
                            Log.e(this.getClass().toString(), e.getMessage().toString());
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Conexão falhou" ,Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }).start();
    }

}
