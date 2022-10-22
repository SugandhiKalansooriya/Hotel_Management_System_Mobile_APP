package com.example.grandhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Lunch2 extends AppCompatActivity {
   EditText Noofplates;
    Button back_btn;
    Button oder_btn;
    SharedPreferences sp;
    String friedriceNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch2);
        oder_btn=(Button)findViewById(R.id.oder_btn);
        back_btn=(Button) findViewById(R.id.back_btn);
        Noofplates=(EditText)findViewById(R.id.Noofplates);

        sp = getSharedPreferences("lunch2", Context.MODE_PRIVATE);
        oder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friedriceNo=Noofplates.getText().toString();
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("friedriceNo",friedriceNo);
                editor.commit();
                Toast.makeText(Lunch2.this,"added number of plates",Toast.LENGTH_SHORT).show();
            }
        });



        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfragment1();
            }
        });




    }


    public void openfragment1(){


        Intent intent=new Intent(this,Fragment1.class);
        startActivity(intent);








    }







}