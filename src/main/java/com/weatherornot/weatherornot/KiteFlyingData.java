package com.weatherornot.weatherornot;

/**
 * Created by tom on 9/3/13.
 */
public class KiteFlyingData {

    private Double mWindSpeed;
    private Double mWindBearing;
    private Double mPressure;
    private Double mVisibilty;

    public Double getmWindSpeed() {
        return mWindSpeed;
    }

    public String getmWindSpeedString(){
        return mWindSpeed.toString();
    }

    public void setmWindSpeed(Double mWindSpeed) {

        this.mWindSpeed = mWindSpeed;
    }

    public Double getmWindBearing() {
        return mWindBearing;
    }

    public String getmWindBearingString(){
        return mWindBearing.toString();
    }

    public void setmWindBearing(Double mWindBearing) {
        this.mWindBearing = mWindBearing;
    }

    public Double getmPressure() {
        return mPressure;
    }
    public String getmPressureString(){
        return mPressure.toString();
    }

    public void setmPressure(Double mPressure) {
        this.mPressure = mPressure;
    }

    public Double getmVisibilty() {
        return mVisibilty;
    }
    public String getmVisibiltyString(){
        return mWindSpeed.toString();
    }

    public void setmVisibilty(Double mVisibilty) {
        this.mVisibilty = mVisibilty;
    }


}
