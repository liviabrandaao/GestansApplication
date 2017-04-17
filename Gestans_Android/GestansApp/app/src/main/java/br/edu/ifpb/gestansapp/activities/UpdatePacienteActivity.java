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

import br.edu.ifpb.gestansapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import entities.Paciente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ServerConnection;

public class UpdatePacienteActivity extends AppCompatActivity {

    @BindView(R.id.btnPacVoltarOpt) FloatingActionButton btnVoltarOpt;
    @BindView(R.id.edtPacNomeUp) EditText edtNome;
    @BindView(R.id.edtPacEmailUp) EditText edtEmail;
    @BindView(R.id.edtPacCPFUp) EditText edtCPF;
    @BindView(R.id.edtPacTelUp) EditText edtTel;
    @BindView(R.id.edtPacSenhaUp) EditText edtSenhaPac;
    @BindView(R.id.edtPacQuantSUp) EditText edtQuantS;
    @BindView(R.id.edtPacMotivoUp) EditText edtMotivo;
    @BindView(R.id.edtPacChaveUp) EditText edtChave;
    @BindView(R.id.btnAtualizarPac) Button btnAtualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_paciente);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        final String cpfPaciente = extras.getString("cpf");

        preenchecampos(cpfPaciente);

        btnVoltarOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdatePacienteActivity.this,OpcoesDaContaPacienteActivity.class);
                intent.putExtra("cpf", cpfPaciente);
                startActivity(intent);
            }
        });


        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarPac(cpfPaciente);
            }
        });
    }

    public void preenchecampos(String cpfPaciente){
        final String cpf = cpfPaciente;
        new Thread(new Runnable() {

            @Override
            public void run() {

                ServerConnection.getInstance().getService().getPaciente(cpf);

                Call<Paciente> call = ServerConnection.getInstance().getService().getPaciente(cpf);

                Log.i(this.getClass().getName(), "Preenchendo campos");

                call.enqueue(new Callback<Paciente>() {
                    @Override
                    public void onResponse(Call<Paciente> call, Response<Paciente> response) {

                        try {

                            if (response.isSuccessful()) {

                                Paciente paciente = response.body();
                                edtNome.setText(paciente.getNome());
                                edtEmail.setText(paciente.getEmail());
                                edtCPF.setText(paciente.getCPF());
                                edtTel.setText(paciente.getTelefone());
                                edtSenhaPac.setText(paciente.getSenha());
                                edtQuantS.setText(paciente.getNumeroDeSemanas());
                                edtMotivo.setText(paciente.getMotivo());
                                edtChave.setText(paciente.getChave());

                            } else {
                                Log.e(this.getClass().toString(), "Error on calling " + response.code());
                            }
                        } catch (Exception e) {
                            Log.e(this.getClass().toString(), e.getMessage().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Paciente> call, Throwable t) {
                        Log.e("onFailure", "Error" + t.getMessage());
                    }
                });
            }
        }).start();
    }

    public void atualizarPac(String cpfPaciente){
        final Paciente paciente = new Paciente(edtNome.getText().toString(), edtEmail.getText().toString(), edtCPF.getText().toString(),
                Integer.parseInt(edtQuantS.getText().toString()), edtTel.getText().toString(), edtChave.getText().toString(),
                edtSenhaPac.getText().toString(),edtMotivo.getText().toString());
        final String cpf = cpfPaciente;

        new Thread(new Runnable() {

            @Override
            public void run() {

                Call<Void> call = ServerConnection.getInstance().getService().updatePac(cpf, paciente);


                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        try {

                            if (response.isSuccessful()) {

                                Toast.makeText(getApplicationContext(), "Informações alteradas com sucesso!"
                                        ,Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(UpdatePacienteActivity.this, MenuPacienteActivity.class);
                                intent.putExtra("cpf", edtCPF.getText().toString());
                                startActivity(intent);

                            } else {
                                Log.e(this.getClass().toString(), "Error on calling " + response.code() );
                                Toast.makeText(getApplicationContext(), "Conexão nao foi bem sucedida" ,Toast.LENGTH_SHORT).show();
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
