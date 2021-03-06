package com.weatherornot.weatherornot;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

//The main activity that we will be using to display weather data

public class HomeActitivty extends Activity {
    private final String mAPI_Url ="http://api.geonames.org/postalCodeSearchJSON?placename=cheese&maxRows=10&username=tomfifelski";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                Log.e("here", "are we");
        Button toData = (Button)findViewById(R.id.to_data);

        toData.setOnClickListener(new View.OnClickListener() {


        @Override
            public void onClick(View view) {
//                mp.start();
                  GetLocationTask myLocationGettingTask = new GetLocationTask();
                  myLocationGettingTask.execute("String from edit text");
            }

        });

    }

    private void goToFlyInfo(Location mySpot){
        Intent i =new Intent(getApplicationContext(),SecondActivity.class);

        if (mySpot.getLatitude()== 0  ){

            Toast.makeText(getApplicationContext(), "Try a Zip Code", Toast.LENGTH_LONG).show();
                    return;}

        EditText et = (EditText) findViewById(R.id.ed1);
        String str = et.getText().toString();
        i.putExtra("eD",str);
        i.putExtra("lat",mySpot.getLatitude());
        i.putExtra("long",mySpot.getLongitude());
        startActivity(i);
        finish( );
  }

    public class GetLocationTask extends AsyncTask<String,Integer,Location>

    {

        @Override
        protected Location doInBackground(String... strings) {
            Location mySpot = new Location("");

               //get the information that we need from API
            try {
                HttpClient httpClient = new DefaultHttpClient();
             //  String personalityURL = mAPI_Url.replace("jimmy",personality);
                EditText et = (EditText) findViewById(R.id.ed1);
                String str = et.getText().toString();

                str = str.replace(' ', '_');

                HttpGet g = new HttpGet(mAPI_Url.replace("cheese", str));
                HttpResponse httpResponse = httpClient.execute(g);
                StatusLine statusLine = httpResponse.getStatusLine();
                if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    httpResponse.getEntity().writeTo(out);
                    out.close();
                    String responseString = out.toString();
                    Log.v("TAG", responseString);


                    //Parse the data from the api using JSONObject methods
                    JSONObject rootJSON= new JSONObject(responseString);
                    JSONArray postalCodesJson= rootJSON.getJSONArray("postalCodes");
                    JSONObject spaceJson = (JSONObject) postalCodesJson.get(0);

                    Double lng= spaceJson.getDouble("lng");
                    mySpot.setLongitude(lng);

                    Double lat= spaceJson.getDouble("lat");
                    mySpot.setLatitude(lat);


                } else {
                    httpResponse.getEntity().getContent().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return mySpot;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Location mySpot) {
            super.onPostExecute(mySpot);
            goToFlyInfo(mySpot);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }


}
