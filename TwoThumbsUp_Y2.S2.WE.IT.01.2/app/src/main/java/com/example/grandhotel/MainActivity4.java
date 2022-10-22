package com.example.grandhotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity4 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText noNasigorang;
    EditText Nobiriyani;
    EditText noFriedrice;
    EditText NoStringhop;
    Button back_btn;
    EditText noRedRice;
    EditText noKotthu;
    EditText NoNoodless;
    Button confirm_btn;
    Button clear_btn;
    Button view_btn;
    Button Update_btn;
    Button Delete_btn;
    FloatingActionButton date_button;


    EditText et_date;
    EditText et_email;
    TextView tv_bill;

    Oder obOder;

    DatabaseReference db;
    String Biriyani;
    String Nasigorang;
    String redrice;
    String Stringhop;
    String Kotthu;
    String Noodless;
    String Friedrice;



    int Numfriedrice=0;
    int Numnasigoreng=0;
    int Numbiriyani=0;
    int Numstringhop=0;
    int Numredrice=0;
    int Numkottu=0;
    int Numnoodles=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tv_bill=findViewById(R.id.tv_bill);
        et_date=findViewById(R.id.et_date);
        et_email=findViewById(R.id.et_email);
        confirm_btn=findViewById(R.id.confirm_btn);

        obOder=new Oder();



        // fetch number of plates in the cart
        Nobiriyani=findViewById(R.id.Nobiriyani);
        SharedPreferences sp =getApplicationContext().getSharedPreferences("lunch3", Context.MODE_PRIVATE);
        Biriyani =sp.getString("biriyaniNo","");
        Nobiriyani.setText(Biriyani);
        if(Biriyani!=null && Biriyani.length()>0) {
            Numbiriyani = Integer.parseInt(Biriyani);
        }

        noNasigorang=findViewById(R.id.noNasigorang);
        SharedPreferences sp1 =getApplicationContext().getSharedPreferences("lunch4", Context.MODE_PRIVATE);
        Nasigorang = sp1.getString("NasigoranNo","");
        noNasigorang.setText(Nasigorang);
        if(Nasigorang!=null && Nasigorang.length()>0) {
            Numnasigoreng = Integer.parseInt(Nasigorang);
        }

        noRedRice=findViewById(R.id.noRedRice);
        SharedPreferences sp2 =getApplicationContext().getSharedPreferences("bkfast1", Context.MODE_PRIVATE);
        redrice = sp2.getString("RedriceNo","");
        noRedRice.setText(redrice);
        if(redrice !=null && redrice.length()>0) {
            Numredrice = Integer.parseInt(redrice);
        }

        NoStringhop=findViewById(R.id.NoStringhop);
        SharedPreferences sp3 =getApplicationContext().getSharedPreferences("bkfast2", Context.MODE_PRIVATE);
        Stringhop = sp3.getString("StringHopNo","");
        NoStringhop.setText(Stringhop);
        if(Stringhop!=null && Stringhop.length()>0) {
            Numstringhop = Integer.parseInt(Stringhop);
        }


        noKotthu=findViewById(R.id.noKotthu);
        SharedPreferences sp4 =getApplicationContext().getSharedPreferences("dinner1", Context.MODE_PRIVATE);
        Kotthu = sp4.getString("KotthuNo","");
        noKotthu.setText(Kotthu);
        if( Kotthu!=null && Kotthu.length()>0) {
            Numkottu= Integer.parseInt(Kotthu);
        }


        NoNoodless=findViewById(R.id.NoNoodless);
        SharedPreferences sp5 =getApplicationContext().getSharedPreferences("dinner3", Context.MODE_PRIVATE);
        Noodless = sp5.getString("NoodlesNo","");
        NoNoodless.setText(Noodless);
        if( Noodless!=null && Noodless.length()>0) {
            Numnoodles= Integer.parseInt(Noodless);
        }


        noFriedrice=findViewById(R.id.noFriedrice);
        SharedPreferences sp6 =getApplicationContext().getSharedPreferences("lunch2", Context.MODE_PRIVATE);
        Friedrice = sp6.getString("friedriceNo","");
        noFriedrice.setText(Friedrice);
        if( Friedrice!=null && Friedrice.length()>0) {
            Numfriedrice= Integer.parseInt(Friedrice);
        }








        int billAmount=Totalbill(Numfriedrice,Numnasigoreng, Numbiriyani,Numstringhop,Numredrice,  Numkottu,Numnoodles);
        tv_bill.setText(Integer.toString(billAmount));




        clear_btn=findViewById(R.id.clear_btn);
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearControll();
            }
        });


        back_btn=(Button) findViewById(R.id.sign_up_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfragment1();
            }
        });


        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save ();
            }
        });

        Delete_btn=findViewById(R.id.Delete_btn);
        Delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteData();
            }
        });

        view_btn=findViewById(R.id.view_btn);
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewData();
            }
        });

        Update_btn=findViewById(R.id.Update_btn);
        Update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateData();
            }
        });


        date_button=findViewById(R.id.date_button);
        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datepicker= new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(),"date picker");
            }
        });




    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c =Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DATE,dayOfMonth);
        String currentDateString= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        et_date.setText(currentDateString);
    }

    public void openfragment1(){

        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);



    }


    public void ClearControll() {

        SharedPreferences sp1 =getApplicationContext().getSharedPreferences("lunch4", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed1 =sp1.edit();
        ed1.remove("NasigoranNo");
        ed1.apply();
        noNasigorang.setText("");

        SharedPreferences sp =getApplicationContext().getSharedPreferences("lunch3", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed =sp.edit();
        ed.remove("biriyaniNo");
        ed.apply();
        Nobiriyani.setText("");

        SharedPreferences sp6 =getApplicationContext().getSharedPreferences("lunch2", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed6 =sp6.edit();
        ed6.remove("friedriceNo");
        ed6.apply();
        noFriedrice.setText("");

        SharedPreferences sp3 =getApplicationContext().getSharedPreferences("bkfast2", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed3 =sp3.edit();
        ed3.remove("StringHopNo");
        ed3.apply();
        NoStringhop.setText("");

        SharedPreferences sp2 =getApplicationContext().getSharedPreferences("bkfast1", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed2 =sp2.edit();
        ed2.remove("RedriceNo");
        ed2.apply();
        noRedRice.setText("");

        SharedPreferences sp4 =getApplicationContext().getSharedPreferences("dinner1", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed4 =sp4.edit();
        ed4.remove("KotthuNo");
        ed4.apply();
        noKotthu.setText("");

        SharedPreferences sp5 =getApplicationContext().getSharedPreferences("dinner3", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed5 =sp5.edit();
        ed5.remove("NoodlesNo");
        ed5.apply();
        NoNoodless.setText("");

        tv_bill.setText("");
        et_date.setText("");
        et_email.setText("");
    }

    //insert
    public void  Save () {
        db = FirebaseDatabase.getInstance().getReference().child("Oder");
        //String email= et_email.getText().toString();


            if (TextUtils.isEmpty(et_date.getText().toString().trim())) {
                Toast.makeText(getApplicationContext(), "Enter the Event Date ", Toast.LENGTH_LONG).show();
            } else if (TextUtils.isEmpty((et_email.getText().toString().trim()))) {
                Toast.makeText(getApplicationContext(), "Enter the Email address", Toast.LENGTH_LONG).show();
            }else if(!Patterns.EMAIL_ADDRESS.matcher(  et_email.getText().toString()).matches()){
                et_email.setError("Pleas Enter Correct Email");
            } else {
                obOder.setDate(et_date.getText().toString().trim());
                obOder.setEmail(et_email.getText().toString().trim());

                obOder.setNobiriyani(Nobiriyani.getText().toString().trim());
                obOder.setNoFriedrice(noFriedrice.getText().toString().trim());
                obOder.setNoNasigorang(noNasigorang.getText().toString().trim());
                obOder.setNoRedRice(noRedRice.getText().toString().trim());
                obOder.setNoStringhop(NoStringhop.getText().toString().trim());
                obOder.setNoKotthu(noKotthu.getText().toString().trim());
                obOder.setNoNoodless(NoNoodless.getText().toString().trim());

                //db.push().setValue(obOder);
                db.child("oder1").setValue(obOder);
                Toast.makeText(getApplicationContext(), "Confirm oder successfully", Toast.LENGTH_LONG).show();
                ClearControll();
            }



    }

    //view
    public void ViewData(){
        db = FirebaseDatabase.getInstance().getReference().child("Oder").child("oder1");

            db.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.hasChildren()) {
                        et_date.setText(dataSnapshot.child("date").getValue().toString());
                        et_email.setText(dataSnapshot.child("email").getValue().toString());
                        Nobiriyani.setText(dataSnapshot.child("nobiriyani").getValue().toString());
                        noFriedrice.setText(dataSnapshot.child("noFriedrice").getValue().toString());
                        noNasigorang.setText(dataSnapshot.child("noNasigorang").getValue().toString());
                        noRedRice.setText(dataSnapshot.child("noRedRice").getValue().toString());
                        NoStringhop.setText(dataSnapshot.child("noStringhop").getValue().toString());
                        noKotthu.setText(dataSnapshot.child("noKotthu").getValue().toString());
                        NoNoodless.setText(dataSnapshot.child("noNoodless").getValue().toString());

                    } else
                        Toast.makeText(getApplicationContext(), " No Source To Display!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

    }


    //delete data from Firebase Database
    public void DeleteData () {
        db = FirebaseDatabase.getInstance().getReference().child("Oder");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("oder1")) {
                    db = FirebaseDatabase.getInstance().getReference().child("Oder").child("oder1");
                    db.removeValue();
                    ClearControll();

                    Toast.makeText(getApplicationContext(), "Data Deleted Successfully!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "No Source To Display!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }





    //update data in the Firebase database
    public void UpdateData () {
        db = FirebaseDatabase.getInstance().getReference().child("Oder");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("oder1")) {

                        obOder.setDate(et_date.getText().toString().trim());
                        obOder.setEmail(et_email.getText().toString().trim());
                        obOder.setNobiriyani(Nobiriyani.getText().toString().trim());
                        obOder.setNoFriedrice(noFriedrice.getText().toString().trim());
                        obOder.setNoNasigorang(noNasigorang.getText().toString().trim());
                        obOder.setNoRedRice(noRedRice.getText().toString().trim());
                        obOder.setNoStringhop(NoStringhop.getText().toString().trim());
                        obOder.setNoKotthu(noKotthu.getText().toString().trim());
                        obOder.setNoNoodless(NoNoodless.getText().toString().trim());

                        db = FirebaseDatabase.getInstance().getReference().child("Oder").child("oder1");
                        db.setValue(obOder);
                        ClearControll();

                        Toast.makeText(getApplicationContext(), "Data updated Successfully!", Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(getApplicationContext(), "No Source To Display!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



    protected int Totalbill( int PNumfriedrice, int PNumnasigoreng, int PNumbiriyani, int PNumstringhop, int PNumredrice, int PNumkottu, int PNumnoodles){
        return (PNumfriedrice*250)+ (PNumnasigoreng*350)+ (PNumbiriyani*300) +(PNumstringhop*110)+(PNumredrice*120) + (PNumkottu*300)+(PNumnoodles*220);
    }



}



























