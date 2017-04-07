package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        //Verifica os campos do crm e da chave
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String chave = edtChave.getText().toString();
                String senha = edtSenha.getText().toString();

                if (senha.equals("admin") && chave.equals("admin")){
                    Intent intent = new Intent(LoginMedicoActivity.this, MenuMedicoActivity.class);
                    startActivity(intent);
                } else {
                    edtChave.setText("");
                    edtSenha.setText("");
                }
            }
        });

        /*
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginMedicoActivity.this, CadastroMedicoActivity.class);
                startActivity(intent);
            }
        });*/

        //Volta para o menu inicial
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginMedicoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
