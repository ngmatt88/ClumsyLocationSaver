package mattsapp.clumsylocationsaver;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.vision.text.Line;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import mattsapp.clumsylocationsaver.instance.GoogleApiClientInstance;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements LocationListener {
    @BindView(R.id.ll_latitude_container)
    LinearLayout llLatitudeContainer;

    @BindView(R.id.ll_longitude_container)
    LinearLayout llLongitudeContainer;

    @BindView(R.id.tv_latitude_display)
    TextView tvLatitudeDisplay;

    @BindView(R.id.tv_longitude_display)
    TextView tvLongitudeDisplay;

    @BindView(R.id.b_save_location)
    Button bSaveLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.b_save_location)
    public void saveCurrentLocation(Button saveButton){
        Observable.just()
        GoogleApiClientInstance.INSTANCE.getApiClient().connect();
    }

    @Override
    public void onLocationChanged(Location location) {

    }
}
