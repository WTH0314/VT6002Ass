package com.example.vt6002app.ui.account;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import com.example.vt6002app.R;
import com.example.vt6002app.ui.LoginActivity;
import com.example.vt6002app.ui.SignupActivity;
import com.google.firebase.auth.FirebaseAuth;

public class AccountFragment extends Fragment {

    Button btn1, btn2, btn3;
    TextView tv1;

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view =inflater.inflate(R.layout.fragment_account,container,false);

        btn1=(Button) view.findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SignupActivity.class);
                startActivity(intent);
            }
        });

        btn2=(Button) view.findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        btn3=(Button) view.findViewById(R.id.button3);

        tv1=(TextView) view.findViewById(R.id.textView6);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                tv1.setText("Logged out, good bye.");
            }

        });

        return view;

    }

}