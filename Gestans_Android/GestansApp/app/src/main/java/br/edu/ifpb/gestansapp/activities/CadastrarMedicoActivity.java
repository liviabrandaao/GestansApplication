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
import entities.Medico;

public class CadastrarMedicoActivity extends AppCompatActivity {

    @BindView(R.id.btnMedVoltarLogin) Button btnVoltarLogin;
    @BindView(R.id.edtMedNomeCad) EditText edtNome;
    @BindView(R.id.edtMedEmailCad) EditText edtEmail;
    @BindView(R.id.edtMedCPFCad) EditText edtCPF;
    @BindView(R.id.edtMedCRMCad) EditText edtCRM;
    @BindView(R.id.edtMedTelCad) EditText edtTel;
    @BindView(R.id.edtMedSenhaCad) EditText edtSenha;
    @BindView(R.id.edtMedChaveCad) EditText edtChave;
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
                edtCRM.getText().toString(),edtTel.getText().toString(), edtSenha.getText().toString(), edtChave.getText().toString());
        //fazer inserção
    }

}
