package com.example.usuario.dado;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends Activity {

    private Button boton;
    private ImageView dado;
    private MediaPlayer mp;

    private Random rand = new Random();

    private int[] images = {R.drawable.dice_1, R.drawable.dice_2,
            R.drawable.dice_3, R.drawable.dice_4,
            R.drawable.dice_5, R.drawable.dice_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.button);
        dado = (ImageView) findViewById(R.id.imageView);

        mp = MediaPlayer.create(this, R.raw.new_roll_dice);

        dado.setImageDrawable(getResources().getDrawable(images[0]));

        //Accion boton
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //boton.setBackgroundColor(0);
                int resultado = rand.nextInt(6);
                dado.setImageDrawable(getResources().getDrawable(images[resultado]));
                mp.start();
            }
        });
    }
}
