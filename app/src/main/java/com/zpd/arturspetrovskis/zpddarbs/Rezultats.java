package com.zpd.arturspetrovskis.zpddarbs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;





public class Rezultats extends AppCompatActivity {

    public Bundle b;

    public RecyclerView  rv;

    private List<JautajumuCardView> jautajumulist;

    public CardView cardView;
    public CardView atbilde;

    private int[] jautajums;
    private int pareizasAtbildes = 0;
    private int nepareizasAtbildes = 0;
    public int size = 0;
    private TextView procenti;
    private TextView pAtbildes;
    private TextView nAtbildes;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private DrawerLayout dlDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nvDrawer;
    private ArrayAdapter<String> arrayAdapter = null;

    public FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultats);


        b = new Bundle();
        b = this.getIntent().getExtras();
        String x = "jautajumsarray";
        jautajums = b.getIntArray(x);

        fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.show();

        for(int i = 1;i < jautajums.length;i++){
            if(jautajums[i] == 1) {
                pareizasAtbildes += 1;
                size+=1;
            }
            else if (jautajums[i] == 2) {
                nepareizasAtbildes += 1;
                size+=1;
            }

        }

      //  ButtonTintColor();
        //

  /*      procenti = (TextView) findViewById(R.id.procenti);
        pAtbildes = (TextView) findViewById(R.id.pareizasAtbildes);
        nAtbildes = (TextView) findViewById(R.id.nepareizaAtbilde);

        for(int i = 0;i < jautajums.length;i++){
            if(jautajums[i] == 1)
                pareizasAtbildes+=1;
            else if (jautajums[i] == 2)
                nepareizasAtbildes+=1;

        }

        pAtbildes.setText("PAREIZĀS ATBILDES "+pareizasAtbildes);
        nAtbildes.setText("NEPAREIZĀS ATBILDES "+nepareizasAtbildes);

        Double procents = (Double.valueOf(pareizasAtbildes)/15)*100;
        DecimalFormat df = new DecimalFormat("#.00");
       procenti.setText(df.format(procents) + "%");*/

        cardView = (CardView) findViewById(R.id.card_view);
        atbilde = (CardView) findViewById(R.id.atbilde);

        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

      //  initializeData();
       // initializeData2();

  /*      RVAdapter adapter = new RVAdapter(atbildes);
        RVAdapter2 adapter2 = new RVAdapter2(procentiCard);*/

        cardArrayList();


        rv.setAdapter(new ComplexRecyclerViewAdapter(cardArrayList()));








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
finish();

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
        getMenuInflater().inflate(R.menu.menu_rezultats, menu);
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








    class JautajumuCardView {
        String title = new String();
        String jautajumstext = new String();
        String pareizaAtbilde = new String();

        JautajumuCardView(String title, String jautajumstext, String pareizaAtbilde) {
            this.title = title;
            this.jautajumstext = jautajumstext;
            this.pareizaAtbilde = pareizaAtbilde;
        }
    }



    class ProcentiCardView {
        String procenti = new String();
        String pareizasatbildes = new String();
        String nepareizasatbildes = new String();

        ProcentiCardView(String procenti, String pareizasatbildes, String nepareizasatbildes) {
            this.procenti = procenti;
            this.pareizasatbildes = pareizasatbildes;
            this.nepareizasatbildes = nepareizasatbildes;
        }
    }


    private ArrayList<Object> cardArrayList() {
        ArrayList<Object> items = new ArrayList<>();



        String procenti = new String();
        String pareizasatbildes = new String();
        String nepareizasatbildes = new String();

        String  whatstring = new String();





        pareizasatbildes = ("PAREIZĀS ATBILDES "+pareizasAtbildes);
        nepareizasatbildes = ("NEPAREIZĀS ATBILDES "+nepareizasAtbildes);

        if(String.valueOf(pareizasAtbildes).contains("0") ){
            procenti = ("0" + "%");
        }else {

            Double procents = (Double.valueOf(pareizasAtbildes) / size) * 100;
            DecimalFormat df = new DecimalFormat("#.00");
            procenti = (df.format(procents) + "%");

        }


        items.add(new ProcentiCardView(procenti,pareizasatbildes,nepareizasatbildes));

        String  title = new String();
        String jautajumstext = new String();
        String pareizaAtbilde = new String();






        for(int i = 1;i < jautajums.length;i++) {
            if (jautajums[i] == 1 || jautajums[i] == 2) {
                if (jautajums[i] == 1) {
                    title = "PAREIZĀ ATBILDE";
                } else if (jautajums[i] == 2) {
                    title = "NEPAREIZĀ ATBILDE";
                }

                whatstring = ("a" + i + "p" + 0);
                jautajumstext = getStringResourceByName(whatstring);

                whatstring = ("a" + i + "p" + 4);

                if (getStringResourceByName(whatstring).contains("1")) {
                    whatstring = ("a" + i + "p" + 1);
                    pareizaAtbilde = getStringResourceByName(whatstring);
                } else if (getStringResourceByName(whatstring).contains("2")) {
                    whatstring = ("a" + i + "p" + 2);
                    pareizaAtbilde = getStringResourceByName(whatstring);
                } else if (getStringResourceByName(whatstring).contains("3")) {
                    whatstring = ("a" + i + "p" + 3);
                    pareizaAtbilde = getStringResourceByName(whatstring);
                }

                items.add(new JautajumuCardView(title, jautajumstext, pareizaAtbilde));

            }
            }



        return items;
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private TextView procenti, pareizasatbildes,nepareizasatbildes;

        public ViewHolder1(View v) {
            super(v);
            procenti = (TextView) v.findViewById(R.id.procenti);
            pareizasatbildes = (TextView) v.findViewById(R.id.pareizasAtbildes);
            nepareizasatbildes = (TextView) v.findViewById(R.id.nepareizaAtbilde);
        }

        public TextView procenti() {
            return procenti;
        }

        public void setProcenti(TextView procenti) {
            this.procenti = procenti;
        }

        public TextView pareizasatbildes() {
            return pareizasatbildes;
        }

        public void setpareizasatbildes(TextView pareizasatbildes) {
            this.pareizasatbildes = pareizasatbildes;
        }

        public TextView nepareizasatbildes() {
            return nepareizasatbildes;
        }

        public void setnepareizasatbildes(TextView nepareizasatbildes) {
            this.nepareizasatbildes = nepareizasatbildes;
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private TextView title, jautajumatext,pareizaatbildespoga;

        public ViewHolder2(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title);
            jautajumatext = (TextView) v.findViewById(R.id.jautajumstext);
            pareizaatbildespoga = (TextView) v.findViewById(R.id.istaatbilde);
        }

        public TextView title() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public TextView jautajumatext() {
            return jautajumatext;
        }

        public void setjautajumatext(TextView jautajumatext) {
            this.jautajumatext = jautajumatext;
        }

        public TextView pareizaatbildespoga() {
            return pareizaatbildespoga;
        }

        public void setpareizaatbildespoga(TextView pareizaatbildespoga) {
            this.pareizaatbildespoga = pareizaatbildespoga;
        }
    }

    public class ComplexRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        // The items to display in your RecyclerView

        private List<Object> items;

        private final int jautajums = 0, procenti = 1;

        // Provide a suitable constructor (depends on the kind of dataset)
        public ComplexRecyclerViewAdapter(List<Object> items) {
            this.items = items;
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return this.items.size();
        }



        @Override
        public int getItemViewType(int position) {
            if (items.get(position) instanceof JautajumuCardView) {
                return jautajums;
            } else if (items.get(position) instanceof ProcentiCardView) {
                return procenti;
            }
            return -1;
        }


        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            switch (viewHolder.getItemViewType()) {
                case procenti:
                    ViewHolder1 vh1 = (ViewHolder1) viewHolder;

                    ProcentiCardView procentiCardView = (ProcentiCardView) items.get(position);

                    vh1.procenti().setText(procentiCardView.procenti);
                    vh1.pareizasatbildes().setText(procentiCardView.pareizasatbildes);
                    vh1.nepareizasatbildes().setText(procentiCardView.nepareizasatbildes);

                    break;
                case jautajums:
                    ViewHolder2 vh2 = (ViewHolder2) viewHolder;

                    JautajumuCardView jautajumuCardView = (JautajumuCardView) items.get(position);
                    vh2.title().setText(jautajumuCardView.title);
                    vh2.jautajumatext().setText(jautajumuCardView.jautajumstext);
                    vh2.pareizaatbildespoga().setText(jautajumuCardView.pareizaAtbilde);

                    break;
            }
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

            RecyclerView.ViewHolder viewHolder;
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

            switch (viewType) {
                case procenti:
                    View v1 = inflater.inflate(R.layout.card_procenti, viewGroup, false);
                    viewHolder = new ViewHolder1(v1);
                    break;
                case jautajums:
                    View v2 = inflater.inflate(R.layout.card_atbildes, viewGroup, false);
                    viewHolder = new ViewHolder2(v2);
                    break;
                default:
                    View v = inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
                    viewHolder = new RecyclerView.ViewHolder(v) {
                    };
                    break;
            }
            return viewHolder;
        }

    }

public void fabPressed(View view){
    NavUtils.navigateUpFromSameTask(this);
    finish();
}

}

