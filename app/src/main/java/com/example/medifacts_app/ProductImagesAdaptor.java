package com.example.medifacts_app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull; 
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductImagesAdaptor extends RecyclerView.Adapter<ProductImagesAdaptor.Viewholder> {

    private List<Integer> productImages;

    public ProductImagesAdaptor(List<Integer> productImages) {
        this.productImages = productImages;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView productImage = new ImageView(parent.getContext());
        parent.addView(productImage,0);
        return new Viewholder(productImage);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        int resource = productImages.get(position);
        holder.setProductImage(resource);
    }

    @Override
    public int getItemCount() {
        return productImages.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
        }
        private void setProductImage(int resource){
            productImage.setImageResource(resource);
        }
    }
}