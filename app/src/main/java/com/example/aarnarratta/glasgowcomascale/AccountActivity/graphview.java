package com.example.aarnarratta.glasgowcomascale.AccountActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import com.example.aarnarratta.glasgowcomascale.R;
import com.jjoe64.graphview.GraphView;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graphview extends AppCompatActivity {


    LineGraphSeries<DataPoint> series;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphview);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]
                {
                        new DataPoint(0, 1),
                        new DataPoint(1, 5),
                        new DataPoint(2, 3),
                        new DataPoint(3, 2),
                        new DataPoint(4, 6)


                });
        graph.addSeries(series);


    }

}






