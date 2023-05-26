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
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.jjj.myntra.Fragments.AnimationCart;
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

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "session";
    private static final String KEY_ID = "id";

    //Bottom Navigation Bar
    BottomNavigationView bottomNavigationView;

    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences=this.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);




        frameLayout=findViewById(R.id.bottom_container_main);

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
                    replace1(new HomeFragment());
                    frameLayout.setVisibility(View.GONE);
                }

                else  if (id==R.id.mcategories)
                {

                    replace(new CategoryFragment());
                    frameLayout.setVisibility(View.VISIBLE);

                }
                else if (id==R.id.mexplore)
                {

                    replace(new ExploreFragment());
                    frameLayout.setVisibility(View.VISIBLE);

                }
                else {

                    replace(new ProfileFragment());
                    frameLayout.setVisibility(View.VISIBLE);

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
/*    public void loadfrag(Fragment fragment, boolean flag){

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag)
            ft.add(R.id.container_demo,fragment);

        else
            ft.replace(R.id.container_demo,fragment);
            ft.commit();

    }*/

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

                String id = sharedPreferences.getString(KEY_ID,null);
                if (id.equals(1)){
                    getSupportFragmentManager().beginTransaction().replace(R.id.profile_container_main,new CartFragment()).addToBackStack(null).commit();
                    break;
                }
                else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.profile_container_main,new AnimationCart()).addToBackStack(null).commit();

                }


        }


        return super.onOptionsItemSelected(item);
    }

    private  void replace (Fragment fragment){

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.bottom_container_main,fragment);
        fragmentTransaction.addToBackStack(null).commit();


    }

    private  void replace1 (Fragment fragment){

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_demo,fragment);
        fragmentTransaction.addToBackStack(null).commit();


    }

}