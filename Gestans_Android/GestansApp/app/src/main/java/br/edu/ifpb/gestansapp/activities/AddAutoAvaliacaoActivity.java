package br.edu.ifpb.gestansapp.activities;

import android.graphics.RadialGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;


public class AddAutoAvaliacaoActivity extends AppCompatActivity {

    private String[] arraySpinnerDor;
    private String[] arraySpinnerFebre;
    private boolean sangramento;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_auto_avaliacao);
        ButterKnife.bind(this);

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


        switch(rgSangramento.getCheckedRadioButtonId()){
            case R.id.rbSangramentoSim:
                sangramento = true;
                break;
            case R.id.rbSangramentoNao:
                sangramento = false;
                break;
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
    }

    public void salvar(){

    }
}
