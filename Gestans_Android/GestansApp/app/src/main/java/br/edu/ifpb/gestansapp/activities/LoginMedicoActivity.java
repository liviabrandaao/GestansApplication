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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ServerConnection;

public class LoginMedicoActivity extends AppCompatActivity {

    @BindView(R.id.edtSenhaMedicologin) EditText edtSenha;
    @BindView(R.id.edtCRMMedicologin) EditText edtCRM;
    @BindView(R.id.btnEntrar) Button btnEntrar;
    @BindView(R.id.btnCadastrarMedico) Button btnCadastrar;
    @BindView(R.id.btnMedVoltarMenuInicial) FloatingActionButton btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_medico);
        ButterKnife.bind(this);

        //Verifica os campos da chave e da senha
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //validaMedico();
                if (edtCRM.getText().toString().equals("admin") && edtSenha.getText().toString().equals("admin")){
                    Intent i = new Intent(LoginMedicoActivity.this, MenuMedicoActivity.class);
                    i.putExtra("crm", "medicoteste");
                    startActivity(i);
                } else {
                    edtCRM.setText("");
                    edtSenha.setText("");
                    Toast.makeText(getApplicationContext(),"Chave ou senha inválidos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Inicia o processo de cadastro do Medico
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginMedicoActivity.this, CadastrarMedicoActivity.class);
                startActivity(intent);
            }
        });

        //Volta para o menu inicial
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginMedicoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void validaMedico() {

        new Thread(new Runnable() {
            String crm = edtCRM.getText().toString();
            String senha = edtSenha.getText().toString();

            @Override
            public void run() {

                ServerConnection.getInstance().getService().loginMedico(crm, senha);

                Call<Medico> call = ServerConnection.getInstance().getService().loginMedico(crm, senha);

                Log.i(this.getClass().getName(), "Verificando campos");

                call.enqueue(new Callback<Medico>() {
                    @Override
                    public void onResponse(Call<Medico> call, Response<Medico> response) {

                        try {

                            if (response.isSuccessful()) {

                                Medico medico = response.body();
                                String crmMed = medico.getCRM();
                                Intent intent = new Intent(LoginMedicoActivity.this, MenuMedicoActivity.class);
                                intent.putExtra("crm", crmMed);
                                startActivity(intent);

                            } else {
                                Log.e(this.getClass().toString(), "Error on calling " + response.code());
                            }
                        } catch (Exception e) {
                            Log.e(this.getClass().toString(), e.getMessage().toString());
                            Toast.makeText(getApplicationContext(),"Chave ou senha inválidos!", Toast.LENGTH_SHORT).show();
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
        /*
        //Fazer consulta de verificação
        if (senha.equals("admin") && chave.equals("admin")){
            Intent intent = new Intent(LoginMedicoActivity.this, MenuMedicoActivity.class);
            startActivity(intent);
            return true;
        } else {
            edtCRM.setText("");
            edtSenha.setText("");
            return false;
        }*/

}
