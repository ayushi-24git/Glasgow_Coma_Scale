package com.example.aarnarratta.glasgowcomascale.AccountActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.aarnarratta.glasgowcomascale.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class eye extends AppCompatActivity {
    private DatabaseReference mdatabaseReference;
    public static int tab1value;
    Button button_next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye);
            mdatabaseReference = FirebaseDatabase.getInstance().getReference();
            RadioGroup RadioGroup = (RadioGroup)findViewById(R.id.RadioGroup);

            RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    // checkedId is the RadioButton selected

                    switch (checkedId) {
                        case R.id.spont:
                            tab1value = 4;
                            Toast.makeText(eye.this, "Opens Eyes Spontaneously", Toast.LENGTH_LONG).show();

                            break;
                        case R.id.respo:
                            tab1value = 3;
                            Toast.makeText(eye.this, "Opens Eyes In response to Voice", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.stim:
                            tab1value = 2;
                            Toast.makeText(eye.this, "Opens Eyes In response to Painful Voice", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.does:
                            tab1value = 1;
                            Toast.makeText(eye.this, "Does Not open eyes", Toast.LENGTH_LONG).show();
                            break;

                    }
                }
            });
            button_next1 = (Button) findViewById(R.id.button_next1);

            button_next1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mdatabaseReference.child("value1").setValue(tab1value);
                    Intent i=new Intent(eye.this,verbal.class);
                    startActivity(i);
                    eye.this.finish();
                }
            });


        }}

