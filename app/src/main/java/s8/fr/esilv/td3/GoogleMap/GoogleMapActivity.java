package s8.fr.esilv.td3.GoogleMap;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import s8.fr.esilv.td3.R;

public class GoogleMapActivity extends FragmentActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap map) {
        Intent i = getIntent();
        map.addMarker(new MarkerOptions()
                .position(new LatLng((i.getDoubleExtra("stationLat", 0)), i.getDoubleExtra("stationLng", 0)))
                .title(i.getStringExtra("stationName")));
    }


}
