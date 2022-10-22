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

public class Dinner3 extends AppCompatActivity {
    Button back_btn;
    EditText Noofplates;
    Button oder_btn;
    SharedPreferences sp;
    String NoodlesNo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner3);

        back_btn=(Button) findViewById(R.id.back_btn);
        oder_btn=findViewById(R.id.oder_btn);
        Noofplates=findViewById(R.id.Noofplates);

        sp = getSharedPreferences("dinner3", Context.MODE_PRIVATE);
        oder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoodlesNo=Noofplates.getText().toString();
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("NoodlesNo",NoodlesNo);
                editor.commit();
                Toast.makeText(Dinner3.this,"added number of plates",Toast.LENGTH_SHORT).show();
            }
        });




        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfragment3();
            }
        });

    }


    public void openfragment3(){

        Intent intent=new Intent(this,Fragment3.class);
        startActivity(intent);



    }

}