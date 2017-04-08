package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuPacienteActivity extends AppCompatActivity {

    @BindView(R.id.btnSair) Button btnSair;
    @BindView(R.id.btnVerAutoAv) Button btnVerAutoAv;
    @BindView(R.id.btnAddAutoAv) Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_paciente);
        ButterKnife.bind(this);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPacienteActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnVerAutoAv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listarAutoavs();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(MenuPacienteActivity.this,AddAutoAvaliacaoActivity.class);
                startActivity(intent); */
            }
        });
    }

    public void listarAutoavs(){

    }
}
