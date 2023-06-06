package com.example.medifacts_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdaptor extends RecyclerView.Adapter {

    private List<CartItemModel> cartItemModelList;

    public CartAdaptor(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartItemModelList.get(position).getType()){
            case 0:
                return CartItemModel.CART_ITEM;
            case 1:
                return CartItemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case CartItemModel.CART_ITEM:
                View cartItemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout,parent,false);
                return new CartItemViewholder(cartItemView);
            case CartItemModel.TOTAL_AMOUNT:
                View cartTotalview= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_amount_layout,parent,false);
                return new CartItemViewholder(cartTotalview);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (cartItemModelList.get(position).getType()){
            case CartItemModel.CART_ITEM:
                int resource = cartItemModelList.get(position).getProductImage();
                String tittle = cartItemModelList.get(position).getProductTitle();
                int freeCoupons = cartItemModelList.get(position).getFreeCoupons();
                String productPrice = cartItemModelList.get(position).getProductPrice();
                String cuttedPrice = cartItemModelList.get(position).getCuttedPrice();
                int offersapplied = cartItemModelList.get(position).getOffersapplied();

                ((CartItemViewholder)holder).setItemDetails(resource,tittle,freeCoupons,productPrice,cuttedPrice,offersapplied);
                break;
            case CartItemModel.TOTAL_AMOUNT:
                String totalItems = cartItemModelList.get(position).getTotalItems();
                String totalItemPrice = cartItemModelList.get(position).getTotalItemPrice();
                String deliveryPrice = cartItemModelList.get(position).getDeliveryPrice();
                String totalAmount = cartItemModelList.get(position).getTotalAmmount();
                String savedAmount = cartItemModelList.get(position).getSavedAmount();
                ((CartTotalAmountViewholder)holder).setTotalAmount(totalItems,totalItemPrice,deliveryPrice,totalAmount,savedAmount);
                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    class CartItemViewholder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        private ImageView free_coupon_icon;
        private TextView productTitle;
        private TextView freecoupons;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offersApplied;
        private TextView couponsApplied;
        private TextView productQuantity;

        public CartItemViewholder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_Title);
            free_coupon_icon = itemView.findViewById(R.id.free_copuon_icon);
            productPrice = itemView.findViewById(R.id.product_Price);
            cuttedPrice = itemView.findViewById(R.id.cutted_Price);
            offersApplied = itemView.findViewById(R.id.offers_applied);
            couponsApplied = itemView.findViewById(R.id.coupons_applied);
            productQuantity = itemView.findViewById(R.id.product_quantity);
        }
        private void setItemDetails(int resource,String title,int freecouponsNo,String productPriceText,String cuttedPriceText,int offersAppliedText){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freecouponsNo>0){
                free_coupon_icon.setVisibility(View.VISIBLE);
                freecoupons.setVisibility(View.VISIBLE);
                if (freecouponsNo==1){
                    freecoupons.setText("free"+freecouponsNo+"Coupon");
                }
                else {
                    freecoupons.setText("free"+freecouponsNo+"Coupons");
                }
            }
            else{
                free_coupon_icon.setVisibility(View.INVISIBLE);
                freecoupons.setVisibility(View.INVISIBLE);
            }
            productPrice.setText(productPriceText);
            cuttedPrice.setText(cuttedPriceText);
            offersApplied.setText(offersAppliedText);
            if (offersAppliedText>0){
                offersApplied.setVisibility(View.VISIBLE);
                offersApplied.setText(offersAppliedText+"Offers Applied");
            }
            else {
                offersApplied.setVisibility(View.INVISIBLE);
            }
        }
    }



    class CartTotalAmountViewholder extends RecyclerView.ViewHolder{
        private  TextView totalItems;
        private  TextView totalItemsPrice;
        private  TextView deliveryPrice;
        private  TextView totalAmount;
        private  TextView savedAmount;

        public CartTotalAmountViewholder(@NonNull View itemView) {
            super(itemView);

            totalItems = itemView.findViewById(R.id.total_items);
            totalItemsPrice = itemView.findViewById(R.id.total_items_price);
            deliveryPrice  = itemView.findViewById(R.id.delivery_charge);
            totalAmount = itemView.findViewById(R.id.total_Price);
            savedAmount = itemView.findViewById(R.id.saved_amount);
        }
        private void setTotalAmount(String totalItemText,String totalItemPriceText,String deliveryPriceText,String totalAmountText,String savedAmountText){
            totalItems.setText(totalItemText);
            totalItemsPrice.setText(totalItemPriceText);
            deliveryPrice.setText(deliveryPriceText);
            totalAmount.setText(totalAmountText);
            savedAmount.setText(savedAmountText);
        }
    }
}
