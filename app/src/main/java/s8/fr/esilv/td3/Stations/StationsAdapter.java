package s8.fr.esilv.td3.Stations;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import s8.fr.esilv.td3.Contracts.Contracts;
import s8.fr.esilv.td3.GoogleMap.GoogleMapActivity;
import s8.fr.esilv.td3.R;

/**
 * Created by juhel on 05/02/2016.
 */
public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.ViewHolder>{

    private Stations stations;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nameTextView;
        public ViewHolder(View v) {
            super(v);
            nameTextView = (TextView) v.findViewById(R.id.stationsName);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public StationsAdapter(Stations stations) {
        this.stations = stations;
    }

    // Create new views (invoked by the layout manager)

    @Override
    public StationsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stations, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nameTextView.setText(stations.get(position).getName());
        //holder.stationNumberTextView.setText(stations.get(position).getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent googleActivity = new Intent(v.getContext(), GoogleMapActivity.class);
                googleActivity.putExtra("stationLat", stations.get(position).getLat());
                googleActivity.putExtra("stationLng", stations.get(position).getLng());
                googleActivity.putExtra("stationName", stations.get(position).getName());
                v.getContext().startActivity(googleActivity);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return stations.size();
    }

    public void setStations(Stations stations) {
        this.stations = stations;
    }

}
