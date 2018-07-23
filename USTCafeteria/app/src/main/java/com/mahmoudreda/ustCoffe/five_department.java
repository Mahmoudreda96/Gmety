package com.mahmoudreda.ustCoffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

public class five_department extends AppCompatActivity {
    ArrayList<list_Item_menu> Item_5 = new ArrayList<>();
    String[] halw;
    String[]halw_price;
    android.support.v7.widget.RecyclerView recyclerView_5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_department);

        halw = getResources().getStringArray(R.array.halw);
        halw_price = getResources().getStringArray(R.array.halw_price);
        getListView_5();
        recyclerView_5 = findViewById(R.id.recycleView_5);
        recyclerView_5.hasFixedSize();
        recycleAdaptor adapter = new recycleAdaptor(Item_5, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_5.setLayoutManager(linearLayoutManager);
        recyclerView_5.setAdapter(adapter);
    }

    public void getListView_5() {
        for (int i = 0; i <= halw_price.length - 1; i++) {
            Item_5.add(new list_Item_menu(halw[i], halw_price[i]));
        }
    }
}