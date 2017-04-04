package listeners;

import android.content.Intent;
import android.view.View;

import br.edu.ifpb.gestansapp.activities.MainActivity;
import br.edu.ifpb.gestansapp.activities.MenuMedicoActivity;

/**
 * Created by rebeca on 03/04/2017.
 */

public class OnClickMenuMedico implements View.OnClickListener{

    MainActivity mainActivity;

    public OnClickMenuMedico(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this.mainActivity, MenuMedicoActivity.class);
        this.mainActivity.startActivity(intent);
    }
}
