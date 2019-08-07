package com.example.aarnarratta.glasgowcomascale;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.text.*;

import com.example.aarnarratta.glasgowcomascale.AccountActivity.motor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;


public class GraphTry extends AppCompatActivity {

    FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = mFirebaseDatabase.getReference();
    public static String ddisp;

    motor objmotor = new motor();
    String s2 = objmotor.s1;
    int y, b[],i,n1,n2;
    long a[], x;
    final Date date = new Date();
    final SimpleDateFormat ft = new SimpleDateFormat("dd MM yyyy\nHH:mm:ss");
    String xaxis1, xaxis;
    String[] s4, s3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("ayu");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_try);
        System.out.println("ayushi1"+s4.length);
//        mDatabaseReference.child("datedisplay").setValue("11");
        xaxis1 = ft.format(date).replaceAll("[:\n ]", "");
        xaxis = xaxis1.trim();
//        System.out.println("ayushi1" + ft.format(date));
//        System.out.println("hello1234"+xaxis);
        GraphView graph = (GraphView) findViewById(R.id.graph);
//        StaticLabelsFormatter staticLabelsFormatter=new StaticLabelsFormatter(graph);
////        staticLabelsFormatter.setHorizontalLabels(new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12"});
//        staticLabelsFormatter.setVerticalLabels(new String[]{"3","4","5","6","7","8","9","10",
//                "11","12","13","14","15"});
//        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        s3 = s2.split(",");

        System.out.println("ayushi2" + s3);
          n1 = s3.length;

        LineGraphSeries series = new LineGraphSeries<DataPoint>(generateData());
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX)
                    return ft.format(date);


                else
                    return super.formatLabel(value, isValueX);

            }

        });
//        System.out.println("ayushi3");
//        System.out.println("ayushi2"+xaxis);
//        System.out.println("helloayu"+xaxis.substring(0,11));
//        mDatabaseReference.child("datedisplay").setValue("10");
//        System.out.println("ayushi4" + xaxis);
        mDatabaseReference.child("datestorage").setValue(xaxis);

        mDatabaseReference.child("datedisplay").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ddisp = dataSnapshot.getValue().toString();
//                System.out.println("ayushi5" + ddisp);
                System.out.println("ayushi1"+s4.length);
                ddisp = ddisp + "," + xaxis;
                mDatabaseReference.child("datedisplay").setValue(ddisp);
                System.out.println("ayushi6" + s2);
                s4 = ddisp.split(",");
                System.out.println("ayushi1"+s4.length);
                n2=ddisp.length();
//                for(i=0;i<s2.length();i++)
//                {
//                    if(s2[i]==",")
//                        n++;
//                }
//                n = s2.replaceAll("[,]", "");
//                n=StringUtils.countMatches(s2, ",");
//                n=s2.count(",");
//                n = s3.replaceAll("[^,]","").length();
//                n=s2.count(",");
//        n=count(s3.begin(), s3.end(), ',');
//        System.out.println("ayushi12" + n1);

                b = new int[n1];
                a = new long[n1];
//                System.out.println("ayushi11"+n2);
                for (i = 0; i < n1; i++)
                {
                    a[i] = Long.parseLong(s4[i]);
           System.out.println("ayushi1"+":"+s4[0]+":"+s4[1]+":"+s4[2]+":"+s4[3]);
                    b[i] = Integer.parseInt(s3[i]);
                    System.out.println("ayushi8"+":"+s4[0]+":");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("ayushi10" + ddisp);
            }
        });

        System.out.println("ayushi"+n1+n2);
        System.out.println("ayushi7"+a[0]+a[1]+a[2]+a[3]);

        graph.addSeries(series);
        series.setColor(R.color.colorPrimary);
        series.setDrawBackground(true);
        series.setBackgroundColor(Color.argb(50, 0, 255, 255));
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(1);
        graph.getViewport().setMaxY(15);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(n1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        series.setThickness(12);
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setScrollable(true);
        graph.getViewport().setScrollableY(true);
        graph.setVerticalScrollBarEnabled(true);
        graph.setHorizontalScrollBarEnabled(true);


        graph.getGridLabelRenderer().setNumHorizontalLabels(4);
//        graph.getGridLabelRenderer().setHumanRounding(true);
        graph.getGridLabelRenderer().setNumVerticalLabels(15);
        graph.getGridLabelRenderer().setHumanRounding(false);
        graph.getGridLabelRenderer().setVerticalAxisTitle("Score on GCS ----->");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Date & Time ------>");
        graph.getGridLabelRenderer().setTextSize(30);
        graph.getGridLabelRenderer().setHorizontalAxisTitleTextSize(25);
        graph.getGridLabelRenderer().setVerticalAxisTitleTextSize(30);

    }

    private DataPoint[] generateData() {
        DataPoint[] values = new DataPoint[n1];
//        System.out.println("hello1234"+b[0]+b[1]+b[2]+b[3]);
//        System.out.println("hello1234"+a[0]+a[1]+a[2]+a[3]);

        for (int i = 0; i < n1; i++) {
            x = a[i];
            //x=25,y=score  x=27,y=score2
            y = b[i];
            DataPoint v = new DataPoint(x, y);
//            System.out.println("AYUSHI1"+x+y);

            values[i] = v;
//            System.out.println("AYUSHI"+v);
        }
        return values;
    }
}
//calc no of days from day 1 and then find the date or last option is opt the day 1 day 2 method
//can use sethorizontallabels to restrict the number of datapoints
