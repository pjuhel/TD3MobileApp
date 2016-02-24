package s8.fr.esilv.td3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import s8.fr.esilv.td3.Contracts.Contracts;
import s8.fr.esilv.td3.Contracts.ContractsAdapter;
import s8.fr.esilv.td3.Stations.StationsActivity;

public class MainActivity extends AppCompatActivity {

    private Contracts contractsArrayList;
    private ContractsAdapter adapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contractsArrayList = new Contracts();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        adapter = new ContractsAdapter(contractsArrayList);
        mRecyclerView.setAdapter(adapter);

        performRequest();
        populateListView();
    }

    public void populateListView(){

        // Attach the adapter to a RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
    }
    public void performRequest(){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.jcdecaux.com/vls/v1/contracts?apiKey=754b929e8d3f42fe87697c31937a5877a976f649";

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
        contractsArrayList = new Gson().fromJson(response, Contracts.class);
        adapter.setContracts(contractsArrayList);
        adapter.notifyDataSetChanged();


    }
}
