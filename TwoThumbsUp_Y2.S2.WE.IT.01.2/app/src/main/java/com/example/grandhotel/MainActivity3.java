package com.example.grandhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

Button btn_catering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        btn_catering=findViewById(R.id.btn_catering);
        btn_catering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCatering();
            }
        });

    }





    public void openCatering(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}