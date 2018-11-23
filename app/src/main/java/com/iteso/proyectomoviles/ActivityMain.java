package com.iteso.proyectomoviles;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    private DrawerLayout drawer;
    private Spinner sp;
    private String [] games = {"Lol", "Dota"};
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String iconId = getIntent().getExtras().getString("IconId");
        final String level = getIntent().getExtras().getString("level");
        final String id = getIntent().getExtras().getString("id");
        final String name = getIntent().getExtras().getString("name");

        //spinner = findViewById(R.id.nav_spinner);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        View view = navigationView.getHeaderView(0);
        /*sp = (Spinner) navigationView.getMenu().findItem(R.id.nav_spinner).getActionView();
        sp.setAdapter(new ArrayAdapter<String>(ActivityMain.this, R.layout.spinner_menu, games));*/
        /*sp = view.findViewById(R.id.nav_spinner);
        sp.setAdapter(new ArrayAdapter<String>(ActivityMain.this, R.layout.spinner_menu, games));*/

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        //Intent intent = new Intent(ActivityMain.this, ActivityLolHome.class);
                        //startActivity(intent);

                        FragmentManager manager = getSupportFragmentManager();

                        FragmentTransaction transaction = manager.beginTransaction();

                        FragmentLolHome fHome = new FragmentLolHome();

                        Log.e("INSIDECASE", iconId);

                        Bundle summonerBundle = new Bundle();
                        summonerBundle.putString("IconId", iconId);
                        summonerBundle.putString("level", level);
                        summonerBundle.putString("id", id);
                        summonerBundle.putString("name", name);
                        fHome.setArguments(summonerBundle);
                        transaction.add(R.id.container, fHome);
                        transaction.replace(R.id.container, fHome);
                        transaction.commit();

                        break;
                    case R.id.nav_pros:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                new FragmentLolTeams()).commit();
                        break;
                    case R.id.nav_dota_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                new DotaHome()).commit();
                        break;
                    case R.id.nav_in_game:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                new FragmenInGame()).commit();
                        break;
                    case R.id.nav_history:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                new FragmentLolHistory()).commit();
                    case R.id.nav_dota_history:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                new DotaMatchHistory()).commit();
                        break;
                    case R.id.nav_dota_pors:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                new DotaProTeams()).commit();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null ) {

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            FragmentLolHome fHome = new FragmentLolHome();

            Bundle summonerBundle = new Bundle();
            summonerBundle.putString("IconId", iconId);
            summonerBundle.putString("level", level);
            summonerBundle.putString("id", id);
            summonerBundle.putString("name", name);
            fHome.setArguments(summonerBundle);
            transaction.add(R.id.container, fHome);
            transaction.replace(R.id.container, fHome);
            transaction.commit();

            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}
