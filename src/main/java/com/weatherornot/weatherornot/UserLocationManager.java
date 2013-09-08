package com.weatherornot.weatherornot;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by spawrks on 8/30/13.
 */
//  This class wraps all the code we will use to manage getting updates on the location

public class UserLocationManager implements LocationListener{

    private PopulateDataTask mPopulateDataTask;
    public LocationManager locationManager;

//step 4
    public UserLocationManager(PopulateDataTask fuzzy){
        super();
        Log.e("look","4");
       // going register for GPS events right here
        mPopulateDataTask = fuzzy;
        locationManager= (LocationManager) mPopulateDataTask.myFriendDisplayWeatherActivity.getSystemService(Context.LOCATION_SERVICE);

        try {

           locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);


        }catch (Exception e){ e.printStackTrace();

        }

    }

//step 5
    @Override
    public void onLocationChanged(Location location) {

        //ill be told the location here.
 //       Log.e("UserLocationManager=", location.getLatitude() + "," + location.getLongitude());
        locationManager.removeUpdates(this);
        locationManager = null;
        mPopulateDataTask.receiveUserLocation(location);


////       fix error by stopping looking for location change again  locationListenerObject
      //onLocationChanged(location).removeGpsStatusListener(this);

    }
// We need to go from steps 7-8
    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
