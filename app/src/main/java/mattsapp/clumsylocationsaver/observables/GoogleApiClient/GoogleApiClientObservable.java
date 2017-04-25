package mattsapp.clumsylocationsaver.observables.GoogleApiClient;

import android.content.Context;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

import rx.Observable;
import rx.Observer;

/**
 * Created by Matt on 4/24/2017.
 */

public class GoogleApiClientObservable extends GoogleApiClientBaseObservable<GoogleApiClient> {

    @SafeVarargs
    public static Observable<GoogleApiClient> create(Context context, Api<? extends Api.ApiOptions.NotRequiredOptions>... apis) {
        return Observable.create(new GoogleApiClientObservable(context, apis));
    }

    @SafeVarargs
    protected GoogleApiClientObservable(Context ctx, Api<? extends Api.ApiOptions.NotRequiredOptions>... apis) {
        super(ctx, apis);
    }

    @Override
    protected void onGoogleApiClientReady(GoogleApiClient apiClient, Observer<? super GoogleApiClient> observer) {
        observer.onNext(apiClient);
        observer.onCompleted();
    }
}