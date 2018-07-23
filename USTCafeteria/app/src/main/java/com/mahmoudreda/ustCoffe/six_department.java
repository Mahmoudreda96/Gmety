package com.mahmoudreda.ustCoffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

public class six_department extends AppCompatActivity {
    ArrayList<list_Item_menu> Item_6 = new ArrayList<>();
    String[] drinks, drinks_price;
    android.support.v7.widget.RecyclerView recyclerView_6;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_department);
        drinks = getResources().getStringArray(R.array.drinks);
        drinks_price = getResources().getStringArray(R.array.drinks_price);
        getListView_6();
        recyclerView_6 = findViewById(R.id.recycleView_6);
        recyclerView_6.hasFixedSize();
        recycleAdaptor adapter = new recycleAdaptor(Item_6, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_6.setLayoutManager(linearLayoutManager);
        recyclerView_6.setAdapter(adapter);
    }

    public void getListView_6() {
        for (int i = 0; i <= drinks_price.length - 1; i++) {
            Item_6.add(new list_Item_menu(drinks[i], drinks_price[i]));
        }
    }
}