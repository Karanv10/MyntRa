package com.jjj.myntra.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.jjj.myntra.Fragments.CartFragment;
import com.jjj.myntra.Fragments.CategoryFragment;
import com.jjj.myntra.Fragments.ExploreFragment;
import com.jjj.myntra.Fragments.HomeFragment;
import com.jjj.myntra.Fragments.Home_blank;
import com.jjj.myntra.Fragments.ProfileFragment;
import com.jjj.myntra.Fragments.ProfileSecFragment;
import com.jjj.myntra.R;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    //Bottom Navigation Bar
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigation);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //getSupportFragmentManager().beginTransaction().add(R.id.container_demo,new HomeFragment()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();

                if (id==R.id.categories){

                    getSupportFragmentManager().beginTransaction().replace(R.id.hide_container,new CategoryFragment()).addToBackStack(null).commit();

                }
                else if(id==R.id.orders){

                    Toast.makeText(MainActivity.this, "Orders", Toast.LENGTH_SHORT).show();

                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

       View headerview = navigationView.getHeaderView(0);
       RelativeLayout header = headerview.findViewById(R.id.relativeLayout);
       header.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

              // getSupportFragmentManager().beginTransaction().replace(R.id.profile_container,new ProfileFragment()).commit();
               Toast.makeText(MainActivity.this, "Go To Login Page", Toast.LENGTH_SHORT).show();
               drawerLayout.closeDrawer(GravityCompat.START);
           }
       });

        SharedPreferences sharedPreferences=getSharedPreferences("session", Context.MODE_PRIVATE);
        String ee=sharedPreferences.getString("email","0");

        //Bottom Navigation Bar
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomnavigationbar);

        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        getSupportFragmentManager().beginTransaction().replace(R.id.karan, new Home_blank()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                  // Fragment temp = null;
                int id=item.getItemId();

                if (id == R.id.mHome)
                {
                    loadfrag(new HomeFragment(),true);
                }

                else  if (id==R.id.mcategories)
                {

                    loadfrag(new CategoryFragment(),false);

                }
                else if (id==R.id.mexplore)
                {

                    loadfrag(new ExploreFragment(),false);

                }
                else {
                    
                    loadfrag(new ProfileFragment(), false);

                }

                return true;

            }
        });
        bottomNavigationView.setSelectedItemId(R.id.mHome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.tools_toolbar,menu);
        MenuItem.OnActionExpandListener onActionExpandListener=new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return false;
            }
        };
        return super.onCreateOptionsMenu(menu);

    }

    //Bottom Navigation Bar
    public void loadfrag(Fragment fragment, boolean flag){

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag)
            ft.add(R.id.container_demo,fragment);

        else
            ft.replace(R.id.container_demo,fragment);
            ft.commit();

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    //For Toolbar Items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.bag:

                getSupportFragmentManager().beginTransaction().replace(R.id.profile_container_main,new CartFragment()).addToBackStack(null).commit();

                break;



        }


        return super.onOptionsItemSelected(item);
    }
}