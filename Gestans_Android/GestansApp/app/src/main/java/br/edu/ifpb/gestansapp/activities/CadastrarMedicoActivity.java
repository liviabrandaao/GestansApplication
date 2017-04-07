package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import entities.Medico;

public class CadastrarMedicoActivity extends AppCompatActivity {

    @BindView(R.id.btnMedVoltarLogin) Button btnVoltarLogin;
    @BindView(R.id.edtMedNomeCad) Button edtNome;
    @BindView(R.id.edtMedEmailCad) Button edtEmail;
    @BindView(R.id.edtMedCPFCad) Button edtCPF;
    @BindView(R.id.edtMedCRMCad) Button edtCRM;
    @BindView(R.id.edtMedTelCad) Button edtTel;
    @BindView(R.id.edtMedSenhaCad) Button edtSenha;
    @BindView(R.id.btnCadastrar) Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_medico);
        ButterKnife.bind(this);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarMed();
            }
        });

        btnVoltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastrarMedicoActivity.this, LoginMedicoActivity.class);
                startActivity(intent);
            }
        });

    }

    public void cadastrarMed(){
        Medico medico = new Medico(edtNome.getText().toString(),edtEmail.getText().toString(),edtCPF.getText().toString(),
                edtCRM.getText().toString(),edtTel.getText().toString(), edtSenha.getText().toString());
        //fazer inserção
    }

}
