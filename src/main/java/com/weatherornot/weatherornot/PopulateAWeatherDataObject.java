package com.weatherornot.weatherornot;

import android.location.Location;
import android.os.AsyncTask;

/**
 * Created by spawrks on 8/30/13.
 */


// When executed will return an AwesomeWeatherData object

public class PopulateAWeatherDataObject extends AsyncTask<Location,Void,AwesomeWeatherData>{

    private DisplayWeatherActivity myFriendDisplayWeatherActivity;

    public PopulateAWeatherDataObject(DisplayWeatherActivity a) {
        super();
        myFriendDisplayWeatherActivity = a;
    }


    @Override
    protected AwesomeWeatherData doInBackground(Location... locations) {
        //Go get the data


        //Parse the data and put it into an AwesomeWeatherData Object


        //What is returned here will be passed into the onPostExecute method
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(AwesomeWeatherData awesomeWeatherData) {

        super.onPostExecute(awesomeWeatherData);
        //pass the DisplayWeatherActivity an AwesomeWeatherData object to use.
        myFriendDisplayWeatherActivity.receiveWeatherData();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
