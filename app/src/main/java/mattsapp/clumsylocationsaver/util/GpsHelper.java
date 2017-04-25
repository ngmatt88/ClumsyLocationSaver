package mattsapp.clumsylocationsaver.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.support.v4.app.ActivityCompat;

import mattsapp.clumsylocationsaver.instance.App;
import mattsapp.clumsylocationsaver.instance.LocationManagerInstance;

/**
 * Created by Matt on 4/24/2017.
 */

public class GpsHelper {
    private GpsHelper(){}


    /**
     * you need to implement a location listener to use this!
     */
    public static void getCurrentLocationCoordinates(){
        if (ActivityCompat.checkSelfPermission(App.getAppContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(App.getAppContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        LocationManagerInstance.INSTANCE.getInstance().getLastKnownLocation(getBestCoordinateProvider());
    }

    public static String getBestCoordinateProvider(){
        return LocationManagerInstance.INSTANCE.getInstance().getBestProvider(new Criteria(), false);
    }
}
