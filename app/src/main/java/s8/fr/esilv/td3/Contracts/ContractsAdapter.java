package s8.fr.esilv.td3.Contracts;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import s8.fr.esilv.td3.MainActivity;
import s8.fr.esilv.td3.R;
import s8.fr.esilv.td3.Stations.StationsActivity;

/**
 * Created by juhel on 05/02/2016.
 */
public class ContractsAdapter extends RecyclerView.Adapter<ContractsAdapter.ViewHolder>  {

    private Contracts contracts;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nameTextView;
        public TextView commercialNameTextView;
        public ViewHolder(View v) {
            super(v);
            nameTextView = (TextView) v.findViewById(R.id.contractsName);
            commercialNameTextView = (TextView) v.findViewById(R.id.contractsCommercialName);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent secondActivity = new Intent(v.getContext(), StationsActivity.class);
                    String contractName ="contractName";
                    String setcontractName ="contractName";
                    secondActivity.putExtra(contractName, nameTextView.getText());
                    v.getContext().startActivity(secondActivity);
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ContractsAdapter(Contracts contracts) {
        this.contracts = contracts;
    }

    // Create new views (invoked by the layout manager)

    @Override
    public ContractsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contracts, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nameTextView.setText(contracts.get(position).getName());
        holder.commercialNameTextView.setText(contracts.get(position).getCommercial_name());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return contracts.size();
    }

    public void setContracts(Contracts contracts) {
        this.contracts = contracts;
    }
}
