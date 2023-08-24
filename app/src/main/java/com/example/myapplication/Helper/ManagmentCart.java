package com.example.myapplication.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.myapplication.Domain.FoodDomain;

import java.util.ArrayList;

public class ManagmentCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item){
        ArrayList<FoodDomain> listfood=getlistCart();
        boolean exitAlready = false;
        int n = 0;
        for (int y =0; y <listfood.size(); y++){
            if (listfood.get(y).getTitle().equals(item.getTitle())){
                exitAlready = true;
                n=y;
                break;
            }
        }
        if (exitAlready){
            listfood.get(n).setNumberinCart(item.getNumberinCart());
        }else {
            listfood.add(item);
        }
        tinyDB.putListObject("CartList", listfood);
        Toast.makeText(context, "Add to your Cart", Toast.LENGTH_SHORT).show();
    }

    private ArrayList<FoodDomain> getlistCart() {
        return tinyDB.getListObject("CartList");
    }
}
