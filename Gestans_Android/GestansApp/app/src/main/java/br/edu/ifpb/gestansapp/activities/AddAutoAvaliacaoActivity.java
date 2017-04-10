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

    private String[] arraySpinner;
    @BindView(R.id.spinnerDor) Spinner niveisDeDor;
    @BindView(R.id.edtLocalDor) EditText edtLocalDor;
    @BindView(R.id.rgFebre) RadioGroup rgFebre;
    @BindView(R.id.rgSangramento) RadioGroup rgSangramento;
    @BindView(R.id.edtOutros) EditText edtOutros;
    @BindView(R.id.btnSalvarAutoAv) Button btnSalvar;
    private boolean febre;
    private boolean sangramento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_auto_avaliacao);
        ButterKnife.bind(this);

        //Seta os valores dos niveis de dor no spinner da tela
        this.arraySpinner = new String[] {
                "1", "2", "3", "4", "5", "6", "7","8","9","10"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        niveisDeDor.setAdapter(adapter);

        switch(rgFebre.getCheckedRadioButtonId()){
            case R.id.rbFebreSim:
                febre = true;
                break;
            case R.id.rbFebreNao:
                febre = false;
                break;
        }

        switch(rgSangramento.getCheckedRadioButtonId()){
            case R.id.rbSangramentoSim:
                febre = true;
                break;
            case R.id.rbSangramentoNao:
                febre = false;
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
