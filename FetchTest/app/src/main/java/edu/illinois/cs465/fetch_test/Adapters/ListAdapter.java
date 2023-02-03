package edu.illinois.cs465.fetch_test.Adapters;
import edu.illinois.cs465.fetch_test.Model.ItemModel;
import edu.illinois.cs465.fetch_test.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter  extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    ArrayList<ItemModel> itemList;

    public ListAdapter(ArrayList<ItemModel> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int myPosition) {
        final int position = myPosition;
        holder.itemId.setText(String.valueOf(itemList.get(position).getId()));
        holder.listId.setText(String.valueOf(itemList.get(position).getListId()));
        holder.name.setText(itemList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemId;
        public TextView listId;
        public TextView name;

        public ViewHolder(View holder) {
            super(holder);
            itemId = (TextView) holder.findViewById(R.id.itemId);
            listId = (TextView) holder.findViewById(R.id.listId);
            name = (TextView) holder.findViewById(R.id.name);
        }
    }

}
