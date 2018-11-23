package com.iteso.proyectomoviles;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class ActivityMain extends AppCompatActivity {

    private DrawerLayout drawer;
    private Spinner sp;
    private String [] games = {"Lol", "Dota"};
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                    new FragmentLolHome()).commit();
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
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
            new FragmentLolHome()).commit();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        if (id == R.id.action_logout_pref) {
            if (isLoggedIn) {
                Toast notThisLogout = Toast.makeText(ActivityMain.this, "Usa el Log out de Facebook",

                        Toast.LENGTH_SHORT);
                notThisLogout.show();
            } else {
                Intent intent = new Intent(ActivityMain.this, ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        } else if (id == R.id.action_logout_face) {
            if (isLoggedIn) {
                LoginManager.getInstance().logOut();
                Intent intent = new Intent(ActivityMain.this, ActivityLogin.class);
                startActivity(intent);
                finish();
            } else {
                Toast notThisLogout = Toast.makeText(ActivityMain.this, "Usa el Log out normal",

                        Toast.LENGTH_SHORT);
                notThisLogout.show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
