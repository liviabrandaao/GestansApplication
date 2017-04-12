package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
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
                cadastrarPac(view);
            }
        });
    }

    public void cadastrarPac(View view){
        if (validaPacCampos()){
            final Paciente paciente = new Paciente(edtNome.getText().toString(), edtEmail.getText().toString(), edtCPF.getText().toString(),
                    Integer.parseInt(edtQuantS.getText().toString()), edtTel.getText().toString(), edtChave.getText().toString(),
                    edtSenha.getText().toString(),edtMotivo.getText().toString());
            new Thread(new Runnable() {

                @Override
                public void run() {

                    Call<Paciente> call = ServerConnection.getInstance().getService().insert(paciente);


                    call.enqueue(new Callback<Paciente>() {
                        @Override
                        public void onResponse(Call<Paciente> call, Response<Paciente> response) {
                            try {

                                if (response.isSuccessful()) {

                                    Toast.makeText(getApplicationContext(), "Usuário " + response.body().getNome() + " cadastrado!"
                                            ,Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(CadastrarPacienteActivity.this, MenuPacienteActivity.class);
                                    intent.putExtra("cpf", edtCPF.getText().toString());
                                    startActivity(intent);

                                } else {
                                    Log.e(this.getClass().toString(), "Error on calling " + response.code() );
                                }
                            } catch (Exception e) {
                                Log.e(this.getClass().toString(), e.getMessage().toString());
                            }

                        }

                        @Override
                        public void onFailure(Call<Paciente> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Conexão falhou" ,Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }).start();
        } else {
            Snackbar.make(view, "Verifique os campos", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public boolean validaPacCampos(){
        final String chavetemp = edtChave.getText().toString();
        if(isValidCPF(edtCPF.getText().toString()) && chavetemp.length() <= 10)
            return true;
        return false;
    }


    //validar cpf
    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
            digito = Integer.parseInt(str.substring(indice,indice+1));
            soma += digito*peso[peso.length-str.length()+indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean isValidCPF(String cpf) {
        if ((cpf==null) || (cpf.length()!=11)) return false;

        Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
    }






}

