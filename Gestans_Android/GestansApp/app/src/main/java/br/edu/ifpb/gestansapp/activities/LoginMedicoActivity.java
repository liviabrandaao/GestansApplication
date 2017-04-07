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

public class LoginMedicoActivity extends AppCompatActivity {

    @BindView(R.id.edtSenhaMedicologin) EditText edtSenha;
    @BindView(R.id.edtChaveMedicologin) EditText edtChave;
    @BindView(R.id.btnEntrar) Button btnEntrar;
    @BindView(R.id.btnCadastrarMedico) Button btnCadastrar;
    @BindView(R.id.btnMedVoltarMenuInicial) Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_medico);
        ButterKnife.bind(this);

        //Verifica os campos da chave e da senha
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ehValido = validaMedico();
                if(ehValido) {
                    //consultar no bd qual é o médico e retorná-lo, associando a MenuMedico
                    Intent intent = new Intent(LoginMedicoActivity.this, MenuMedicoActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"Usuário ou senha inválidos!", Toast.LENGTH_SHORT).show();
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

    public boolean validaMedico(){
        String chave = edtChave.getText().toString();
        String senha = edtSenha.getText().toString();

        //Fazer consulta de verificação
        if (senha.equals("admin") && chave.equals("admin")){
            Intent intent = new Intent(LoginMedicoActivity.this, MenuMedicoActivity.class);
            startActivity(intent);
            return true;
        } else {
            edtChave.setText("");
            edtSenha.setText("");
            return false;
        }
    }
}
