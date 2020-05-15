package com.first.roomexample;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUserFragment extends Fragment {

    private EditText TxtUserId;
    private Button DeleteButton;


    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        TxtUserId = view.findViewById(R.id.txt_delete_id);
        DeleteButton = view.findViewById(R.id.delete);

        DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(TxtUserId.getText().toString());
                User user = new User();
                user.setId(id);
                MainActivity.myAppDatabase.myDao().deleteUser(user);

                Toast.makeText(getActivity(), "User successfully removed...", Toast.LENGTH_SHORT).show();
                TxtUserId.setText("");

            }
        });

        return view;
    }

}
