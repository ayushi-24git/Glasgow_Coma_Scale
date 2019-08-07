package com.example.aarnarratta.glasgowcomascale.AccountActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.aarnarratta.glasgowcomascale.R;
import com.example.aarnarratta.glasgowcomascale.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

public class PatientInfo extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mdatabaseReference;
    EditText name;
    EditText mobile, address ;
    RadioGroup rg;
    RadioButton gender;
    Button B1;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        firebaseAuth = FirebaseAuth.getInstance();
        mdatabaseReference = FirebaseDatabase.getInstance().getReference();
        progressDialog = new ProgressDialog(this);
        name = (EditText) findViewById(R.id.Name);
        mobile = (EditText) findViewById(R.id.Mobile);
        address = (EditText) findViewById(R.id.Address);
//        patient_id = findViewById(R.id.PatientId);

        B1 = (Button) findViewById(R.id.save);
        rg = (RadioGroup) findViewById(R.id.RadioGroup);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdatabaseReference.orderByChild("2");
                if(view==B1) {
                    saveUserInformation();
                    Intent i1 = new Intent(PatientInfo.this, eye.class);
                    startActivity(i1);
                }
            }
        });
    }




    private void saveUserInformation() {
        String Name, Mobile, Address, Gender,Patientid;
        Name = name.getText().toString();
        Mobile = mobile.getText().toString();
        Address = address.getText().toString();
//        Patientid = patient_id.getText().toString();
        UserInformation userInformation = new UserInformation(Name, Address, Mobile);
//        mdatabaseReference.push().setValue(userInformation);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        mdatabaseReference.child(user.getUid()).setValue(userInformation);
        Toast.makeText(this, "Information saved!", Toast.LENGTH_SHORT).show();
    }



    }



  /*  private void registeruser() {
        String Name, Mobile, Address, Gender;
        Name = name.getText().toString();
        Mobile = mobile.getText().toString();
        Address = address.getText().toString();
        int id = rg.getCheckedRadioButtonId();
        gender = (RadioButton) findViewById(id);
        Gender = gender.getText().toString();
        if(TextUtils.isEmpty(Name))
        {
            //Email is empTty
            Toast.makeText(this,"Please enter the patient's name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Mobile)){
            //Contact no. is empty
            Toast.makeText(this,"Please enter the patient's number",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty((Address))){
            //Address is Empty
            Toast.makeText(this,"Please enter the patient's address",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Saving..");
        progressDialog.show();
    }*/

