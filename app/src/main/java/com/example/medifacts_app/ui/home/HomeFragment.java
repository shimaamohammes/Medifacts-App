package com.example.medifacts_app.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medifacts_app.CategoryAdapter;
import com.example.medifacts_app.CategoryModel;
import com.example.medifacts_app.HorizontalProductScrollModel;
import com.example.medifacts_app.R;
import com.example.medifacts_app.SliderModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment(){

    }


    private HomeViewModel homeViewModel;
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView homePageRecyclerView;
    private HomePageAdapter adapter;
    private List<CategoryModel> categoryModelList;
    private FirebaseFirestore firebaseFirestore;



    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.category_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);


        categoryModelList = new ArrayList<CategoryModel>();
        categoryAdapter = new CategoryAdapter(categoryModelList);

        categoryRecyclerView.setAdapter(categoryAdapter);
        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("CATEGORIES").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(),documentSnapshot.get("categoryName").toString()));
                            }
                            categoryAdapter.notifyDataSetChanged();
                        }else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });




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
        homePageRecyclerView = view.findViewById(R.id.home_page_recycler_view);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLayoutManager);

        final List<HomeViewModel> homeViewModelList = new ArrayList<>();
        adapter = new HomePageAdapter(homeViewModelList);
        homePageRecyclerView.setAdapter(adapter);

        firebaseFirestore.collection("CATEGORIES")
                .document("HOME")
                .collection("TOP_DEALS").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                if ((long)documentSnapshot.get("view_type") == 0){
                                    List<SliderModel> sliderModelList = new ArrayList<>();
                                    long no_of_banners = (long)documentSnapshot.get("no_of_banners");
                                    for (long x = 1; x < no_of_banners + 1; x++){
                                        sliderModelList.add(new SliderModel(documentSnapshot.get("banner_"+x).toString(),
                                                documentSnapshot.get("banner_"+x+"_background").toString()));
                                    }
                                    homeViewModelList.add(new HomeViewModel(0,sliderModelList));
                                }else if ((long)documentSnapshot.get("view_type") == 1){
                                    homeViewModelList.add(new HomeViewModel(1,documentSnapshot.get("strip_ad_banner").toString()
                                            ,documentSnapshot.get("strip_ad_background").toString()));

                                }else if ((long)documentSnapshot.get("view_type") == 2){

                                }else if ((long)documentSnapshot.get("view_type") == 3){

                                }
                            }
                            adapter.notifyDataSetChanged();
                        }else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        homeViewModelList.add(new HomeViewModel(2,"Deal of the Day",horizontalProductScrollModelList));
        homeViewModelList.add(new HomeViewModel(2,"Deal of the Day",horizontalProductScrollModelList));
        homeViewModelList.add(new HomeViewModel(3,"Deal of the Day",horizontalProductScrollModelList));




        /////////////////////

        return view;
    }
}