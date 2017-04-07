package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuMedicoActivity extends AppCompatActivity {

    @BindView(R.id.btnPesquisarPacientes) Button btnpesquisarPacientes;
    @BindView(R.id.btnVerAtualizaçõesRecentes) Button btnverAtualizações;
    @BindView(R.id.btnSair) Button btnsair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_medico);
        ButterKnife.bind(this);

        btnpesquisarPacientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pesquisa pacientes
            }
        });

        btnverAtualizações.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ver atualizações
            }
        });

        btnsair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuMedicoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
