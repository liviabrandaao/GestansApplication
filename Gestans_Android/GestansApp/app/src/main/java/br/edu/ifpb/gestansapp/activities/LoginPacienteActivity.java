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
import entities.Medico;
import entities.Paciente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ServerConnection;

public class LoginPacienteActivity extends AppCompatActivity {

    @BindView(R.id.edtSenhaPacientelogin) EditText edtSenha;
    @BindView(R.id.edtCPFPacientelogin) EditText edtCPF;
    @BindView(R.id.btnEntrar) Button btnEntrar;
    @BindView(R.id.btnCadastrarPaciente) Button btnCadastrar;
    @BindView(R.id.btnPacVoltarMenuInicial) FloatingActionButton btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_paciente);
        ButterKnife.bind(this);

        //Verifica os campos da chave e da senha
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validaPaciente();
            }
        });


        //Inicia o processo de cadastro da paciente
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(LoginPacienteActivity.this, CadastrarPacienteActivity.class);
               startActivity(intent);
            }
        });

        //Volta para o menu inicial
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPacienteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public  void validaPaciente(){
        new Thread(new Runnable() {
            String cpf = edtCPF.getText().toString();
            String senha = edtSenha.getText().toString();

            @Override
            public void run() {

                ServerConnection.getInstance().getService().loginPaciente(cpf, senha);

                Call<Paciente> call = ServerConnection.getInstance().getService().loginPaciente(cpf, senha);

                Log.i(this.getClass().getName(), "Verificando campos");

                call.enqueue(new Callback<Paciente>() {
                    @Override
                    public void onResponse(Call<Paciente> call, Response<Paciente> response) {

                        try {

                            if (response.isSuccessful()) {

                                Intent intent = new Intent(LoginPacienteActivity.this, MenuPacienteActivity.class);
                                intent.putExtra("cpf", cpf);
                                startActivity(intent);

                            } else {
                                Log.e(this.getClass().toString(), "Error on calling " + response.code());
                            }
                        } catch (Exception e) {
                            Log.e(this.getClass().toString(), e.getMessage().toString());
                            Toast.makeText(getApplicationContext(),"CPF ou senha inválidos!", Toast.LENGTH_SHORT).show();
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

}
