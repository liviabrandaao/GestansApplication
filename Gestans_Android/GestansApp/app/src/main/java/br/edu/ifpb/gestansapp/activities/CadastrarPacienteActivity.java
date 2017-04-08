package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import entities.Paciente;

public class CadastrarPacienteActivity extends AppCompatActivity {

    @BindView(R.id.btnPacVoltarLogin) Button btnVoltarLogin;
    @BindView(R.id.edtPacNomeCad) EditText edtNome;
    @BindView(R.id.edtPacEmailCad) EditText edtEmail;
    @BindView(R.id.edtPacCPFCad) EditText edtCPF;
    @BindView(R.id.edtPacTelCad) EditText edtTel;
    @BindView(R.id.edtPacSenhaCad) EditText edtSenha;
    @BindView(R.id.edtPacQuantSCad) EditText edtQuantS;
    @BindView(R.id.edtPacMotivoCad) EditText edtMotivo;
    @BindView(R.id.edtPacChaveCad) EditText edtChave;
    @BindView(R.id.btnCadastrar) Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_paciente);
        ButterKnife.bind(this);


        btnVoltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastrarPacienteActivity.this,LoginPacienteActivity.class);
                startActivity(intent);
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarPac();
            }
        });
    }

    public void cadastrarPac(){
        Paciente paciente = new Paciente(edtNome.getText().toString(), edtEmail.getText().toString(), edtCPF.getText().toString(),
                Integer.parseInt(edtQuantS.getText().toString()), edtTel.getText().toString(), edtChave.getText().toString(),
                edtSenha.getText().toString(),edtMotivo.getText().toString());

        //verificar a chave e fazer cadastro;
    }


}
