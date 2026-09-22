package com.raynokriel.smartpantrymanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.ViewHolder> {
    //this will build the list of items to push to the recycler view line by line
    //from the list of items.
    private List<PantryItem> items;
    public PantryAdapter(List<PantryItem> items) {
        this.items = items;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView quantity;
        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.textIngredientName);
            quantity = view.findViewById(R.id.textIngredientQuantity);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_pantry, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PantryItem item = items.get(position);
        holder.name.setText(item.getName());
        holder.quantity.setText(item.getQuantity() + " " + item.getUnit());
    }
    //getter and setter for items (the count and the setting the item to the list)
    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setItems(List<PantryItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}