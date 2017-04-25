package mattsapp.clumsylocationsaver.instance;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import mattsapp.clumsylocationsaver.observables.GoogleApiClient.GoogleApiClientObservable;
import rx.Observable;

/**
 * Created by Matt on 4/24/2017.
 */

public enum GoogleApiClientInstance implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    INSTANCE;

    Observable<GoogleApiClient> apiClient;

    public Observable<GoogleApiClient> getApiClient(){
        if(apiClient==null)
            apiClient = GoogleApiClientObservable.create(App.getAppContext());
        return apiClient;
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
            if (ActivityCompat.checkSelfPermission(App.getAppContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(App.getAppContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
        Log.i(GoogleApiClientInstance.class.getSimpleName(), "Connection Success");

//            startLocationUpdates();
//            mLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(GoogleApiClientInstance.class.getSimpleName(), "Connection Suspended");
//        apiClient.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.i(GoogleApiClientInstance.class.getSimpleName(), "Connection Failed");
    }
}
