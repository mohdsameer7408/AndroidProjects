package com.example.recyclerviewwithcontextmenu;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Fruit> fruits = new ArrayList<>();

    public RecyclerAdapter(List<Fruit> fruits)
    {
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.FruitName.setText(fruits.get(position).getFruit_name());
        holder.FruitImage.setImageResource(fruits.get(position).getFruit_image_id());

    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener
    {
        ImageView FruitImage;
        TextView FruitName;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            FruitImage = itemView.findViewById(R.id.album);
            FruitName = itemView.findViewById(R.id.album_title);
            cardView = itemView.findViewById(R.id.mCardView);
            cardView.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            menu.setHeaderTitle("Select an Option");
            menu.add(this.getAdapterPosition(), 121, 0, "Delete this item");
            menu.add(this.getAdapterPosition(), 122, 1, "Add to Wish List");

        }
    }

    public void removeItem(int position)
    {

        fruits.remove(position);
        notifyDataSetChanged();

    }


}
