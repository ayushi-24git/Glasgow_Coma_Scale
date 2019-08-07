package com.example.aarnarratta.glasgowcomascale.AccountActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aarnarratta.glasgowcomascale.GraphTry;
import com.example.aarnarratta.glasgowcomascale.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class result extends AppCompatActivity {

    FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = mFirebaseDatabase.getReference();
    public TextView scoreview, eyescoreview, verbalscoreview, motorscoreview,wordview;
    Button button, button1;
    motor objmotor=new motor();
    int scoreyo=objmotor.score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        wordview=(TextView)findViewById(R.id.id_typeofinjury);
        if(scoreyo<=8)
        {
            wordview.setText("Severe brain injury");
        }
        else
        if(scoreyo<=12)
        {
            wordview.setText("Moderate brain injury");
        }
        else
        {
            wordview.setText("Minor brain injury");
        }
        scoreview = (TextView) findViewById(R.id.id_scoreview);
        eyescoreview = (TextView) findViewById(R.id.id_eyescore);
        verbalscoreview = (TextView) findViewById(R.id.id_verbalscore);
        motorscoreview = (TextView) findViewById(R.id.id_motorscore);
        button = (Button) findViewById(R.id.restart);
        button1 = (Button) findViewById(R.id.forgraph);
        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                scoreview.setText(dataSnapshot.child("scorestorage").getValue().toString());
                eyescoreview.setText(dataSnapshot.child("value1").getValue().toString());
                verbalscoreview.setText(dataSnapshot.child("value2").getValue().toString());
                motorscoreview.setText(dataSnapshot.child("value3").getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(result.this, "Error", Toast.LENGTH_LONG).show();

            }
        });
        Button button = (Button) findViewById(R.id.restart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(result.this, eye.class);
                startActivity(i);
                result.this.finish();

            }
        });
        Button button1 = (Button) findViewById(R.id.forgraph);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(result.this, GraphTry.class);
                startActivity(i);
                result.this.finish();
            }
        });
    }
}
