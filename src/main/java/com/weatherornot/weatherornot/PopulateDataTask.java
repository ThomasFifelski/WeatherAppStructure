package com.weatherornot.weatherornot;

import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;


/**
 * Created by tom on 9/3/13.
 */
public class PopulateDataTask extends AsyncTask<ForecastAPIRequestObject,Integer,KiteFlyingData> {
    UserLocationManager getLocationData;
    SecondActivity myFriendDisplayWeatherActivity;

   //step 2
    public PopulateDataTask(SecondActivity activity){

        super();
        Log.e("look","3");
        myFriendDisplayWeatherActivity = activity;
        goGetLocation();
    }

    public PopulateDataTask(SecondActivity activity, Location loc){

        super();
        Log.e("look","5");
        myFriendDisplayWeatherActivity = activity;
        //goGetLocation();
        receiveUserLocation(loc);
    }
//step 3
    public void goGetLocation(){
        Log.e("look","5");

         getLocationData = new UserLocationManager(this);
    }

//step 6
    public void receiveUserLocation(Location location){
       ForecastAPIRequestObject forecastAPIRequestObject = new ForecastAPIRequestObject(location);
         //forecastAPIRequestObject.setMyLocation(location); option for setting but we used a constructor
        this.execute(forecastAPIRequestObject);
        // In this method I'm receiving the user location
        // I need to call a method that takes that location and  makes a request
        // to the Forecast API.
    }

    @Override
    protected KiteFlyingData doInBackground(ForecastAPIRequestObject... forecastAPIRequestObjects) {
        //create a KiteFlyingData object
        KiteFlyingData myData = new KiteFlyingData();
        //get the information that we need from API
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet g = new HttpGet(forecastAPIRequestObjects[0].getAssembledURL());
            HttpResponse httpResponse = httpClient.execute(g);
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                httpResponse.getEntity().writeTo(out);
                out.close();
                String responseString = out.toString();

                //Parse the data from the api using JSONObject methods
                JSONObject rootJSON= new JSONObject(responseString);
                JSONObject currentlyJson= rootJSON.getJSONObject("currently");

                Double windSpeed = currentlyJson.getDouble("windSpeed");
                //and put that data in the ReallyCool Data object
                myData.setmWindSpeed(windSpeed);

                Double windBearing = currentlyJson.getDouble("windBearing");
                myData.setmWindBearing(windBearing);

                Double pressure = currentlyJson.getDouble("pressure");
                myData.setmPressure(pressure);

                Double visibility = currentlyJson.getDouble("visibility");
                myData.setmVisibility(visibility);


            } else {
                httpResponse.getEntity().getContent().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return myData;

    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }

    @Override//step 7
    protected void onPostExecute(KiteFlyingData myDataObject) {

        super.onPostExecute(myDataObject);

        myFriendDisplayWeatherActivity.recieveWeatherData(myDataObject);

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
