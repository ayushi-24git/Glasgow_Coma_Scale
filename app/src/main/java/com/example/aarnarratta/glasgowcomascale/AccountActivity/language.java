package com.example.aarnarratta.glasgowcomascale.AccountActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aarnarratta.glasgowcomascale.R;

public class language extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String[] listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);


        listItem = getResources().getStringArray(R.array.Languages);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub

                if (position == 0) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, English.class);
                    startActivity(myIntent);


                }

                else if (position == 1) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Bangla.class);
                    startActivity(myIntent);


                }

                else if (position == 2) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Chinese.class);
                    startActivity(myIntent);


                }

                else if (position == 3) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Danish.class);
                    startActivity(myIntent);


                }

                else if (position == 4) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Gaelic.class);
                    startActivity(myIntent);


                }

                else if (position == 5) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Greek.class);
                    startActivity(myIntent);


                }

                else if (position == 6) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Gujarati.class);
                    startActivity(myIntent);


                }

                else if (position == 7) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Hindi.class);
                    startActivity(myIntent);


                }

                else if (position == 8) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Hungarian.class);
                    startActivity(myIntent);


                }

                else if (position == 9) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Indonesian.class);
                    startActivity(myIntent);


                }

                else if (position == 10) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Kannada.class);
                    startActivity(myIntent);


                }

                else if (position == 11) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Malay.class);
                    startActivity(myIntent);


                }

                else if (position == 12) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Marathi.class);
                    startActivity(myIntent);


                }

                else if (position == 13) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Nepal.class);
                    startActivity(myIntent);


                }

                else if (position == 14) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Odia.class);
                    startActivity(myIntent);


                }

                else if (position == 15) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Polish.class);
                    startActivity(myIntent);


                }

                else if (position == 16) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Portuguese.class);
                    startActivity(myIntent);


                }

                else if (position == 17) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Punjabi.class);
                    startActivity(myIntent);


                }

                else if (position == 18) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Romanian.class);
                    startActivity(myIntent);


                }

                else if (position == 19) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Rwandan.class);
                    startActivity(myIntent);


                }

                else if (position == 20) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Swedish.class);
                    startActivity(myIntent);


                }

                else if (position == 21) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Thai.class);
                    startActivity(myIntent);


                }

                else if (position == 22) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Urdu.class);
                    startActivity(myIntent);


                }

                else if (position == 23) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Vietnamese.class);
                    startActivity(myIntent);


                }

                else if (position == 24) {
                    //code specific to first list item
                    Intent myIntent = new Intent(language.this, Welsh.class);
                    startActivity(myIntent);


                }
            }
        });
    }
}
