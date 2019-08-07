package com.example.aarnarratta.glasgowcomascale.AccountActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.aarnarratta.glasgowcomascale.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.aarnarratta.glasgowcomascale.AccountActivity.eye.tab1value;

public class verbal extends AppCompatActivity {
    private DatabaseReference mdatabaseReference;
    private Button button_next2;
    public static int tab2value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbal);
        button_next2 = (Button)findViewById(R.id.button_next2);
//        button_next2.setEnabled(false);




            mdatabaseReference = FirebaseDatabase.getInstance().getReference();
            RadioGroup RadioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
//        button_next2.setEnabled(true);

//            button_next2.setEnabled(false);
//            Toast.makeText(verbal.this, "Please enter a valid verbal response!", Toast.LENGTH_LONG)
//                    .show(); // no radio buttons are checked



            RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    // checkedId is the RadioButton selected
                    // checkedId is the RadioButton selected
                    switch (checkedId) {
                        case R.id.normal:

                            tab2value = 5;
                            Toast.makeText(verbal.this, "Oriented, converses normally", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.dist:

                            tab2value = 4;
                            Toast.makeText(verbal.this, "Confused,Distorted", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.utt:
                            tab2value = 3;
                            Toast.makeText(verbal.this, "Utters In appropriate words", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.incom:

                            tab2value = 2;
                            Toast.makeText(verbal.this, "Incomprehensible sounds", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.nos:

                            tab2value = 1;
                            Toast.makeText(verbal.this, "Makes no sounds", Toast.LENGTH_LONG).show();
                            break;

//                        default:
//                            Toast.makeText(verbal.this, "Please enter a valid verbal response!", Toast.LENGTH_LONG)
//                                    .show();
//                            System.out.println("helloayu");
//                            button_next2.setEnabled(false);

                    }
                }
            });
//        button_next2.setEnabled(true);
//        if (RadioGroup.getCheckedRadioButtonId() == -1)
//        {
//
//            Toast.makeText(verbal.this, "Please enter a valid verbal response!", Toast.LENGTH_LONG)
//                    .show(); // no radio buttons are checked
//       }
// if(tab2value==0) {
//            button_next2.setEnabled(false);
//            Toast.makeText(verbal.this, "Please enter a valid verbal response!", Toast.LENGTH_LONG)
//                    .show();
//        }

//            button_next2.setEnabled(true);

            button_next2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mdatabaseReference.child("value2").setValue(tab2value);
                    Intent i1 = new Intent(verbal.this, motor.class);
                    startActivity(i1);
                    verbal.this.finish();

                }
            });
//        if((tab1value==0)&&(RadioGroup.getCheckedRadioButtonId() == -1)) {
//            button_next2.setEnabled(false);
//            Toast.makeText(verbal.this, "Please enter a valid verbal response!", Toast.LENGTH_LONG).show();
//        }


    }
}
