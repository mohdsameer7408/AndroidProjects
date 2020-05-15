package com.example.listviewwithcontextualmenu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class ListViewAdapter extends ArrayAdapter<String> {

    private List<String> Fruits = new ArrayList<>();
    private Context context;

    public ListViewAdapter(List<String> Fruits, Context context)
    {
        super(context, R.layout.item_layout, Fruits);
        this.context = context;
        this.Fruits = Fruits;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.item_layout, parent, false);
        TextView FruitName = row.findViewById(R.id.fruit_name);
        FruitName.setText(Fruits.get(position));

        CheckBox checkBox = row.findViewById(R.id.checkBox);
        checkBox.setTag(position);

        if(MainActivity.isActionMode)
        {
            checkBox.setVisibility(View.VISIBLE);
        }
        else
        {
            checkBox.setVisibility(View.GONE);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int position = (int)buttonView.getTag();

                if(MainActivity.UserSelection.contains(Fruits.get(position)))
                {

                    MainActivity.UserSelection.remove(Fruits.get(position));

                }
                else
                {

                    MainActivity.UserSelection.add(Fruits.get(position));

                }

                MainActivity.actionMode.setTitle(MainActivity.UserSelection.size()+" items selected...");

            }
        });

        return row;
    }

    public void removeItems(List<String> items)
    {

        for(String item : items)
        {
            Fruits.remove(item);
        }
        notifyDataSetChanged();

    }

}
