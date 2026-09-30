package com.raynokriel.smartpantrymanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import android.graphics.Color;
import java.util.concurrent.TimeUnit;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.ViewHolder> {
    //this will build the list of items to push to the recycler view line by line
    //from the list of items.
    private List<PantryItem> items;
    private final OnItemClickListener listener;
    //click takes ID and opens a edit screen in the mainjava intent
    public interface OnItemClickListener {
        void onItemClick(PantryItem item);
    }
    //creating the list of items (contructor)
    public PantryAdapter(List<PantryItem> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }
    //item descriptions displayed
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView quantity;
        TextView expiry;
        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.textIngredientName);
            quantity = view.findViewById(R.id.textIngredientQuantity);
            expiry = view.findViewById(R.id.textIngredientExpiry);
        }
    }
    //creating the view and layout of items showing
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_pantry, parent,false);
        return new ViewHolder(view);
    }
    //binding data to the view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PantryItem item = items.get(position);
        holder.name.setText(item.getName());
        holder.quantity.setText(item.getQuantity() + " " + item.getUnit());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(item));
        //making the expiry date red only if it is in range
        if (item.getExpiryDate() != null && !item.getExpiryDate().isEmpty()) {
            holder.expiry.setText("Expires: " + item.getExpiryDate());
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                Date expiryDate = format.parse(item.getExpiryDate());

                if (expiryDate != null) {
                    long diffMillis = expiryDate.getTime() - new Date().getTime();
                    long daysRemaining = TimeUnit.MILLISECONDS.toDays(diffMillis);
                    if (daysRemaining <= 3) {
                        holder.expiry.setTextColor(Color.RED);
                    } else {
                        holder.expiry.setTextColor(Color.BLACK);
                    }
                }
            } catch (Exception ignored) {
            }
        } else {
            holder.expiry.setText("");
        }
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