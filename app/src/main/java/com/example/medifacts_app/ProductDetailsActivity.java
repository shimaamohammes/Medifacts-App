package com.example.medifacts_app;

        import android.content.res.ColorStateList;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.LinearLayout;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;
        import androidx.viewpager2.widget.ViewPager2;

        import com.google.android.material.floatingactionbutton.FloatingActionButton;
        import com.google.android.material.tabs.TabLayout;

        import java.util.ArrayList;
        import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {


    ////Rating Layout
    private LinearLayout rateNowContainer;
    ////
    private static boolean ALREADY_ADDED_TO_WISHLIST = false;
    private FloatingActionButton addToWishlistBtn;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        productImagesViewPager = findViewById(R.id.product_images_viewpager);
//        viewpagerIndicator = findViewById(R.id.viewpager_indicator);
        addToWishlistBtn = findViewById(R.id.add_to_wishlist_btn);

        addToWishlistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ALREADY_ADDED_TO_WISHLIST){
                    ALREADY_ADDED_TO_WISHLIST=false;
                    addToWishlistBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                }
                else{
                    ALREADY_ADDED_TO_WISHLIST=true;
                    addToWishlistBtn.setSupportImageTintList(getResources().getColorStateList(R.color.unsuccessRed));
                }
            }
        });



//       productDetailsViewpager.setAdapter(new ProductDetailsAdaptor(getSupportFragmentManager(), productDetailsTabLayout.getTabCount()));
//       productDetailsViewpager.OnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTabLayout));
//       productDetailsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//           @Override
//           public void onTabSelected(TabLayout.Tab tab) {
//               productDetailsViewpager.setCurrentItem(tab.getPosition());
//           }
//
//           @Override
//           public void onTabUnselected(TabLayout.Tab tab) {
//
//           }
//
//           @Override
//           public void onTabReselected(TabLayout.Tab tab) {
//
//           }
//       });


        ////Rating Layout
        rateNowContainer = findViewById(R.id.rate_now_container);
        for (int x = 0;x<rateNowContainer.getChildCount();x++){
            final int starPosition = x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setRating(starPosition);
                }
            });
        }
        /////RatingLayout
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            finish();
            return true;
        }else if (id == R.id.main_search_icon){
            return true;
        }else if (id == R.id.main_cart_icon){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setRating(int starPosition) {
        for (int x=0;x<rateNowContainer.getChildCount();x++){
            ImageView starBtn = (ImageView)rateNowContainer.getChildAt(x);
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
            if(x<=starPosition){
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }
}
