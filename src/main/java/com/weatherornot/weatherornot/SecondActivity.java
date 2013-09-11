package com.weatherornot.weatherornot;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
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
        mp.start();

        goGetWeatherData();


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
        a.setText(myData.getmVisibiltyString());



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

