package com.raynokriel.smartpantrymanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
//same adaptor that was made for patry items, but now for making the recipy object
public class RecipeAdapter
        extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    public interface OnRecipeClickListener {
        void onRecipeClick(Recipe recipe);
    }
    //list variable
    private List<Recipe> recipes;

    private final OnRecipeClickListener listener;
    //creating the list of items that will display in the recycler view
    public RecipeAdapter(List<Recipe> recipes,OnRecipeClickListener listener) {
        this.recipes = recipes;
        this.listener = listener;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView subtitle;

        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.textRecipeName);
            subtitle = view.findViewById(R.id.textRecipeSubtitle);
        }
    }
    //a quick count on the items needed to display as ingredients
    @Override
    public int getItemCount() {
        return recipes.size();
    }
    //creates the view layout that displays from the view holder above
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_recipe,parent,false);
        return new ViewHolder(view);
    }
    //binds the data to the recylcer view and adds the name, ingredients and click
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        Recipe recipe = recipes.get(position);
        holder.name.setText(recipe.getName());
        holder.subtitle.setText(recipe.getIngredients().size() + " ingredients");
        holder.itemView.setOnClickListener(v -> listener.onRecipeClick(recipe));
    }
}