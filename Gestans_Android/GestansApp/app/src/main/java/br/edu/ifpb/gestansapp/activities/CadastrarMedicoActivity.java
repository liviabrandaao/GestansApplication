package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class CadastrarMedicoActivity extends AppCompatActivity {

    @BindView(R.id.btnMedVoltarLogin) FloatingActionButton btnVoltarLogin;
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
                cadastrarMed(view);
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

    public void cadastrarMed(View view){
        if (validaMedCampos()) {
            final Medico medico = new Medico(edtNome.getText().toString(), edtEmail.getText().toString(), edtCPF.getText().toString(),
                    edtCRM.getText().toString(), edtTel.getText().toString(), edtSenha.getText().toString(), edtChave.getText().toString());

            new Thread(new Runnable() {

                @Override
                public void run() {

                    Call<Medico> call = ServerConnection.getInstance().getService().insert(medico);


                    call.enqueue(new Callback<Medico>() {
                        @Override
                        public void onResponse(Call<Medico> call, Response<Medico> response) {
                            try {

                                if (response.isSuccessful()) {

                                    Toast.makeText(getApplicationContext(), "Usuário " + response.body().getNome() + " cadastrado!"
                                            ,Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(CadastrarMedicoActivity.this, MenuMedicoActivity.class);
                                    intent.putExtra("chave", edtChave.getText().toString());
                                    startActivity(intent);

                                } else {
                                    Log.e(this.getClass().toString(), "Error on calling " + response.code() );
                                }
                            } catch (Exception e) {
                                Log.e(this.getClass().toString(), e.getMessage().toString());
                            }

                        }

                        @Override
                        public void onFailure(Call<Medico> call, Throwable t) {
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

    public boolean validaMedCampos(){
        if(isValidCPF(edtCPF.getText().toString()) && edtChave.getText().toString().length() <= 10)
          return true;
        else
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
