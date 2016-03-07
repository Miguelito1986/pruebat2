package es.miguelgarciagarcia.es.yep;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        sound = MediaPlayer.create(this, R.raw.init);
        sound.setLooping(true);
        sound.start();
        openApp(true);
        openApp(true);

        //añadimos el splash_screen

        TextView myTitle = (TextView)findViewById(R.id.title);
        TextView myTitle1 = (TextView)findViewById(R.id.subtitle);
        Typeface myFont = Typeface.createFromAsset(getAssets(),"font/AmaticSC-Regular.ttf");
        Typeface myFont1= Typeface.createFromAsset(getAssets(),"font/AmaticSC-Regular.ttf");
        myTitle.setTypeface(myFont);
        myTitle1.setTypeface(myFont1);

        //añadir movimiento al titulo
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.grow_disappear_animation);
        myTitle.startAnimation(shake);



    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 10000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sound.isPlaying()) {
            sound.stop();
            sound.release();
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        sound.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        sound.pause();

    }

}
