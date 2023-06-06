package com.example.medifacts_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ProductDetailsAdaptor extends FragmentPagerAdapter {
    private int totalTabs;

    public ProductDetailsAdaptor(FragmentManager fm,int totalTabs){
        super(fm,totalTabs);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProductDescriptionFragment productDescriptionFragment1 = new ProductDescriptionFragment();
                return productDescriptionFragment1;
            case 1:
                ProductUseFragment productUseFragment = new ProductUseFragment();
                return productUseFragment;
            case 2:
                ProductDescriptionFragment productDescriptionFragment2 = new ProductDescriptionFragment();
                return productDescriptionFragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
