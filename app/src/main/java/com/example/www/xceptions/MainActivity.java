package com.example.www.xceptions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton imgBtnEvents,imgbtnWorkshop,imgbtnagenda,imgbtnregister,imgbtnsponsor,imgbtninfo,imgbtncontact,imgbtnlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtnEvents=(ImageButton)findViewById(R.id.events);
        imgbtnWorkshop=(ImageButton)findViewById(R.id.workshop);
        imgbtnagenda=(ImageButton)findViewById(R.id.agenda);
        imgbtnregister=(ImageButton)findViewById(R.id.register);
        imgbtnsponsor=(ImageButton)findViewById(R.id.sponsor);
        imgbtnlocation=(ImageButton)findViewById(R.id.location);
        imgbtninfo=(ImageButton)findViewById(R.id.info);
        imgbtncontact=(ImageButton)findViewById(R.id.contact);


        imgBtnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Event.class);
                startActivity(intent);
                finish();
            }
        });

        imgbtnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
                finish();
            }
        });

        imgbtnlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AboutLocation.class);
                startActivity(intent);
                finish();
            }
        });

        imgbtninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AboutXceptions.class);
                startActivity(intent);
                finish();
            }
        });

        imgbtnsponsor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Sponsorship.class);
                startActivity(intent);
                finish();
            }
        });

        imgbtnWorkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Workshop.class);
                startActivity(intent);
                finish();
            }
        });

        imgbtnagenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Agenda.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
