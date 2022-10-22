package com.example.grandhotel;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Fragment2 extends Fragment {
    @Nullable


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_2, container, false);



        Button bkfast_btn1 = (Button) view.findViewById(R.id.Dinner_btn1);
        Button  bkfast_btn2= (Button) view.findViewById(R.id.brk_btn2);
        FloatingActionButton fabNext=(FloatingActionButton) view.findViewById(R.id.fabNext);


        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), MainActivity4.class);
                startActivity(in);
            }
        });


        bkfast_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Bkfast1.class);
                startActivity(in);
            }
        });



        bkfast_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Bkfast2.class);
                startActivity(in);
            }
        });




        return view;
    }
}