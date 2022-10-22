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

public class Lunch4 extends AppCompatActivity {
    SharedPreferences sp;
    Button back_btn;
    EditText Noofplates;
    Button oder_btn;
    String NasigoranNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch4);
        back_btn=(Button) findViewById(R.id.back_btn);
        oder_btn=findViewById(R.id.oder_btn);
        Noofplates=findViewById(R.id.Noofplates);


        sp = getSharedPreferences("lunch4", Context.MODE_PRIVATE);
        oder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NasigoranNo=Noofplates.getText().toString();
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("NasigoranNo",NasigoranNo);
                editor.commit();
                Toast.makeText(Lunch4.this,"added to the cart",Toast.LENGTH_SHORT).show();
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