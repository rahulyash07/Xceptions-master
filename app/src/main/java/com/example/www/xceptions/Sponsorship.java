package com.example.www.xceptions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Sponsorship extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsorship);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Sponsorship.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
