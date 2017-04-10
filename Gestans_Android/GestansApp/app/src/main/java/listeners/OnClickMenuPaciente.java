package listeners;

import android.content.Intent;
import android.view.View;

import br.edu.ifpb.gestansapp.activities.LoginPacienteActivity;
import br.edu.ifpb.gestansapp.activities.MainActivity;

/**
 * Created by rebeca on 08/04/2017.
 */

public class OnClickMenuPaciente implements View.OnClickListener{

    MainActivity mainActivity;

    public OnClickMenuPaciente(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this.mainActivity, LoginPacienteActivity.class);
        this.mainActivity.startActivity(intent);
    }
}