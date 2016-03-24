package com.zpd.arturspetrovskis.zpddarbs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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



public class MainActivity extends AppCompatActivity {

    ////////////STRING KURS SATUR KO LIETOTAJS IR IZVELEJIES////////////////////
    public final static String EXTRA_MESSAGE = "com.zpd.arturspetrovskis.zpddarbs.TYPE";

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
  private DrawerLayout dlDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nvDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButtonTintColor();
        //





        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);


        // Set the menu icon instead of the launcher icon.
        final ActionBar ab = getSupportActionBar();

        ab.setHomeAsUpIndicator(R.drawable.ic_menu_bars);
        ab.setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();


        // Tie DrawerLayout events to the ActionBarToggle
        dlDrawer.setDrawerListener(drawerToggle);




    }

    //////////////////UZLIEK KA RIPPLE EFFECT STRADA ARI UZ < 21 API ANDROID//////////////////////////////////////////////////////////////////
    private void ButtonTintColor(){
        @SuppressLint("WrongViewCast")     AppCompatButton v = (AppCompatButton) findViewById(R.id.testspoga);
        ColorStateList csl = new ColorStateList(
                new int[][]
                        {new int[0]}
                , new int[]{ getResources().getColor(R.color.colorButton)

        });
        v.setSupportBackgroundTintList(csl);

        @SuppressLint("WrongViewCast")   AppCompatButton v2 = (AppCompatButton) findViewById(R.id.parbaudesdarbspoga);
        v2.setSupportBackgroundTintList(csl);
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
    @SuppressLint("NewApi")
    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the planet to show based on
        // position

        switch(menuItem.getItemId()) {
            case R.id.izvelne:

                break;
            case R.id.iestatijumi:
startActivity(new Intent(this,Iestatijumi.class));
                break;

            case R.id.exit:
                this.finishAffinity();

                break;
            default:
     //       fragmentClass  = izvelneFragment.class;
                break;

        }



        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        mDrawer.closeDrawers();
    }



    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, dlDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        if (drawerToggle.onOptionsItemSelected(item)) {
            startActivity(new Intent(this,TestsIzvelne.class));
            return true;
        }




        return super.onOptionsItemSelected(item);




    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }
//////////////////KAD TESTA POGA NOSPIESTA///////////////////////////////////////////////////////////////////////////////////////////////////////
    public void TestsPressed(View view){

        startActivity(new Intent(this,TestsIzvelne.class));
    }

///////////////////KAD PARBAUDES DARBA POGA NOSPIESTA///////////////////////////////////////////////////////////////////////////////////////////////
    public void ParbaudesDarbsPressed(View view){
       Intent intent = new Intent(this,JautajumuActivity.class);
        intent.putExtra(EXTRA_MESSAGE,"2");
        startActivity(intent);
    }

}
