package com.example.dialogexample;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MyDialog extends DialogFragment {

    private List<String> mSelectedItems;
    private String selection;


    public interface ToppingsSelectionListener
    {
        public void onToppingsSelected(List<String> toppings);
    }

    ToppingsSelectionListener selectionListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


//        the commented code was to display a list of items
        final String[] colors = getActivity().getResources().getStringArray(R.array.colors);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("Pick a color");
//        builder.setItems(colors, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getActivity(), "Selected color : "+colors[which], Toast.LENGTH_SHORT).show();
//            }
//        });


//        ---------------------------------------------------------------------------------------------------------------
//        to display check-boxes on a dialog box..
        builder.setTitle("Pick your toppings");
        mSelectedItems = new ArrayList<>();
        builder.setMultiChoiceItems(R.array.toppings, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                String[] items = getActivity().getResources().getStringArray(R.array.toppings);
                if (isChecked)
                {
                    mSelectedItems.add(items[which]);
                }
                else if (mSelectedItems.contains(items[which]))
                {
                    mSelectedItems.remove(items[which]);
                }

            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                selectionListener.onToppingsSelected(mSelectedItems);
//                this was only for a toast message...
//                String final_selection = "";
//                for (String Item : mSelectedItems)
//                {
//                    final_selection += "\n"+Item;
//                }
//                Toast.makeText(getActivity(), "Selection : "+final_selection, Toast.LENGTH_SHORT).show();

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

//        -------------------------------------------------------------------------------------------------------------
//        to display radio buttons on a dialog box
//        builder.setTitle("Pick a color");
//        builder.setSingleChoiceItems(R.array.colors, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                selection = colors[which];
//            }
//        });
//
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                Toast.makeText(getActivity(), "Selected color is : "+selection, Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {

        Activity activity = (Activity) context;

        try{
            selectionListener = (ToppingsSelectionListener) activity;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(activity.toString() +" Must implement ToppingsSelectionListener methods ");
        }


        super.onAttach(context);
    }
}
