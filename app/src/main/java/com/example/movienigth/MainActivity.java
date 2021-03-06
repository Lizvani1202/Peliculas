package com.example.movienigth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.movienigth.Fragments.ListClientFragment;
import com.example.movienigth.Main.MainEditClientActivity;
import com.example.movienigth.Main.MainProductoActivity;
import com.example.movienigth.Main.MainRegisterClientActivity;
import com.example.movienigth.SQLite.AdminDataBase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements  NavigationView.OnNavigationItemSelectedListener,
                    ListClientFragment.OnFragmentInteractionListener {

    ListClientFragment listClientFragment;
    public static AdminDataBase adminDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adminDataBase = new AdminDataBase(this,"BD",null,10);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.contenedorMain);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        listClientFragment = new ListClientFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.contenedorMain);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_register_video) {

            Intent intent = new Intent(MainActivity.this, MainProductoActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_register_new_copies) {

        } else if (id == R.id.nav_delete_video) {

        } else if (id == R.id.nav_register_client) {
            Intent intent = new Intent(MainActivity.this, MainRegisterClientActivity.class);
            startActivity(intent);

        } else if(id == R.id.nav_edit_client){
            Intent intent = new Intent(MainActivity.this, MainEditClientActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_lend_video){

        }else if(id == R.id.nav_list_client){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.contenedorMain,listClientFragment);
            ft.commit();

        }

        DrawerLayout drawer = findViewById(R.id.contenedorMain);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
