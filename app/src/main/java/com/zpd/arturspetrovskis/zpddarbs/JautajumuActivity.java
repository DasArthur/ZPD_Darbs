package com.zpd.arturspetrovskis.zpddarbs;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
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
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class JautajumuActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE = "com.zpd.arturspetrovskis.zpddarbs.TYPE";

    public   Random r = new Random();
    ///////////////////DISABLE BUTTON//////////////////////////////////////////
    boolean isVisible = false;
    ////////////////////KRASAS////////////////////////////////////////////
    ColorStateList csl;
    ColorStateList csl2;
    /////////////KURS JAUTAJUMS//////////////////////////////////////////
    public int[] jautajums = new int[51];
    public int RandomJautajums = 1;
    public int jautajumuSkaits = 0;
    public int temasJautajums = 1;
    public int temata1JautajumuSkaits = 0;
    public int temata2JautajumuSkaits = 0;
    public int temata3JautajumuSkaits = 0;
    public int temata4JautajumuSkaits = 0;
    public int temata5JautajumuSkaits = 0;
    public int temata6JautajumuSkaits = 0;
    //////////////KURA PAREIZA ATBILDE//////////////////////////////////////////////////////////
    public int pareizaAtbilde = 0;
    public String paskaidrojums = "jam";

    //////////APALA POGA////////////////////////////////////////////////////
    FloatingActionButton fab;


    /////////////////TESTS UN ARI TA APAKSKATEGORIJAS VAI PARBAUDES DARBS/////////////////////////////
    String type;


    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private DrawerLayout dlDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nvDrawer;

    private Button pirmaPoga;
    private Button otraPoga;
    private Button tresaPoga;
    private TextView jautajumsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jautajumu);


        Intent intent = getIntent();
        type = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        if(type == null){
            type = intent.getStringExtra(TestsIzvelne.EXTRA_MESSAGE);
        }


        if(type.contains("1"))
            setTitle("Tests");
        else if(type.contains("2"))
            setTitle("Pārbaudes darbs");
        else if(type.contains("3"))
            setTitle(R.string.tema_1);
        else if(type.contains("4"))
            setTitle(R.string.tema_2);
        else if(type.contains("5"))
            setTitle(R.string.tema_3);
        else if(type.contains("6"))
            setTitle(R.string.tema_5);
        else if(type.contains("7"))
            setTitle(R.string.tema_6);
        else if(type.contains("8"))
            setTitle(R.string.tema_7);


        skaits("1");
        skaits("2");
        skaits("3");
        skaits("4");
        skaits("5");
        skaits("6");

        ////PASLEP POGU APALO////////////////////////////////////////////
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.hide();
        ////////////UZLIEK KA TINT POGAS STRADA ANDROID API < 21////////////////////
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

        ///////UZLIEK POGAS UN TEXT VIEW///////////////////////////////////////
        pirmaPoga = (Button) findViewById(R.id.pirmapoga);
        otraPoga = (Button) findViewById(R.id.otrapoga);
        tresaPoga = (Button) findViewById(R.id.tresapoga);
        jautajumsText = (TextView) findViewById(R.id.TextFieldJautajums);

        ////////////////////UZLIEK KA VISI JAUTAJUMI IR 0//////////////////////////////////////////////
        for(int  i = 0;i > jautajums.length;i++)
            jautajums[i] = 0;

        //UZLIEK KA JAUTAJUMS 0 ir 1, jo jautajumi sakas no 1///

        jautajums[0] = 1;
        ////////////TESTS//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(type.contains("1"))
            setJautajums();
        else if(type.contains("2"))
            setParbaudesDarbs();
        else if(type.contains("3"))
            setTema1();
        else if(type.contains("4"))
            setTema2();
        else if(type.contains("5"))
            setTema3();
        else if(type.contains("6"))
            setTema4();
        else if(type.contains("7"))
            setTema5();
        else if(type.contains("8"))
            setTema6();


    }

    public void skaits(String type){
        for(int i = 1; i < jautajums.length;i++) {

            temasJautajums = i;
            String whatstring = ("a" + i + "p" + 6);
            if(getStringResourceByName(whatstring).contains(type)){
                if(type.contains("1")){
                    temata1JautajumuSkaits+=1;
                }else if (type.contains("2")){
                    temata2JautajumuSkaits+=1;
                }else if (type.contains("3")){
                    temata3JautajumuSkaits+=1;
                }
                else if (type.contains("4")){
                    temata4JautajumuSkaits+=1;
                }
                else if (type.contains("5")){
                    temata5JautajumuSkaits+=1;
                    System.out.println(temata6JautajumuSkaits);
                }
                else if (type.contains("6")){
                    temata6JautajumuSkaits+=1;

                }



            }

        }
    }

    public void TemaExample(String type) {
        for(int i = 1; i < jautajums.length;i++){
            if(jautajums[i] == 0) {
                temasJautajums = i;
                String whatstring = ("a" + i + "p" + 6);

                if (getStringResourceByName(whatstring).contains(type)) {


                    if(type.contains("1")){
                        temata1JautajumuSkaits-=1;
                    }else if (type.contains("2")){
                        temata2JautajumuSkaits-=1;
                    }else if (type.contains("3")){
                        temata3JautajumuSkaits-=1;
                    }else if (type.contains("4")){
                        temata4JautajumuSkaits-=1;
                    }else if (type.contains("5")){
                        temata5JautajumuSkaits-=1;
                    }else if (type.contains("6")){
                        temata6JautajumuSkaits-=1;
                    }



                    for (int c = 0; c < 5; c++) {


                        whatstring = ("a" + i + "p" + c);
                        //jautajumsText.setText(getStringResourceByName(whatstring)); //TEST
                        if (c == 0)
                            jautajumsText.setText(Html.fromHtml(getStringResourceByName(whatstring))); //TEST
                        else if (c == 1)
                            pirmaPoga.setText(getStringResourceByName(whatstring));
                        else if (c == 2)
                            otraPoga.setText(getStringResourceByName(whatstring));
                        else if (c == 3)
                            tresaPoga.setText(getStringResourceByName(whatstring));
                        else if (c == 4) {
                            String sint = getStringResourceByName(whatstring);
                            pareizaAtbilde = Integer.parseInt(sint);
                        } else if (c == 5) {
                            paskaidrojums = getStringResourceByName(whatstring);
                        }

                    }
                    break;
                }
            }

        }
    }
    public void setTema1() {
        TemaExample("1");
    }

    public void setTema2() {
        TemaExample("2");
    }
    public void setTema3() {
        TemaExample("3");
    }
    public void setTema4() {
        TemaExample("4");
    }
    public void setTema5() {
        TemaExample("5");
    }
    public void setTema6() {
        TemaExample("6");
    }

    //////////////////UZLIEK KA RIPPLE EFFECT STRADA ARI UZ < 21 API ANDROID//////////////////////////////////////////////////////////////////
    private void ButtonTintColor(){
        AppCompatButton v = (AppCompatButton) findViewById(R.id.pirmapoga);
        csl = new ColorStateList(
                new int[][]
                        {new int[0]}
                , new int[]{ getResources().getColor(R.color.colorButton)

        });

        csl2 = new ColorStateList(
                new int[][]
                        {new int[0]}
                , new int[]{ getResources().getColor(R.color.colorButton2)

        });

        v.setSupportBackgroundTintList(csl);

        AppCompatButton v2 = (AppCompatButton) findViewById(R.id.otrapoga);
        v2.setSupportBackgroundTintList(csl);

        AppCompatButton v3 = (AppCompatButton) findViewById(R.id.tresapoga);
        v3.setSupportBackgroundTintList(csl);
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
                startActivity(new Intent(this,MainActivity.class));
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



    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, dlDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jautajumu, menu);
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
            case R.id.action_draw:
                startActivity(new Intent(this,DrawActivity.class));
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
        startActivity(new Intent(this, TestsIzvelne.class));

    }

    ///////////////////KAD PARBAUDES DARBA POGA NOSPIESTA///////////////////////////////////////////////////////////////////////////////////////////////
    public void ParbaudesDarbsPressed(View view){
        startActivity(new Intent(this, TestsIzvelne.class));

    }
    //////////////////////////PARBAUDES DARBS//////////////////////////////////////////////////////////////////////////////////////
    private void setParbaudesDarbs() {
        if(jautajumuSkaits == 25){
            Bundle b= new Bundle();
            String x = "jautajumsarray";
            b.putIntArray(x, jautajums);
            Intent i = new Intent(getApplicationContext(),Rezultats.class);
            i.putExtras(b);
            startActivity(i);
            finish();
        }else {

            RandomJautajums = r.nextInt(jautajums.length - 1) + 1;
            jautajumuSkaits += 1;
            while (jautajums[RandomJautajums] == 1 || jautajums[RandomJautajums] == 2) {
                RandomJautajums = r.nextInt(jautajums.length - 1) + 1;
            }
            for (int c = 0; c < 5; c++) {
                String whatstring = ("a" + RandomJautajums + "p" + c);
                if (c == 0)
                    jautajumsText.setText(getStringResourceByName(whatstring));
                else if (c == 1)
                    pirmaPoga.setText(getStringResourceByName(whatstring));
                else if (c == 2)
                    otraPoga.setText(getStringResourceByName(whatstring));
                else if (c == 3)
                    tresaPoga.setText(getStringResourceByName(whatstring));
                else if (c == 4) {
                    String sint = getStringResourceByName(whatstring);
                    pareizaAtbilde = Integer.parseInt(sint);
                } else if (c == 5) {
                    paskaidrojums = getStringResourceByName(whatstring);
                }
            }

        }

    }

    /////////////////TESTS/////////////////////////////////////////////////////////////////////////////////////////
    public void setJautajums(){



        for(int i = 1; i < jautajums.length;i++){
            if(jautajums[i] == 0) {
                for (int c = 0; c < 5; c++) {

                    String whatstring = ("a"+i+"p"+c);

                    if(c == 0)
                        jautajumsText.setText(getStringResourceByName(whatstring));
                    else if (c == 1)
                        pirmaPoga.setText(getStringResourceByName(whatstring));
                    else if (c == 2)
                        otraPoga.setText(getStringResourceByName(whatstring));
                    else if (c == 3)
                        tresaPoga.setText(getStringResourceByName(whatstring));
                    else if (c == 4){
                        String sint = getStringResourceByName(whatstring);
                        pareizaAtbilde = Integer.parseInt(sint);
                    }else if (c == 5){
                        paskaidrojums = getStringResourceByName(whatstring);
                    }

                }
                break;
            }
        }


    }
    ///////////////////////ATROD STRING PARAMETRU////////////////////////////////////////////////////////////////////////////////////////////
    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        if (resId == 0) {
            return aString;
        } else {
            return getString(resId);
        }
    }
    //////////////////////////////JA NAV PAREIZA ATBILDE NOSPIESTA//////////////////////////////////////////////////////////////////////////////////////////////////
    public void jaNavTaPoga(){
        if(type.contains("1")) {
            for (int i = 1; i < jautajums.length; i++) {
                if (jautajums[i] == 0) {
                    jautajums[i] = 2;

                    if (type.contains("1")) {
                        fab.show();
                        isVisible = true;
                        String whatstring = ("a" + i + "p" + 5);
                        jautajumsText.setText(getStringResourceByName(whatstring));
                    }

                    if (pareizaAtbilde == 1) {
                        AppCompatButton v = (AppCompatButton) findViewById(R.id.pirmapoga);
                        v.setSupportBackgroundTintList(csl2);
                    } else if (pareizaAtbilde == 2) {
                        AppCompatButton v2 = (AppCompatButton) findViewById(R.id.otrapoga);
                        v2.setSupportBackgroundTintList(csl2);
                    } else if (pareizaAtbilde == 3) {
                        AppCompatButton v3 = (AppCompatButton) findViewById(R.id.tresapoga);
                        v3.setSupportBackgroundTintList(csl2);
                    }

                    break;
                }
            }
        }
    }


    ////////////////////////PIRMA POGA PRESSED//////////////////////////////////////////////////////////////////////////////////////
    public void pirmapogaPressed(View view){
        if(type.contains("1")) {
            if (isVisible == false) {
                if (pareizaAtbilde == 1) {
                    for (int i = 1; i < jautajums.length; i++) {
                        if (jautajums[i] == 0) {
                            jautajums[i] = 1;

                            if (type.contains("1")) {
                                fab.show();
                                isVisible = true;
                                String whatstring = ("a" + i + "p" + 5);
                                jautajumsText.setText(getStringResourceByName(whatstring));
                            }

                            AppCompatButton v = (AppCompatButton) findViewById(R.id.pirmapoga);
                            v.setSupportBackgroundTintList(csl2);


                            break;
                        }
                    }
                } else {
                    jaNavTaPoga();

                }
            }
        }else if(type.contains("2")){
            if (pareizaAtbilde == 1) {
                jautajums[RandomJautajums] = 1;
                setParbaudesDarbs();

            } else {
                jaNavTaPoga();
                jautajums[RandomJautajums] = 2;
                setParbaudesDarbs();
            }
        }else if(type.contains("3")||type.contains("4")||type.contains("5")||type.contains("6")||type.contains("7")||type.contains("8")){
            if (pareizaAtbilde == 1) {

                jautajums[temasJautajums] = 1;
                fab.show();
                isVisible = true;
                String whatstring = ("a" + temasJautajums + "p" + 5);
                jautajumsText.setText(getStringResourceByName(whatstring));


                AppCompatButton v = (AppCompatButton) findViewById(R.id.pirmapoga);
                v.setSupportBackgroundTintList(csl2);




            } else {
                jautajums[temasJautajums] = 2;
                fab.show();
                isVisible = true;
                String whatstring = ("a" + temasJautajums + "p" + 5);
                jautajumsText.setText(getStringResourceByName(whatstring));


                if (pareizaAtbilde == 1) {
                    AppCompatButton v = (AppCompatButton) findViewById(R.id.pirmapoga);
                    v.setSupportBackgroundTintList(csl2);
                } else if (pareizaAtbilde == 2) {
                    AppCompatButton v2 = (AppCompatButton) findViewById(R.id.otrapoga);
                    v2.setSupportBackgroundTintList(csl2);
                } else if (pareizaAtbilde == 3) {
                    AppCompatButton v3 = (AppCompatButton) findViewById(R.id.tresapoga);
                    v3.setSupportBackgroundTintList(csl2);
                }
            }
        }
    }
    ////////////////////////OTRA POGA PRESSED//////////////////////////////////////////////////////////////////////////////////////
    public void otrapogaPressed(View view){
        if(type.contains("1")) {
            if (isVisible == false) {
                if (pareizaAtbilde == 2) {
                    for (int i = 1; i < jautajums.length; i++) {
                        if (jautajums[i] == 0) {
                            jautajums[i] = 1;

                            if (type.contains("1")) {
                                fab.show();
                                isVisible = true;
                                String whatstring = ("a" + i + "p" + 5);
                                jautajumsText.setText(getStringResourceByName(whatstring));
                            }

                            AppCompatButton v = (AppCompatButton) findViewById(R.id.otrapoga);
                            v.setSupportBackgroundTintList(csl2);


                            break;
                        }
                    }
                } else {
                    jaNavTaPoga();

                }
            }
        }else if(type.contains("2")){
            if (pareizaAtbilde == 2) {
                jautajums[RandomJautajums] = 1;
                setParbaudesDarbs();

            } else {
                jaNavTaPoga();
                jautajums[RandomJautajums] = 2;
                setParbaudesDarbs();
            }
        }else if(type.contains("3")||type.contains("4")||type.contains("5")||type.contains("6")||type.contains("7")||type.contains("8")){
            if (pareizaAtbilde == 2) {

                jautajums[temasJautajums] = 1;
                fab.show();
                isVisible = true;
                String whatstring = ("a" + temasJautajums + "p" + 5);
                jautajumsText.setText(getStringResourceByName(whatstring));


                AppCompatButton v = (AppCompatButton) findViewById(R.id.otrapoga);
                v.setSupportBackgroundTintList(csl2);




            } else {
                jautajums[temasJautajums] = 2;
                fab.show();
                isVisible = true;
                String whatstring = ("a" + temasJautajums + "p" + 5);
                jautajumsText.setText(getStringResourceByName(whatstring));


                if (pareizaAtbilde == 1) {
                    AppCompatButton v = (AppCompatButton) findViewById(R.id.pirmapoga);
                    v.setSupportBackgroundTintList(csl2);
                } else if (pareizaAtbilde == 2) {
                    AppCompatButton v2 = (AppCompatButton) findViewById(R.id.otrapoga);
                    v2.setSupportBackgroundTintList(csl2);
                } else if (pareizaAtbilde == 3) {
                    AppCompatButton v3 = (AppCompatButton) findViewById(R.id.tresapoga);
                    v3.setSupportBackgroundTintList(csl2);
                }
            }
        }
    }
    ////////////////////////TRESA POGA PRESSED//////////////////////////////////////////////////////////////////////////////////////
    public void tresapogaPressed(View view) {
        if(type.contains("1")) {
            if (isVisible == false) {
                if (pareizaAtbilde == 3) {
                    for (int i = 1; i < jautajums.length; i++) {
                        if (jautajums[i] == 0) {
                            jautajums[i] = 1;

                            if (type.contains("1")) {
                                fab.show();
                                isVisible = true;
                                String whatstring = ("a" + i + "p" + 5);
                                jautajumsText.setText(getStringResourceByName(whatstring));
                            }

                            AppCompatButton v = (AppCompatButton) findViewById(R.id.tresapoga);
                            v.setSupportBackgroundTintList(csl2);


                            break;
                        }
                    }
                } else {
                    jaNavTaPoga();

                }
            }
        }else if(type.contains("2")){
            if (pareizaAtbilde == 3) {
                jautajums[RandomJautajums] = 1;
                setParbaudesDarbs();

            } else {
                jaNavTaPoga();
                jautajums[RandomJautajums] = 2;
                setParbaudesDarbs();
            }
        }else if(type.contains("3")||type.contains("4")||type.contains("5")||type.contains("6")||type.contains("7")||type.contains("8")){
            if (pareizaAtbilde == 3) {

                jautajums[temasJautajums] = 1;
                fab.show();
                isVisible = true;
                String whatstring = ("a" + temasJautajums + "p" + 5);
                jautajumsText.setText(getStringResourceByName(whatstring));


                AppCompatButton v = (AppCompatButton) findViewById(R.id.tresapoga);
                v.setSupportBackgroundTintList(csl2);




            } else {
                jautajums[temasJautajums] = 2;
                fab.show();
                isVisible = true;
                String whatstring = ("a" + temasJautajums + "p" + 5);
                jautajumsText.setText(getStringResourceByName(whatstring));


                if (pareizaAtbilde == 1) {
                    AppCompatButton v = (AppCompatButton) findViewById(R.id.pirmapoga);
                    v.setSupportBackgroundTintList(csl2);
                } else if (pareizaAtbilde == 2) {
                    AppCompatButton v2 = (AppCompatButton) findViewById(R.id.otrapoga);
                    v2.setSupportBackgroundTintList(csl2);
                } else if (pareizaAtbilde == 3) {
                    AppCompatButton v3 = (AppCompatButton) findViewById(R.id.tresapoga);
                    v3.setSupportBackgroundTintList(csl2);
                }
            }
        }
    }
    ////////////////////////FAB POGA PRESSED//////////////////////////////////////////////////////////////////////////////////////
    public void fabPressed(View view){
        if(type.contains("3"))
            setTema1();
        else if(type.contains("4")){
            setTema2();
        }else if(type.contains("5")){
            setTema3();
        }else if(type.contains("6")){
            setTema4();
        }else if(type.contains("7")){
            setTema5();
        }else if(type.contains("8")){
            setTema6();
        }else if(type.contains("1")) {
            setJautajums();
        }
        AppCompatButton v = (AppCompatButton) findViewById(R.id.pirmapoga);
        v.setSupportBackgroundTintList(csl);

        AppCompatButton v1 = (AppCompatButton) findViewById(R.id.otrapoga);
        v1.setSupportBackgroundTintList(csl);

        AppCompatButton v2 = (AppCompatButton) findViewById(R.id.tresapoga);
        v2.setSupportBackgroundTintList(csl);

        fab.hide();
        isVisible = false;
        int all = 0;

        if(type.contains("1")) {

            for (int i = 1; i < jautajums.length; i++) {
                if (jautajums[i] == 0) {
                    all = 2;

                } else {
                    all = 1;

                }
            }
        }  else  if(type.contains("3")){



                if (temata1JautajumuSkaits > 0) {
                    all = 2;

                } else {
                    all = 1;

                }



        } else  if(type.contains("4")){



                if (temata2JautajumuSkaits > 0) {
                    all = 2;

                } else {
                    all = 1;

                }


        } else  if(type.contains("5")){



                if (temata3JautajumuSkaits > 0) {
                    all = 2;

                } else {
                    all = 1;

                }


        }else  if(type.contains("6")){



                if (temata4JautajumuSkaits > 0) {
                    all = 2;

                } else {
                    all = 1;

                }


        }else  if(type.contains("7")){



                if (temata5JautajumuSkaits > 0) {
                    all = 2;

                } else {
                    all = 1;

                }


        }else  if(type.contains("8")){


                if (temata6JautajumuSkaits > 0) {
                    all = 2;

                } else {
                    all = 1;

                }


        }

        if(all == 1 ){
            Bundle b= new Bundle();
            String x = "jautajumsarray";
            b.putIntArray(x, jautajums);
            Intent i=new Intent(getApplicationContext(), Rezultats.class);
            i.putExtras(b);
            startActivity(i);
            finish();

        }
    }
}