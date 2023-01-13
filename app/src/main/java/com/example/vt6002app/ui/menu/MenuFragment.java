package com.example.vt6002app.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import com.example.vt6002app.R;
import com.example.vt6002app.ui.Map.MapsActivity1;
import com.example.vt6002app.ui.Map.MapsActivity2;
import com.example.vt6002app.ui.Map.MapsActivity3;
import com.example.vt6002app.ui.Map.MapsActivity4;
import com.example.vt6002app.ui.Map.MapsActivity5;

public class MenuFragment extends Fragment {

    ImageView im1, im2, im3, im4, im5;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View view =inflater.inflate(R.layout.fragment_menu,container,false);

        im1=(ImageView) view.findViewById(R.id.imageView);

        im1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity1.class);
                startActivity(intent);
            }
        });

        im2=(ImageView) view.findViewById(R.id.imageView2);

        im2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity2.class);
                startActivity(intent);
            }
        });

        im3=(ImageView) view.findViewById(R.id.imageView3);

        im3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity3.class);
                startActivity(intent);
            }
        });

        im4=(ImageView) view.findViewById(R.id.imageView4);

        im4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity4.class);
                startActivity(intent);
            }
        });

        im5=(ImageView) view.findViewById(R.id.imageView5);

        im5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity5.class);
                startActivity(intent);
            }
        });

        return view;
    }

}