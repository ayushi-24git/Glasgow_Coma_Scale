package com.example.aarnarratta.glasgowcomascale.AccountActivity;

import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by hp on 26-06-2018.
 */

public class pointvalue extends AppCompatActivity{
    String x;
    double y;
    public pointvalue(long x, int y)
    {

    }
    public pointvalue(String x,double y)
    {
        this.x=x;
        this.y=y;
    }
    public String getXvalue()
    {
        return x;
    }
    public double getYvalue()
    {
        return y;
    }



}
