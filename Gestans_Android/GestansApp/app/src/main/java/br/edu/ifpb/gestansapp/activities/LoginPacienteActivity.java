package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginPacienteActivity extends AppCompatActivity {

    @BindView(R.id.edtSenhaPacientelogin) EditText edtSenha;
    @BindView(R.id.edtCPFPacientelogin) EditText edtCPF;
    @BindView(R.id.btnEntrar) Button btnEntrar;
    @BindView(R.id.btnCadastrarPaciente) Button btnCadastrar;
    @BindView(R.id.btnPacVoltarMenuInicial) Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_paciente);
        ButterKnife.bind(this);

        //Verifica os campos da chave e da senha
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ehValido = validaPaciente();
                if(ehValido) {
                    //Intent intent = new Intent(LoginPacienteActivity.this, MenuPacienteActivity.class);
                   // startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"CPF ou senha inválidos!", Toast.LENGTH_SHORT).show();
                }
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

    public boolean validaPaciente(){
        return true;
    }
}
