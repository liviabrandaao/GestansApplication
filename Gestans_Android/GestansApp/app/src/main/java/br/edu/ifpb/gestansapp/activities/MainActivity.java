package br.edu.ifpb.gestansapp.activities;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import br.edu.ifpb.gestansapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import listeners.OnClickMenuMedico;
import listeners.OnClickMenuPaciente;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnmedico)
    ImageButton btnmedico;
    @BindView(R.id.btngravida)
    ImageButton btngravida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnmedico.setOnClickListener(new OnClickMenuMedico(this));
        btngravida.setOnClickListener(new OnClickMenuPaciente(this));
    }
}
