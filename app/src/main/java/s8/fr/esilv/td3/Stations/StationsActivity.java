package s8.fr.esilv.td3.Stations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import s8.fr.esilv.td3.R;

/**
 * Created by juhel on 05/02/2016.
 */
public class StationsActivity  extends AppCompatActivity{


    private Stations stationsArrayList;
    private StationsAdapter adapter;
    private RecyclerView sRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stations_main);
        stationsArrayList = new Stations();
        sRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewStations);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        sRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        sRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        adapter = new StationsAdapter(stationsArrayList);
        sRecyclerView.setAdapter(adapter);

        Intent i = getIntent();
        performRequest(i.getStringExtra("contractName"));
        populateListView();
    }

    public void populateListView(){
        // Attach the adapter to a RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewStations);
        recyclerView.setAdapter(adapter);
    }
    public void performRequest(String contract){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.jcdecaux.com/vls/v1/stations?contracts="+contract+"&apiKey=754b929e8d3f42fe87697c31937a5877a976f649";

        // Request a string response from the provided URL.
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Create the contracts
                        createContacts(response);
                        Log.d("", "onResponse");
                    }
                }, null);
           // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void createContacts(String response){
        stationsArrayList = new Gson().fromJson(response, Stations.class);
        adapter.setStations(stationsArrayList);
        adapter.notifyDataSetChanged();
    }
}


