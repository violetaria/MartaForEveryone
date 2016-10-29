package com.itsmarta.apps.martaforeveryone.activities;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.itsmarta.apps.martaforeveryone.R;
import com.itsmarta.apps.martaforeveryone.adapters.ScheduleAdapter;
import com.itsmarta.apps.martaforeveryone.clients.MartaAPIClient;
import com.itsmarta.apps.martaforeveryone.helpers.MyLocationHelper;
import com.itsmarta.apps.martaforeveryone.models.Train;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ScheduleActivity extends AppCompatActivity implements MyLocationHelper.LocationCallback{
    private ArrayList<Train> trains;
    private SwipeRefreshLayout swipeContainer;
    private ScheduleAdapter adapter;
    private MyLocationHelper mLocationProvider;
    private Location currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        mLocationProvider = new MyLocationHelper(this, this);
        mLocationProvider.connect();

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchScheduleData();
            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        trains = new ArrayList<Train>();
        adapter = new ScheduleAdapter(this, trains);
        ListView listView = (ListView) findViewById(R.id.lvSchedule);
        listView.setAdapter(adapter);
        //fetchScheduleData();
    }

    private void fetchScheduleData() {
        MartaAPIClient.getRealTimeTrainData(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.d("DEBUG", response.toString());
                trains.clear();
                ArrayList<Train> newTrains = Train.fromJSONArray(response);
                int count = 0;
                for(int i = 0; i < newTrains.size(); i++){
                    Train train = newTrains.get(i);
                    if(calculateDistanceMeters(currentLocation,train.getLocation()) <= 3000){
                        trains.add(count,train);
                        count++;
                    }
                }
                // trains.addAll(Train.fromJSONArray(response));
                adapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString,
                    Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable,
                    JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLocationProvider.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLocationProvider.disconnect();
    }

    public void handleNewLocation(Location location) {
        Log.d("LOCATION", location.toString());

        double currentLatitude = location.getLatitude();
        double currentLongitude = location.getLongitude();
        LatLng latLng = new LatLng(currentLatitude, currentLongitude);
        currentLocation = location;
        Toast.makeText(this,"new location found!",Toast.LENGTH_LONG).show();
        fetchScheduleData();
    }

    public float calculateDistanceMeters(Location currentLocation, Location transitLocation){
       return currentLocation.distanceTo(transitLocation);
    }
}
