package com.weatherornot.weatherornot;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tom on 9/9/13.
 */
public class SecondActivity extends Activity {
    public MediaPlayer mp ;
// change
    public PopulateDataTask getWeatherData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fly_info);

        Log.e("look", "howbout now");
        mp = MediaPlayer.create(this, R.raw.wind);


        double a;
        double b;
        String q;

        a =  getIntent().getDoubleExtra("lat",0);
        b = getIntent().getDoubleExtra("long",0);
        q = getIntent().getStringExtra("eD");






        TextView p =(TextView)findViewById(R.id.location_spot);
        p.setText(q);

        // b= intent.getStringExtra("long",0);

//        goGetWeatherData();

        Location l = new Location("");
        l.setLatitude(a);
        l.setLongitude(b);

        goGetWeatherData2(l);
        Button toHome = (Button)findViewById(R.id.toHome);

        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HomeActitivty.class);
                startActivity(i);
                finish();
            }

        });

//
//        Button toData = (Button)findViewById(R.id.to_data);
//
//        toData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i =new Intent(getApplicationContext(),FlyInfo.class);
//                  startActivity(i);
//                    finish( );
//
//            }
//
//
//
//        });
//        buttonToSecondActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i =new Intent(getApplicationContext(),FlyInfo.class);
//                startActivity(i);
//                finish();
//
//
//
//            }
//        });

    }
    public class DisplayMessageActivity extends Activity {



        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.fly_info);
            TextView tv = (TextView) findViewById(R.id.location_info);


            // Get the message from the intent
//            Intent intent;
//            intent = getIntent();
//            String message = intent.getStringExtra("fish",message);
//
//            //Display the message in textview
//            tv.setText(message);

        }
    }


//        toData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(a)
//                //setContentView(R.layout.fly_info);
//            }
//        });

//    private void updateDisplay(){
//
//     check to see if we have some weather data, and
//     update the screen to reflect that new data
//    }
//
//
//     The following two methods are used to start other asynchronous
//     processes outside of this activity.

    //step 1
    public void goGetWeatherData(){
        Log.e("look","2");
        getWeatherData = new PopulateDataTask(this);
    }

    public void goGetWeatherData2(Location loc)
    {
        getWeatherData = new PopulateDataTask(this,loc);
    }

    //step 8
    public void recieveWeatherData(KiteFlyingData myData){

        Log.e (" look", "hey you ");

        TextView x = (TextView) findViewById(R.id.windSpeedOutput);
        x.setText(myData.getmWindSpeedString());
//
        TextView y =(TextView)findViewById(R.id.bearingView);
        y.setText(myData.getmWindBearingString());

        TextView z =(TextView)findViewById(R.id.windBearingView);
        z.setText(myData.getmPressureString());

        TextView a =(TextView)findViewById(R.id.visibilityView);
        a.setText(myData.getmVisibilityString());



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

