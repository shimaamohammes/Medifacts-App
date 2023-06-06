package com.example.medifacts_app;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medifacts_app.ui.home.HomePageAdapter;
import com.example.medifacts_app.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);


        //horizontalProduct Layout

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.apple,"Apple Cider Vinegar","100% Natural Vinegar 500ml","450.00"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.green_email,"Apple Cider Vinegar","100% Natural Vinegar 500ml","450.00"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.red_email,"Apple Cider Vinegar","100% Natural Vinegar 500ml","450.00"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.my_account,"Apple Cider Vinegar","100% Natural Vinegar 500ml","450.00"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cart_black,"Apple Cider Vinegar","100% Natural Vinegar 500ml","450.00"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.custom_error,"Apple Cider Vinegar","100% Natural Vinegar 500ml","450.00"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.ic_launcher_round,"Apple Cider Vinegar","100% Natural Vinegar 500ml","450.00"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.app_icon,"Apple Cider Vinegar","100% Natural Vinegar 500ml","450.00"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.ic_launcher_round,"Apple Cider Vinegar","100% Natural Vinegar 500ml","450.00"));


        //horizontalProduct Layout

        ///////////////////
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomeViewModel> homeViewModelList = new ArrayList<>();

        homeViewModelList.add(new HomeViewModel(2,"Deal of the Day",horizontalProductScrollModelList));
        homeViewModelList.add(new HomeViewModel(2,"Deal of the Day",horizontalProductScrollModelList));
        homeViewModelList.add(new HomeViewModel(3,"Deal of the Day",horizontalProductScrollModelList));
        homeViewModelList.add(new HomeViewModel(3,"Deal of the Day",horizontalProductScrollModelList));


        HomePageAdapter adapter = new HomePageAdapter(homeViewModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.main_search_icon) {
            return true;
        }else if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}