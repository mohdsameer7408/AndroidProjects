package com.example.listviewwithcontextualmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter adapter;
    private List<String> Fruits = new ArrayList<>();

    public static List<String> UserSelection = new ArrayList<>();
    public static ActionMode actionMode = null;
    public static boolean isActionMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFruits();

        listView = findViewById(R.id.mListView);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(modeListener);

        adapter = new ListViewAdapter(Fruits, this);
        listView.setAdapter(adapter);

    }

    private void getFruits()
    {

        String[] items = getResources().getStringArray(R.array.fruits);

        for (String item : items)
        {
            Fruits.add(item);
        }

    }

    AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

//            these conditions will be implemented when without checkboxes...
//            if(UserSelection.contains(Fruits.get(position)))
//            {
//                UserSelection.remove(Fruits.get(position));
//            }
//            else
//            {
//                UserSelection.add(Fruits.get(position));
//            }
//
//            mode.setTitle(UserSelection.size() +" items selected...");

        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {

            MenuInflater menuInflater = mode.getMenuInflater();
            menuInflater.inflate(R.menu.context_menu, menu);
            isActionMode = true;
            actionMode = mode;

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.action_delete:
                    adapter.removeItems(UserSelection);
                    mode.finish();
                    return true;

                default:
                    return false;
            }

        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

            isActionMode = false;
            actionMode = null;
            UserSelection.clear();

        }
    };

}
