package com.weatherornot.weatherornot;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by spawrks on 8/30/13.
 */

//  This class wraps all the code we will use to manage getting updates on the location

public class UserLocationManager implements LocationListener{

    private DisplayWeatherActivity myFriendDisplayWeatherActivity;

    public UserLocationManager (DisplayWeatherActivity a){
        //Setup getting the user location information however that might be needed.
        myFriendDisplayWeatherActivity = a;
        //DisplayWeatherActivity aFriendDisplayWeatherActivity = a; //throwing that num away

    }

    @Override
    public void onLocationChanged(Location location) {
        //ill be told the location here.
        myFriendDisplayWeatherActivity.receiveUserLocation();
    }

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
