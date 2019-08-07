package com.example.aarnarratta.glasgowcomascale.AccountActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aarnarratta.glasgowcomascale.R;

public class Patient extends AppCompatActivity {
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        addListenerOnButton();

    }

    public void addListenerOnButton() {

        final Context context = this;

        button1 = (Button) findViewById(R.id.PAT1);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, PatientInfo.class);
                startActivity(intent);

            }

        });
    }
}
