package com.weatherornot.weatherornot;

import android.location.Location;

/**
 * Created by tom on 9/3/13.
 */
public class ForecastAPIRequestObject {

    private String mAPI_Key= "23bab1fe9367cbe7c8c614e92c329458";
    private String mUrl= "https://api.forecast.io/forecast";
    private Double mLongitude;
    private Double mLatitude;
    private Location myLocation;


    public ForecastAPIRequestObject(Location m) {

        setMyLocation(m);
    }

    public void setMyLocation(Location myLocation) {
        this.myLocation = myLocation;
        mLatitude = myLocation.getLatitude();
        mLongitude= myLocation.getLongitude();


    }

    public String getAssembledURL(){
        String myUrl= mUrl+"/"+mAPI_Key+"/"+ mLatitude.toString()+","+ mLongitude.toString();
        return myUrl;
    }

    private void toString(Double mLongitude) {
    }

    public String getmAPI_Key() {
        return mAPI_Key;
    }

    public void setmAPI_Key(String mAPI_Key) {
        this.mAPI_Key = mAPI_Key;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public Double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(Double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public Double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(Double mLatitude) {
        this.mLatitude = mLatitude;
    }



}
