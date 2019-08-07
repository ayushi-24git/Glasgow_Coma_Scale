package com.example.aarnarratta.glasgowcomascale.AccountActivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.aarnarratta.glasgowcomascale.R;

public class gallery extends AppCompatActivity {
    private Integer[] images={R.drawable.g1,R.drawable.g2,R.drawable.g3,
            R.drawable.g5,R.drawable.g6,R.drawable.g7,R.drawable.g8};
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
            Gallery imgGallery = (Gallery) findViewById(R.id.gallery);

            imgGallery.setAdapter(new ImageAdapter(this));


        }
    public class ImageAdapter extends BaseAdapter {
            private Context context;
            int imageBackground;

            public ImageAdapter(Context context) {

                this.context = context;
            }

            @Override
            public int getCount() {

                return images.length;
            }

            @Override
            public Object getItem(int arg0) {

                return arg0;
            }

            @Override
            public long getItemId(int arg0) {

                return arg0;
            }

            @Override
            public View getView(int arg0, View arg1, ViewGroup arg2) {

                ImageView imageView = new ImageView(context);
                imageView.setImageResource(images[arg0]);
                return imageView;
            }
        }

}
