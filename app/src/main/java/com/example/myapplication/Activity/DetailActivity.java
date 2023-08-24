package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Domain.FoodDomain;
import com.example.myapplication.Helper.ManagmentCart;
import com.example.myapplication.R;

public class DetailActivity extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView plusBtn, minusBtn, titleTxt, feeTxt, descriptionTxt, numberOrderTxt, starTxt, calogyTxt, timeTxt;
    private ImageView picFood;
    private FoodDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        managmentCart = new ManagmentCart(DetailActivity.this);


        initView();
        getBundle();
    }

    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResouceId = this.getResources().getIdentifier(object.getPicUrl(),"drawable",getPackageName());
        Glide.with(this)
                .load(drawableResouceId)
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$" + object.getPrice());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(""+ numberOrder);
        calogyTxt.setText(object.getEnergy()+" Cal");
        starTxt.setText(object.getScore()+"");
        timeTxt.setText(object.getTime()+" min");
        addToCartBtn.setText("Add to cart  - $"+Math.round(numberOrder*object.getPrice()));


        plusBtn.setOnClickListener(view -> {
            numberOrder=numberOrder+1;
            numberOrderTxt.setText(""+numberOrder);
            addToCartBtn.setText("Add to cart  - $"+Math.round(numberOrder*object.getPrice()));

        });


        minusBtn.setOnClickListener(view -> {
            numberOrder=numberOrder - 1;
            numberOrderTxt.setText(""+numberOrder);
            addToCartBtn.setText("Add to cart  - $"+Math.round(numberOrder*object.getPrice()));

        });


        addToCartBtn.setOnClickListener(view -> {
            object.setNumberinCart(numberOrder);
            managmentCart.insertFood(object);
        });
    }

    private void initView() {
       addToCartBtn =findViewById(R.id.addtoCartBtn);
        plusBtn=findViewById(R.id.plusCardBtn);
        titleTxt=findViewById(R.id.title);
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrderTxt=findViewById(R.id.numberItemTxt);
        starTxt=findViewById(R.id.StartTxt);
       calogyTxt =findViewById(R.id.calTxt);
       timeTxt = findViewById(R.id.timeTxt1);
       picFood = findViewById(R.id.foodPic);
       minusBtn = findViewById(R.id.MinusCardBtn);
       

    }
}