package com.apkglobal.gmailfragmentapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.apkglobal.gmailfragmentapp.Fragment.AboutFragment;
import com.apkglobal.gmailfragmentapp.Fragment.CareerFragment;
import com.apkglobal.gmailfragmentapp.Fragment.ContactFragment;
import com.apkglobal.gmailfragmentapp.Fragment.HomeFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //------ To Call default Fragment ------------

        onDefaultselected(R.id.nav_home);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
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
        getMenuInflater().inflate(R.menu.main, menu);
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
    public boolean onNavigationItemSelected(MenuItem item) {

        onDefaultselected(item.getItemId());

        /*// Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_about) {
            Toast.makeText(getApplicationContext(),"ABOUT",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_career) {
            Toast.makeText(getApplicationContext(),"CAREER",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_contact) {
            Toast.makeText(getApplicationContext(),"CONTACT",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);*/
        return true;
    }

    private void onDefaultselected(int itemId) {

        Fragment f = null;

        switch (itemId)
        {
            case R.id.nav_home:
                f = new HomeFragment();
                break;

            case R.id.nav_about:
                f = new AboutFragment();
                break;

            case R.id.nav_career:
                f = new CareerFragment();
                break;

            case R.id.nav_contact:
                f = new ContactFragment();
                break;

        }

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frame,f).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }
}
