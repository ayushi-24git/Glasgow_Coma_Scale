package com.example.aarnarratta.glasgowcomascale.AccountActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.aarnarratta.glasgowcomascale.Main3Activity;
import com.example.aarnarratta.glasgowcomascale.R;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_login) {
            Intent i3 = new Intent(Main2Activity.this,Main3Activity.class);
            startActivity(i3);
        }
        else if(id==R.id.nav_reset)
        {
            Intent reset=new Intent(Main2Activity.this,com.example.aarnarratta.glasgowcomascale.AccountActivity.ResetPasswordActivity.class);
            startActivity(reset);
        }



       else if (id == R.id.nav_gallery) {
            Intent gallery = new Intent(Main2Activity.this, com.example.aarnarratta.glasgowcomascale.AccountActivity.gallery.class);
            startActivity(gallery);

        } else if (id == R.id.nav_languages) {
            Intent language = new Intent(Main2Activity.this, com.example.aarnarratta.glasgowcomascale.AccountActivity.language.class);
            startActivity(language);

        } else if (id == R.id.nav_services) {
            Intent Service = new Intent(Main2Activity.this, com.example.aarnarratta.glasgowcomascale.AccountActivity.Service.class);
            startActivity(Service);

        } else if (id == R.id.nav_about) {
            Intent about= new Intent(Main2Activity.this, com.example.aarnarratta.glasgowcomascale.AccountActivity.about.class);
            startActivity(about);

        } else if (id == R.id.nav_team) {
            Intent team= new Intent(Main2Activity.this,com.example.aarnarratta.glasgowcomascale.AccountActivity. team.class);
            startActivity(team);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
