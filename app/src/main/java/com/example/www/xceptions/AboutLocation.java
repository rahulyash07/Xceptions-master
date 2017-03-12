package com.example.www.xceptions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AboutLocation extends AppCompatActivity {

    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_location);

        btnBack=(ImageButton)findViewById(R.id.imgBtnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AboutLocation.this,MainActivity.class);
                startActivity(intent);
                finish();



            }
        });
        Button loc=(Button)findViewById(R.id.loc);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AboutLocation.this,Location.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
