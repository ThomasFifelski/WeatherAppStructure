package com.weatherornot.weatherornot;

import android.location.Location;
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

public class DisplayWeatherActivity extends Activity {
    public PopulateDataTask getWeatherData;
//    public PopulateAWeatherDataObject myWeatherDataPopulator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("look","howbout now");
        goGetWeatherData();

        Button toData = (Button)findViewById(R.id.to_data);

        toData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.fly_info);
            }
        });


    }



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
//        this method could also take two double parameters for lat and
//        long depending on how you want to move the data around.
//        myWeatherDataPopulator = new PopulateAWeatherDataObject(this);
//        myWeatherDataPopulator.execute(location);
//    }

//step 8
    public void recieveWeatherData(KiteFlyingData myData){

        Log.e (" look", "hey you ");

        TextView x = (TextView) findViewById(R.id.windSpeedView);
        x.setText(myData.getmWindSpeedString());
//
       TextView y =(TextView)findViewById(R.id.textView50);
       y.setText(myData.getmWindBearingString());

        TextView z =(TextView)findViewById(R.id.textView49);
        z.setText(myData.getmPressureString());

        TextView a =(TextView)findViewById(R.id.textView6);
        a.setText(myData.getmVisibiltyString());


       // TextView textView= findViewById(textView); could set a text view not ideal here
//           TextView x = (TextView) findViewById(R.id.windSpeedView)
//        String finalresult = String. valueOf(result) ;
//        textview.setText(finalresult);
//                   myData.getmWindSpeed();getmWindSpeed
       //  String finalresult = String.valueof(result);
       // textview.setText(finalresult);
//        Double result = number1/number2;//number1 and number2 are double
//        textView1.setText(""+result);
//       update the display to show the new info

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
