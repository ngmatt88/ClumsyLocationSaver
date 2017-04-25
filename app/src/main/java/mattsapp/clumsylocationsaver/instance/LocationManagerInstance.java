package mattsapp.clumsylocationsaver.instance;

import android.content.Context;
import android.location.LocationManager;

/**
 * Created by Matt on 4/24/2017.
 */

public enum LocationManagerInstance {
    INSTANCE;

    private LocationManager locationManager;

    public LocationManager getInstance(){
        if(locationManager == null)
            locationManager = (LocationManager) App.getAppContext().getSystemService(Context.LOCATION_SERVICE);
        return locationManager;
    }
}
