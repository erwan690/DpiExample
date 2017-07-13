package studio.akse.dpiexample;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class AddLandActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private double latitude, longitude;
    private EditText lat, longt, ltnh;
    private Marker marker;
    private Spinner ukrnTAnah;
    private RadioGroup radioGroup;
    private TextView expr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_land);
        setTitle(" Create Land Listing");
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapadd);
        mapFragment.getMapAsync(this);
        lat = (EditText) findViewById(R.id.latadd);
        longt = (EditText) findViewById(R.id.longadd);
        ltnh = (EditText) findViewById(R.id.luas_tanah);
        ukrnTAnah = (Spinner) findViewById(R.id.luas_spinner);
        radioGroup = (RadioGroup) findViewById(R.id.radiojenis);
        expr = (TextView) findViewById(R.id.expiredna);


        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ukuran_luas, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        ukrnTAnah.setAdapter(adapter);
        ukrnTAnah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (!adapterView.getSelectedItem().toString().equals("Pilih Ukuran Tanah")) {
                    ltnh.setVisibility(View.VISIBLE);
                } else {
                    ltnh.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    // no radio buttons are checked
                } else {
                    expr.setVisibility(View.VISIBLE);
                    // one of the radio buttons is checked
                }

            }
        });






    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                latitude = latLng.latitude;
                longitude = latLng.longitude;
                lat.setText(String.valueOf(latitude));
                longt.setText(String.valueOf(longitude));

                if (marker != null) {
                    marker.remove();
                }
                marker = mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).draggable(true).visible(true));
            }
        });

    }

}
