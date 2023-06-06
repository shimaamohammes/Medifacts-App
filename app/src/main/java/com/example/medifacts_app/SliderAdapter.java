package com.example.medifacts_app;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {
    private List<SliderModel> sliderModelList;

    public SliderAdapter(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }

    private ViewPager2 bannerSliderViewPager;

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout,parent,false);
//        parent.addView(view,0);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        String resource = sliderModelList.get(position).getBanner();
        String container = sliderModelList.get(position).getBackgroundColor();

        holder.setBanner(resource);
        holder.setBannerContainer(container);
    }

    @Override
    public int getItemCount() {
        return sliderModelList.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView banner;
        private ConstraintLayout bannerContainer;
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner_slide);
            bannerContainer = itemView.findViewById(R.id.banner_container);
        }
        void setBanner(String resource){
            Glide.with(itemView.getContext()).load(resource).apply(new RequestOptions().placeholder(R.mipmap.home_icon)).into(banner);
        }
        void setBannerContainer(String container){
            bannerContainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(container)));
        }
    }

}
