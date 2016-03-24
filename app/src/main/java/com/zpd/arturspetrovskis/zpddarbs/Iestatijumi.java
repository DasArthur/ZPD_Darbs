package com.zpd.arturspetrovskis.zpddarbs;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Iestatijumi extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private DrawerLayout dlDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nvDrawer;
    private TextView pirmaAtsauce;
    private TextView otraAtsauce;
    private TextView tresaAtsauce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iestatijumi);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /// Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        /// Setup drawer view
        setupDrawerContent(nvDrawer);


        // Set the menu icon instead of the launcher icon.
        final ActionBar ab = getSupportActionBar();


        ab.setDisplayHomeAsUpEnabled(true);



    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }
    /////////////////WHEN YOU PRESS ON ITEMS IN NAVIGATION DRAWER////////////////////////////////////////////////////////////////////////////////////////////////
    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the planet to show based on
        // position

        switch(menuItem.getItemId()) {
            case R.id.izvelne:
                NavUtils.navigateUpFromSameTask(this);
                break;
            case R.id.iestatijumi:

                break;

            case R.id.exit:
                this.finishAffinity();

                break;
            default:

                break;

        }



        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        mDrawer.closeDrawers();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tests_izvelne, menu);
        return true;
    }

    /////////////////////WHEN YOU PRESS ON TOOLBAR/////////////////////////////////////////////////////////////////
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.testspoga:

                return true;
        }

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }




        return super.onOptionsItemSelected(item);




    }
}
