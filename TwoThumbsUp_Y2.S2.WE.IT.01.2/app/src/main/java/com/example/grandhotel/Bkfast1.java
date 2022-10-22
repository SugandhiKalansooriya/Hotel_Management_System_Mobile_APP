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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Bkfast1 extends AppCompatActivity {


    EditText Noofplates;
    Button back_btn;
    Button oder_btn;
    SharedPreferences sp;
    String RedriceNo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkfast1);
        oder_btn=findViewById(R.id.oder_btn);
        Noofplates=findViewById(R.id.Noofplates);

        back_btn=(Button) findViewById(R.id.back_btn);




        sp = getSharedPreferences("bkfast1", Context.MODE_PRIVATE);

        oder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RedriceNo=Noofplates.getText().toString();
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("RedriceNo",RedriceNo);
                editor.commit();
                Toast.makeText(Bkfast1.this,"added number of plates",Toast.LENGTH_SHORT).show();
            }
        });



        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfragment2();
            }
        });


    }

    public void openfragment2(){

        Intent intent=new Intent(this,Fragment2.class);
        startActivity(intent);



    }
}