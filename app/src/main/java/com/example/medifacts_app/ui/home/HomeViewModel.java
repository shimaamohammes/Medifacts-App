package com.example.medifacts_app.ui.home;


import com.example.medifacts_app.HorizontalProductScrollModel;
import com.example.medifacts_app.SliderModel;

import java.util.List;

public class HomeViewModel{
    public static final int BANNER_SLIDER = 0;
    public static final int UPLOAD_PRESCRIPTION_STRIP = 1;
    public static final int HORIZONTAL_PRODUCT_VIEW = 2;
    public static final int GRID_PRODUCT_VIEW = 3;

    private int type;
    ///Banner Slider

    private List<SliderModel> sliderModelList;

    public HomeViewModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }

    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    //Banner Slider

    ////////Upload Prescription Strip
    private String  resource;
    private String backgroundColor;

    public HomeViewModel(int type, String resource, String backgroundColor) {
        this.type = type;
        this.resource = resource;
        this.backgroundColor = backgroundColor;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    ////////Upload Prescription Strip

    //////Horizontal Product Layout & Grid Product Layout
    private String title;
    private List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public HomeViewModel(int type, String title, List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.type = type;
        this.title = title;
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HorizontalProductScrollModel> getHorizontalProductScrollModelList() {
        return horizontalProductScrollModelList;
    }

    public void setHorizontalProductScrollModelList(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    /////////Horizontal Product Layout & Grid Product Layout


}