package com.weatherornot.weatherornot;

import android.content.Intent;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

//The main activity that we will be using to display weather data

public class HomeActitivty extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.e("here","are we");
        Button toData = (Button)findViewById(R.id.to_data);
////        final Button sound= (Button)this.findViewById(R.id.to_data);
//        final MediaPlayer mp = MediaPlayer.create(this, R.raw.wind);
        toData.setOnClickListener(new View.OnClickListener() {


        @Override
            public void onClick(View view) {
//                mp.start();
                Intent i =new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(i);
                finish( );

            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}