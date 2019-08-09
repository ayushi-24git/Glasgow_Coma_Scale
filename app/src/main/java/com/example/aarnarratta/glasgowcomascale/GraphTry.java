package com.example.aarnarratta.glasgowcomascale;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.aarnarratta.glasgowcomascale.AccountActivity.motor;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;


public class GraphTry extends AppCompatActivity {


    String [] c = new String[1830];
    motor objmotor=new motor();
    String s2=objmotor.s1;
    int y,n,b[];
    long a[],x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_try);
        final Date date =new Date();
        final SimpleDateFormat ft=new SimpleDateFormat ("dd MM yyyy\nHH:mm:ss");
        String xaxis1 = ft.format(date).replaceAll("[:\n ]","");
        String xaxis=xaxis1.trim();
        System.out.println("hello1234"+xaxis);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        String[] s3 = s2.split(",");
        System.out.println("hello1245"+s3);
        n=s3.length;
        b=new int[n];
        a=new long[n];
        System.out.println("helloayu"+xaxis.substring(0,11));

        for(int i=0;i<n;i++)
        {
            a[i]=Long.parseLong(xaxis.substring(0,12));
            System.out.println("hello1245"+a[0]);
            b[i]=Integer.parseInt(s3[i]);

        }
//

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

        System.out.println("hello1234"+b[0]+b[1]+b[2]+b[3]);
        System.out.println("hello1234"+a[0]+a[1]+a[2]+a[3]);

        graph.addSeries(series);
        series.setColor(R.color.colorPrimary);
//        series.setDrawBackground(true);
//        series.setBackgroundColor(Color.argb(50, 0, 255, 255));
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(15);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(n);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        series.setThickness(12);

        //graph.setViewPort(0,3);
        graph.getViewport().setScrollable(true);
        // graph.setViewPort(0, 5);

        graph.getViewport().setScalable(true);
//        graph.getViewport().setScalableY(true);
        graph.getViewport().setScrollable(true);
//        graph.getViewport().setScrollableY(true);
//        graph.setVerticalScrollBarEnabled(true);
        graph.setHorizontalScrollBarEnabled(true);


        graph.getGridLabelRenderer().setNumHorizontalLabels(4);
        graph.getGridLabelRenderer().setNumVerticalLabels(15);
//        graph.getGridLabelRenderer().setHumanRounding(false);
        graph.getGridLabelRenderer().setVerticalAxisTitle("Score on GCS ----->");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Date & Time ------>");
        graph.getGridLabelRenderer().setTextSize(30);
        graph.getGridLabelRenderer().setHorizontalAxisTitleTextSize(30);
        graph.getGridLabelRenderer().setVerticalAxisTitleTextSize(30);

    }

    private DataPoint[] generateData() {
        DataPoint[] values = new DataPoint[n];
        System.out.println("hello1234"+b[0]+b[1]+b[2]+b[3]);
        System.out.println("hello1234"+a[0]+a[1]+a[2]+a[3]);

        for (int i=0; i<n; i++) {
            x = i;
            //x=25,y=score  x=27,y=score2
            y = b[i];
            DataPoint v = new DataPoint(x, y);
            System.out.println("AYUSHI1"+x+y);

            values[i] = v;
            System.out.println("AYUSHI"+v);
        }
        return values;
    }
}
