package com.example.www.xceptions;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AboutXceptions extends AppCompatActivity {

    ImageButton btnBack,btnfb,btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_xceptions);

        btnBack=(ImageButton)findViewById(R.id.imgBtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AboutXceptions.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnfb=(ImageButton) findViewById(R.id.btnfb);
        btnfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/pg/Xceptions2k17/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnEmail=(ImageButton) findViewById(R.id.btnemail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to="xceptions2k17@gmail.com";



                Intent email = new Intent(Intent.ACTION_SEND);

                //email.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});


                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));


            }
        });


    }
}
