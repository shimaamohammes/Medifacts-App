package com.example.medifacts_app;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.view.ViewGroup.*;
import static android.widget.LinearLayout.*;

public class ProductBenefitsAdaptor extends RecyclerView.Adapter<ProductBenefitsAdaptor.ViewHolder> {
    private List<ProductBenefitsModel> productBenefitsModelList;

    public ProductBenefitsAdaptor(List<ProductBenefitsModel> productBenefitsModels) {
        this.productBenefitsModelList = productBenefitsModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (productBenefitsModelList.get(position).getType()){
            case 0:
                return ProductBenefitsModel.BENEFITS_TITLE;
            case 1:
                return ProductBenefitsModel.BENEFITS_BODY;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case ProductBenefitsModel.BENEFITS_TITLE:
                TextView title = new TextView(parent.getContext());
                title.setTypeface(null, Typeface.BOLD);
                title.setTextColor(Color.parseColor("#000000"));
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT);
//                layoutParams.setMargins(setDp(16,parent.getContext()),
//                        setDp(16,parent.getContext()),setDp(16,parent.getContext()),setDp(16,parent.getContext())
//                );
//                title.setLayoutParams(layoutParams);
                return new ViewHolder(title);
            case ProductBenefitsModel.BENEFITS_BODY:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_benefits_item_layout,parent,false);
                return new ViewHolder(view);
            default:return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (productBenefitsModelList.get(position).getType()){
            case ProductBenefitsModel.BENEFITS_TITLE:
                holder.setTitle(productBenefitsModelList.get(position).getTitle());
            break;
            case ProductBenefitsModel.BENEFITS_BODY:
                String medicineTitle = productBenefitsModelList.get(position).getMedicinename();
                String medicineDetail = productBenefitsModelList.get(position).getMedicinevalue();
                holder.setFeatures(medicineTitle,medicineDetail);
            default:
                return;
        }

    }

    @Override
    public int getItemCount() {
        return productBenefitsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView medicineName;
        private TextView medicineValue;
        private TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        private void setTitle(String titleText){
            title = (TextView) itemView;
            title.setText(titleText);
        }
        private void setFeatures(String medicineTitle,String medicineDetail){
            medicineName = itemView.findViewById(R.id.medicine_name);
            medicineValue = itemView.findViewById(R.id.medicine_value);
            medicineName.setText(medicineTitle);
            medicineValue.setText(medicineDetail);
        }
    }

    private int setDp(int dp, Context context){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }
}
