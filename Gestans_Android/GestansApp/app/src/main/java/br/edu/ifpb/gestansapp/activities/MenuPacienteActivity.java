package br.edu.ifpb.gestansapp.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
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
    @BindView(R.id.btnAddAutoAv) FloatingActionButton btnAdd;
    private String cpfPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_paciente);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        cpfPaciente = extras.getString("cpf");

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
                Intent intent = new Intent(MenuPacienteActivity.this, ListarAAparaPacienteActivity.class);
                intent.putExtra("cpf", cpfPaciente);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPacienteActivity.this,AddAutoAvaliacaoActivity.class);
                intent.putExtra("cpf", cpfPaciente);
                startActivity(intent);
            }
        });
    }


}
