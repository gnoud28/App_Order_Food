package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Adapter.FoodListAdapter;
import com.example.myapplication.Domain.FoodDomain;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterFoodlist;
    private RecyclerView recyclerViewFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
    }

    private void initRecyclerview() {
        ArrayList<FoodDomain> items = new ArrayList<>();
        items.add(new FoodDomain("Cheese Burger","Hamburger pho mát hay Burger phô mai " +
                "là một loại hamburger với topping là pho mát. Theo truyền thống, miếng pho \n" +
                " mát thường được đặt bên trên miếng thịt. Người ta thường cho thêm pho \n " +
                "mát vào miếng thịt bò xay đang nấu trong thời gian ngắn, điều này tạo điều kiện \n" +
                "cho pho mát tan chảy.","fast_1",11,20,122, 4));
        items.add(new FoodDomain("Pizza meet",  "Homemade thin crust pizza, topped off with two types of cheese, bacon, ham, pepperoni \n" +
                " and hot sausage! A must make for meat \n" +
                "lover's. Prep Time1 hour hr 10 .","fast_2",12,32,160, 4.5));
        items.add(new FoodDomain("Vegetable pizza","Make the BEST veggie pizza at home! This mouthwatering vegetarian pizza \n" +
                "recipe features tomatoes, bell pepper, artichoke, \n" +
                " spinach and more.","fast_3",13,12,80, 4));

        recyclerViewFood=findViewById(R.id.view1);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        adapterFoodlist = new FoodListAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodlist);
    }
}