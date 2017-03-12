package com.example.www.xceptions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventDescription extends AppCompatActivity {

    ImageButton imgBtn;
    TextView eventName,eventTime,eventLocation,eventDescription,eventRound,eventRound1,eventRound2,eventRound3,eventPrizes,eventRound3Heading;

    int position;
    public String name[]={"Technical debate","Testing","Paper presentation","Rapid fire quiz","UI-UX Design","Meme creation","IPL auction"};
    public String time[]={"10:30 AM - 12:00 PM","10:30 AM - 12:00 PM","10:30 AM - 12:00 PM","1:00 PM - 3:00 PM","1:00 PM - 3:00 PM","1:00 PM - 3:00 PM","10:30 PM - 3:00 PM"};
    public String location[]={"KMC Auditorium","IT Laboratory","Mirza Auditorium","KMC Auditorium","IT Laboratory - I","IT Laboratory - II","Location will be told shortly"};
    public String rounds[]={"There are TWO rounds in this event","There are TWO rounds in this event","There are THREE rounds in this event","There are THREE rounds in this event"
        ,"There are THREE rounds in this event","There are TWO rounds in this event","There are TWO rounds in this event"};
    public String description[]={"Participants can present their content in either English or Tamil. It is an individual participation event",
                                    "This is a testing event in which participants need to write test cases against the problems given. Maximum of 2 members can form a team",
                                    "The topics for the paper presentation are ANDROID, CRYPTOGRAPHY, IMAGE PROCESSING, NETWORKING SECURITY, EMBEDDED SYSTEM, DATA MINING, MOBILE NETWORKING, ARTIFICIAL INTELLIGENCE",
                                    "The rapid fire quiz consists of both technical and non-technical questions",
                                    "User interface is the first look of an app. Design most creative user interface and win prizes. Photoshop can also be used in designing. Maximum of two participants can be in a team",
                                    "This is an individual participation event. Each participants are required to create a meme.",
                                    "In this event we are conducting a mock auction for IPL 2017. Maximum of three persons can form a team. Each team can buy maximum 15 players and a minimum of 11 players. Highest bid will get the player. In that players 4 foreign players, 2 all-rounders, 3 bowlers, 4 batsmen, 1 captain and 1 Wk needs to be selected"};
    public String round1[]={"In the preliminary round you can choose to speak 'FOR' or 'AGAINST' the topic for a maximum of 3 minutes",
                        "10 MCQ questions from software testing and software engineering will be asked",
                        "The first phase of selection will be based on the abstract. The abstract needs to be sent to xceptions2k17@gmail.com on or before -------. The paper should be in IEEE format",
                        "25 MCQ questions needs to be answered in 20 minutes",
                        "Participants will be asked to create a simple design on a given topic within a span of 20 minutes",
                        "The participants will be given a specific scenario and each participants will be given a unique watermark id. The participant is required to create meme in relevance to scenario given within a time period of 15 minutes",
                        "MCQ questions will be asked about cricket"};
    public String round2[]={"In the final round your stance of speech will be assigned on the spot for a maximum of 6 minutes",
                "Participants will be asked to write simple test cases for two problems",
                "During the event the participant will get 10 minutes to present their papers. Hard copy of the paper needs to be submitted before the presentation",
                "Each team will be asked 10 questions one after another in a minute.",
                "Participants will be expected to refine the simple design in a span of 20 minutes",
                "The participants has to create a hilarious meme in a span of 10 minutes",
                "Only 8 teams will be selected. Auction will be started. Overall ratings will be declared as WINNERS"};
    public String round3[]={"","Participants have to write a creative test case for a given problem. Winners will be selected based on the innovative ideas and number of test cases. Time limit for this round is 30 minutes",
                "","","Participants are required to design a full effective user interface for an application",
                "The champs will be selected based on hilarious and creative meme",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);

        eventName=(TextView)findViewById(R.id.event_name);
        eventTime=(TextView)findViewById(R.id.event_time);
        eventLocation=(TextView)findViewById(R.id.event_location);
        eventDescription=(TextView)findViewById(R.id.event_description);
        eventRound=(TextView)findViewById(R.id.rounds_description);
        eventRound1=(TextView)findViewById(R.id.event_round1);
        eventRound2=(TextView)findViewById(R.id.event_round2);
        eventRound3=(TextView)findViewById(R.id.event_round3);
        eventRound3Heading=(TextView)findViewById(R.id.event_round3_heading);


        Bundle bundle=getIntent().getExtras();
        position=bundle.getInt("position");

        Toast.makeText(EventDescription.this,name[position],Toast.LENGTH_SHORT).show();
        imgBtn=(ImageButton)findViewById(R.id.imgBtnBack);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EventDescription.this,Event.class);
                startActivity(intent);
                finish();
            }
        });

        eventName.setText(name[position]);
        eventTime.setText(time[position]);
        eventLocation.setText(location[position]);
        eventRound.setText(rounds[position]);
        eventDescription.setText(description[position]);
        eventRound1.setText(round1[position]);
        eventRound2.setText(round2[position]);
        if(round3[position].matches(""))
        {
            eventRound3.setVisibility(View.INVISIBLE);
            eventRound3Heading.setVisibility(View.INVISIBLE);
        }
        else
        {
            eventRound3.setText(round3[position]);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(EventDescription.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
