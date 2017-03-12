package com.example.www.xceptions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private static final String REGISTER_URL = "http://nikesh.esy.es/php_files/xceptionsregister.php";

    public static final String KEY_REGISTERNO= "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DEPARTMENT = "department";
    public static final String KEY_SEMESTER = "year";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONENO = "phno";
    public static final String KEY_COLLEGENAME = "clgname";
    public static final String KEY_DEBATE = "debate";
    public static final String KEY_TESTING = "testing";
    public static final String KEY_PPT = "ppt";
    public static final String KEY_QUIZ = "quiz";
    public static final String KEY_UI = "ui";
    public static final String KEY_MEME = "meme";
    public static final String KEY_IPL = "ipl";
    public static final String KEY_WORKSHOP = "workshop";

    private EditText regId;
    private EditText regName;
    private EditText regYear;
    private EditText regemail;
    private EditText regPhno;
    private EditText regClg;
    private EditText regDept;

    private CheckBox chkdebate, chktesting, chkppt, chkquiz, chkuidesign, chkmeme, chkipl, chkWorkshop;
    String debate="No",testing="No",ppt="No",quiz="No",ui="No",meme="No",ipl="No", workshop="No";
    int flagdebate,flagtesting,flagppt,flagquiz,flagui,flagmeme,flagipl,flagworkshop;

    private Button sendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regId = (EditText) findViewById(R.id.regId);
        regName = (EditText) findViewById(R.id.regName);
        regDept = (EditText) findViewById(R.id.regDept);
        regYear= (EditText) findViewById(R.id.regYear);
        regemail= (EditText) findViewById(R.id.regemail);
        regPhno= (EditText) findViewById(R.id.regPhno);
        regClg= (EditText) findViewById(R.id.regCollege);

        chkdebate =(CheckBox)findViewById(R.id.chkDebate);
        chktesting =(CheckBox)findViewById(R.id.chkTesting);
        chkppt =(CheckBox)findViewById(R.id.chkPaper);
        chkquiz =(CheckBox)findViewById(R.id.chkQuiz);
        chkuidesign =(CheckBox)findViewById(R.id.chkui);
        chkmeme =(CheckBox)findViewById(R.id.chkmeme);
        chkipl =(CheckBox)findViewById(R.id.chkIpl);
        chkWorkshop =(CheckBox)findViewById(R.id.chkWorkshop);

        sendData = (Button) findViewById(R.id.sendData);

        sendData.setOnClickListener(this);

        chkdebate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flagdebate==0)
                {
                    flagdebate=1;
                    debate = "Yes";
                }
                else
                {
                    flagdebate=0;
                    debate = "No";
                }
            }
        });

        chktesting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flagtesting==0)
                {
                    flagtesting=1;
                    testing = "Yes";
                }
                else
                {
                    flagtesting=0;
                    testing = "No";
                }
            }
        });

        chkppt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flagppt==0)
                {
                    flagppt=1;
                    ppt = "Yes";
                }
                else
                {
                    flagppt=0;
                    ppt = "No";
                }
            }
        });

        chkquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flagquiz==0)
                {
                    flagquiz=1;
                    quiz = "Yes";
                }
                else
                {
                    flagquiz=0;
                    quiz = "No";
                }
            }
        });

        chkuidesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flagui==0)
                {
                    flagui=1;
                    ui = "Yes";
                }
                else
                {
                    flagui=0;
                    ui = "No";
                }
            }
        });

        chkmeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flagmeme==0)
                {
                    flagmeme=1;
                    meme = "Yes";
                }
                else
                {
                    flagmeme=0;
                    meme = "No";
                }
            }
        });

        chkipl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flagipl==0)
                {
                    flagipl=1;
                    ipl = "Yes";
                }
                else
                {
                    flagipl=0;
                    ipl = "No";
                }
            }
        });

        chkWorkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flagworkshop==0)
                {
                    flagworkshop=1;
                    workshop = "Yes";
                }
                else
                {
                    flagworkshop=0;
                    workshop = "No";
                }
            }
        });

    }

    private void registerUser(){
        final String regno = regId.getText().toString().trim();
        final String name = regName.getText().toString().trim();
        final String department = regDept.getText().toString().trim();
        final String year = regYear.getText().toString().trim();

        final String phoneno = regPhno.getText().toString().trim();
        final String email = regemail.getText().toString().trim();
        final String collegename= regClg.getText().toString().trim();

        if (!regno.isEmpty() && !name.isEmpty() && !department.isEmpty() && !year.isEmpty() && !phoneno.isEmpty() && !email.isEmpty() && !collegename.isEmpty())
        {
            if(debate.matches("No") && ppt.matches("No") && testing.matches("No") && ui.matches("No") && meme.matches("No") && ipl.matches("No") && quiz.matches("No") && workshop.matches("No"))
            {
                int yearnumeric= Integer.parseInt(regYear.getText().toString());
                if(yearnumeric<5)
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jObj = new JSONObject(response);
                                        boolean error = jObj.getBoolean("error");
                                        if (!error) {
                                            Intent intent=new Intent(Register.this,RegistrationSuccess.class);
                                            startActivity(intent);
                                            finish();
                                        } else {

                                            // Error occurred in registration. Get the error
                                            // message
                                            String errorMsg = jObj.getString("error_msg");
                                            Toast.makeText(getApplicationContext(),
                                                    errorMsg, Toast.LENGTH_LONG).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(Register.this,error.toString(),Toast.LENGTH_LONG).show();
                                }
                            }){
                        @Override
                        protected Map<String,String> getParams(){
                            Map<String,String> params = new HashMap<String, String>();
                            params.put(KEY_REGISTERNO,regno);
                            params.put(KEY_NAME,name);
                            params.put(KEY_DEPARTMENT,department);
                            params.put(KEY_SEMESTER,year);
                            params.put(KEY_PHONENO,phoneno);
                            params.put(KEY_EMAIL,email);
                            params.put(KEY_COLLEGENAME,collegename);

                            params.put(KEY_DEBATE,debate);
                            params.put(KEY_TESTING,testing);
                            params.put(KEY_PPT,ppt);
                            params.put(KEY_QUIZ,quiz);
                            params.put(KEY_UI,ui);
                            params.put(KEY_MEME,meme);
                            params.put(KEY_IPL,ipl);
                            params.put(KEY_WORKSHOP,workshop);

                            return params;
                        }

                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(this);
                    requestQueue.add(stringRequest);
                }
                else
                {
                    Toast.makeText(Register.this,"Invalid year of study",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(Register.this,"Select at least one event",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(Register.this,"All fields are mandatory",Toast.LENGTH_LONG).show();
        }



    }

    @Override
    public void onClick(View v) {
        if(v == sendData){
            if(CheckNetwork.isInternetAvailable(Register.this)) //returns true if internet available
            {
                registerUser();
            }
            else {
                Toast.makeText(Register.this, "No Internet Connection", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Register.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
