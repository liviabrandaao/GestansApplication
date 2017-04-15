package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import entities.Autoavaliacao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ServerConnection;

public class MenuMedicoActivity extends AppCompatActivity {

    @BindView(R.id.btnPesquisarPacientes) Button btnpesquisarPacientes;
    @BindView(R.id.btnVerAtualizaçõesRecentes) Button btnverAtualizações;
    @BindView(R.id.btnSair) Button btnsair;
    @BindView(R.id.imageAccountoptPac) ImageButton btnConta;
    private String chaveMedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_medico);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        chaveMedico = extras.getString("chave");

        btnpesquisarPacientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pesquisa pacientes
            }
        });

        btnverAtualizações.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuMedicoActivity.this, ListarAAparaMedicoActivity.class);
                intent.putExtra("chave", chaveMedico);
                startActivity(intent);
            }
        });

        btnsair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuMedicoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuMedicoActivity.this, OpcoesContaMedicoActivity.class);
                intent.putExtra("chave", chaveMedico);
                startActivity(intent);
            }
        });
    }






}
