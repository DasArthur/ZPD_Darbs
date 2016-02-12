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

public class TestsIzvelne extends AppCompatActivity {

    ///////////STRING KURS SATUR KO LIETOTAJS IR IZVELEJIES////////////////////
    public static String EXTRA_MESSAGE = "com.zpd.arturspetrovskis.zpddarbs.TYPE";

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private DrawerLayout dlDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nvDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests_izvelne);


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


        ab.setDisplayHomeAsUpEnabled(true);


    }

    //////////////////UZLIEK KA RIPPLE EFFECT STRADA ARI UZ < 21 API ANDROID//////////////////////////////////////////////////////////////////
    private void ButtonTintColor() {
        @SuppressLint("WrongViewCast") AppCompatButton v = (AppCompatButton) findViewById(R.id.tema_1_button);
        ColorStateList csl = new ColorStateList(
                new int[][]
                        {new int[0]}
                , new int[]{getResources().getColor(R.color.colorButton)

        });
        v.setSupportBackgroundTintList(csl);

        @SuppressLint("WrongViewCast")  AppCompatButton v2 = (AppCompatButton) findViewById(R.id.tema_2_button);
        v2.setSupportBackgroundTintList(csl);

        @SuppressLint("WrongViewCast")  AppCompatButton v3 = (AppCompatButton) findViewById(R.id.visastemas);
        v3.setSupportBackgroundTintList(csl);

        @SuppressLint("WrongViewCast")  AppCompatButton v4 = (AppCompatButton) findViewById(R.id.tema_3_button);
        v4.setSupportBackgroundTintList(csl);

        @SuppressLint("WrongViewCast")  AppCompatButton v5 = (AppCompatButton) findViewById(R.id.tema_5_button);
        v5.setSupportBackgroundTintList(csl);

        @SuppressLint("WrongViewCast")  AppCompatButton v6 = (AppCompatButton) findViewById(R.id.tema_6_button);
        v6.setSupportBackgroundTintList(csl);

        @SuppressLint("WrongViewCast")  AppCompatButton v7 = (AppCompatButton) findViewById(R.id.tema_7_button);
        v7.setSupportBackgroundTintList(csl);



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
                NavUtils.navigateUpFromSameTask(this);
                break;
            case R.id.iestatijumi:
                startActivity(new Intent(this,Iestatijumi.class));
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

    public void VisasTemasPressed(View view){
        Intent intent = new Intent(this,JautajumuActivity.class);
        intent.putExtra(EXTRA_MESSAGE,"1");
        startActivity(intent);

    }

    public void tema1Pressed(View view){
        Intent intent = new Intent(this,JautajumuActivity.class);
        intent.putExtra(EXTRA_MESSAGE,"3");
        startActivity(intent);

    }
    public void tema2Pressed(View view){
        Intent intent = new Intent(this,JautajumuActivity.class);
        intent.putExtra(EXTRA_MESSAGE,"4");
        startActivity(intent);

    }
    public void tema3Pressed(View view){
        Intent intent = new Intent(this,JautajumuActivity.class);
        intent.putExtra(EXTRA_MESSAGE,"5");
        startActivity(intent);

    }


    public void tema5Pressed(View View){
        Intent intent = new Intent(this,JautajumuActivity.class);
        intent.putExtra(EXTRA_MESSAGE,"6");
        startActivity(intent);

    }

    public void tema6Pressed(View View){

        Intent intent = new Intent(this,JautajumuActivity.class);
        intent.putExtra(EXTRA_MESSAGE,"7");
        startActivity(intent);
    }

    public void tema7Pressed(View View){
        Intent intent = new Intent(this,JautajumuActivity.class);
        intent.putExtra(EXTRA_MESSAGE,"8");
        startActivity(intent);

    }


}

