package es.miguelgarciagarcia.es.yep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Vaio on 07/03/2016.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.a:
                Log.i("ActionBar", "Nuevo Miembros!");
                return true;
            case R.id.b:
                Log.i("ActionBar", "Guardar!");;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

}
