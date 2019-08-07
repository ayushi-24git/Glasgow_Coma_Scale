package com.example.aarnarratta.glasgowcomascale.AccountActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aarnarratta.glasgowcomascale.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class motor extends AppCompatActivity {
    private Button button_next3;
    public int tab3value;
    public static int score;
    public static String s, s1;
    FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = mFirebaseDatabase.getReference();

    public motor() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor);
//        mDatabaseReference.child("scoredisplay").setValue("10");
        RadioGroup RadioGroup = (RadioGroup) findViewById(R.id.RadioGroup);

        RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup RadioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.obeys:

                        tab3value = 6;
                        Toast.makeText(motor.this, "6. Obeys commands", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.local:

                        tab3value = 5;
                        Toast.makeText(motor.this, " 5. Localizes painful stimuli", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.abno:

                        tab3value = 4;
                        Toast.makeText(motor.this, "4. Flexion/Withdrawl to painful stimuli", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.does:
                        tab3value = 3;
                        Toast.makeText(motor.this, "3. Abnormal flexion to painful stimuli", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.exten:

                        tab3value = 2;
                        Toast.makeText(motor.this, "2. Extension to painful stimuli", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.make:

                        tab3value = 1;
                        Toast.makeText(motor.this, "1.Makes no movements", Toast.LENGTH_LONG).show();
                        break;


                }
            }
        });
        button_next3 = (Button) findViewById(R.id.button_next3);

//

        button_next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabaseReference.child("value3").setValue(tab3value);
//
                score = eye.tab1value + verbal.tab2value + tab3value;
                mDatabaseReference.child("scorestorage").setValue(score);

                s = Integer.toString(score);
//

                mDatabaseReference.child("scoredisplay").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
//
                        s1 = dataSnapshot.getValue().toString();
//

                        s = Integer.toString(score);
                        s1 = s1 + "," + s;
//                        System.out.println("hello"+s1);
//
                        mDatabaseReference.child("scoredisplay").setValue(s1);

//

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
//
                    }
                });

//
                Intent i = new Intent(motor.this, result.class);
                startActivity(i);
                motor.this.finish();

            }
        });
    }
}
