package com.example.recyclerviewwithcontextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[] images = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
            R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8,
            R.drawable.pic9, R.drawable.pic10};
    private String[] fruit_names;
    private List<Fruit> fruits = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruit_names = getResources().getStringArray(R.array.fruit_names);
        recyclerView = findViewById(R.id.mRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        getFruits();

        adapter = new RecyclerAdapter(fruits);
        recyclerView.setAdapter(adapter);
    }

    private void getFruits()
    {

        int count = 0;

        for (String fruitName : fruit_names)
        {
            Fruit fruit = new Fruit(images[count], fruitName);
            fruits.add(fruit);
            count++;
        }

    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId())
        {
            case 121:
                adapter.removeItem(item.getGroupId());
                displayMessage("Item Deleted....");
                return true;

            case 122:
                displayMessage("Item Added to Wish List...");
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }

    private void displayMessage(String message)
    {

        Snackbar.make(findViewById(R.id.rootView), message, Snackbar.LENGTH_SHORT).show();

    }

}
