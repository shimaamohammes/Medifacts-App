package com.example.medifacts_app;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.medifacts_app.ui.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT=1;
    private FrameLayout frameLayout;
    private static int currentFragment;
    private NavigationView navigationView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[] {-android.R.attr.state_checked},
                        new int[] {android.R.attr.state_checked}
                },
                new int[]{
                        Color.DKGRAY,
                        Color.BLUE
                }
        );
        navigationView.setItemTextColor(colorStateList);
        navigationView.setItemIconTintList(colorStateList);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        frameLayout = findViewById(R.id.main_framelayout);
        setFragment(new HomeFragment(),HOME_FRAGMENT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (currentFragment==HOME_FRAGMENT){
            getMenuInflater().inflate(R.menu.main, menu);
        }

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.main_search_icon){
            return true;
        }else if (id == R.id.main_notification_icon){
            return true;
        }else if (id == R.id.main_cart_icon){
            myCart();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void myCart() {
        invalidateOptionsMenu();
        setFragment(new MyCartFragment(),CART_FRAGMENT);
        navigationView.getMenu().getItem(3).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_home){
            setFragment(new HomeFragment(),HOME_FRAGMENT);
        }else if (id == R.id.nav_my_orders){

        }else if (id == R.id.nav_my_rewards){

        }else if (id == R.id.nav_my_cart){
            myCart();
        }else if (id == R.id.nav_my_wishlist){

        }else if (id == R.id.nav_my_account){

        }else if (id == R.id.nav_sign_out){

        }
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setFragment(Fragment fragment,int fragmentNo){
        currentFragment = fragmentNo;
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(frameLayout.getId(),fragment);
//        fragmentTransaction.commit();
    }
}