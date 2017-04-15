package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.graphics.RadialGradient;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import entities.Autoavaliacao;
import entities.Paciente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ServerConnection;


public class AddAutoAvaliacaoActivity extends AppCompatActivity {

    private String[] arraySpinnerDor;
    private String[] arraySpinnerFebre;
    private boolean sangramento;
    private boolean faltaDeAr;
    private boolean cansaco;
    private boolean tosse;
    private boolean dordegarganta;
    private boolean doresdecabeca;
    private boolean dormenciap;
    private boolean dormenciab;
    private boolean tonturas;
    private boolean desmaios;


    @BindView(R.id.spinnerDor) Spinner niveisDeDor;
    @BindView(R.id.spinnerFebre) Spinner niveisDeFebre;
    @BindView(R.id.edtLocalDor) EditText edtLocalDor;
    @BindView(R.id.rgSangramento) RadioGroup rgSangramento;
    @BindView(R.id.rgFaltadear) RadioGroup rgFaltadear;
    @BindView(R.id.rgcansaco) RadioGroup rgcansaco;
    @BindView(R.id.rgtosse) RadioGroup rgtosse;
    @BindView(R.id.rgdorgarganta) RadioGroup rgdorgarganta;
    @BindView(R.id.rgdoresdecabeca) RadioGroup rgdoresdecabeca;
    @BindView(R.id.rgdormenciap) RadioGroup rgdormenciapernas;
    @BindView(R.id.rgdormenciab) RadioGroup rgdormenciabracos;
    @BindView(R.id.rgtonturas) RadioGroup rgtonturas;
    @BindView(R.id.rgdesmaios) RadioGroup rgdesmaios;
    @BindView(R.id.edtOutros) EditText edtOutros;
    @BindView(R.id.btnSalvarAutoAv) Button btnSalvar;
    @BindView(R.id.btnVoltarMenuPac) FloatingActionButton btnVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_auto_avaliacao);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        final String cpfPaciente = extras.getString("cpf");


        //Seta os valores dos niveis de dor no spinner da tela
        this.arraySpinnerDor = new String[] {
                "0","1", "2", "3", "4", "5", "6", "7","8","9","10"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerDor);
        niveisDeDor.setAdapter(adapter);

        //Seta os valores do spinner de febre
        this.arraySpinnerFebre = new String[] {
                "Não", "Alta (Acima de 38º)", "Baixa (Abaixo de 38º)"
        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerFebre);
        niveisDeFebre.setAdapter(adapter2);


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddAutoAvaliacaoActivity.this, MenuPacienteActivity.class);
                intent.putExtra("cpf",cpfPaciente);
                startActivity(intent);
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar(cpfPaciente);
            }
        });
    }

    public void salvar(String cpf){
        switch(rgSangramento.getCheckedRadioButtonId()){
            case R.id.rbSangramentoSim:
                sangramento = true;
                break;
            case R.id.rbSangramentoNao:
                sangramento = false;
                break;
        }
        switch(rgFaltadear.getCheckedRadioButtonId()){
            case R.id.rbFaltaSim:
                faltaDeAr = true;
                break;
            case R.id.rbSangramentoNao:
                faltaDeAr = false;
                break;
        }
        switch(rgcansaco.getCheckedRadioButtonId()){
            case R.id.rbCansacoSim:
                cansaco = true;
                break;
            case R.id.rbCansacoNao:
                cansaco = false;
                break;
        }
        switch(rgtosse.getCheckedRadioButtonId()){
            case R.id.rbTosseSim:
                tosse = true;
                break;
            case R.id.rbTosseNao:
                tosse = false;
                break;
        }
        switch(rgdorgarganta.getCheckedRadioButtonId()){
            case R.id.rbDorGSim:
                dordegarganta = true;
                break;
            case R.id.rbDorGNao:
                dordegarganta = false;
                break;
        }
        switch(rgdoresdecabeca.getCheckedRadioButtonId()){
            case R.id.rbFrequentesSim:
                doresdecabeca = true;
                break;
            case R.id.rbFrequentesNao:
                doresdecabeca = false;
                break;
        }
        switch(rgdormenciapernas.getCheckedRadioButtonId()){
            case R.id.rbDormenciaSim:
                dormenciap = true;
                break;
            case R.id.rbDormenciaNao:
                dormenciap = false;
                break;
        }
        switch(rgdormenciabracos.getCheckedRadioButtonId()){
            case R.id.rbDormenciaBSim:
                dormenciab = true;
                break;
            case R.id.rbDormenciaBNao:
                dormenciab = false;
                break;
        }
        switch(rgdesmaios.getCheckedRadioButtonId()){
            case R.id.rbDesmaiosSim:
                desmaios = true;
                break;
            case R.id.rbDesmaiosNao:
                desmaios = false;
                break;
        }
        switch(rgtonturas.getCheckedRadioButtonId()){
            case R.id.rbtonturaSim:
                tonturas = true;
                break;
            case R.id.rbtonturaNao:
                tonturas = false;
                break;
        }
        String nivelDor = niveisDeDor.getSelectedItem().toString();
        String localDor = edtLocalDor.getText().toString();
        String outrosS = edtOutros.getText().toString();
        String febre = niveisDeFebre.getSelectedItem().toString();
        final Autoavaliacao autoavaliacao = new Autoavaliacao(nivelDor,febre,localDor,sangramento,faltaDeAr,cansaco,tosse,
                dordegarganta,doresdecabeca,dormenciab,dormenciap,tonturas,desmaios,outrosS,cpf);

        final String cpfP = cpf;
        new Thread(new Runnable() {

            @Override
            public void run() {

                Call<Autoavaliacao> call = ServerConnection.getInstance().getService().insert(autoavaliacao);


                call.enqueue(new Callback<Autoavaliacao>() {
                    @Override
                    public void onResponse(Call<Autoavaliacao> call, Response<Autoavaliacao> response) {
                        try {

                            if (response.isSuccessful()) {

                                Toast.makeText(getApplicationContext(), "Autoavaliação adicionada à ficha!"
                                        ,Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(AddAutoAvaliacaoActivity.this, MenuPacienteActivity.class);
                                intent.putExtra("cpf", cpfP);
                                startActivity(intent);

                            } else {
                                Log.e(this.getClass().toString(), "Error on calling " + response.code() );
                            }
                        } catch (Exception e) {
                            Log.e(this.getClass().toString(), e.getMessage().toString());
                        }

                    }

                    @Override
                    public void onFailure(Call<Autoavaliacao> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Conexão falhou" ,Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }).start();
    }

}
