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
public class AddUserFragment extends Fragment {

    private EditText UserId, UserName, UserEmail;
    private Button BnSave;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        UserId = view.findViewById(R.id.txt_user_id);
        UserName = view.findViewById(R.id.txt_name);
        UserEmail = view.findViewById(R.id.txt_email);
        BnSave = view.findViewById(R.id.bn_save_user);
        BnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userid = Integer.parseInt(UserId.getText().toString());
                String username = UserName.getText().toString();
                String useremail = UserEmail.getText().toString();

                User user = new User();
                user.setId(userid);
                user.setName(username);
                user.setEmail(useremail);

                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "User added successfully", Toast.LENGTH_SHORT).show();

                UserId.setText("");
                UserName.setText("");
                UserEmail.setText("");

            }
        });

        return view;
    }

}
