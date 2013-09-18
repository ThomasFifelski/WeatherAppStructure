package com.weatherornot.weatherornot;

/**
 * Created by tom on 9/3/13.
 */
public class KiteFlyingData {

    private Double mWindSpeed;
    private Double mWindBearing;
    private Double mPressure;
    private Double mVisibility;

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

    public Double getmVisibility() {
        return mVisibility;
    }
    public String getmVisibilityString(){
        return mVisibility.toString();

    }

    public void setmVisibility(Double mVisibility) {
        this.mVisibility = mVisibility;
    }


}
