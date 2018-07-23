package com.mahmoudreda.ustCoffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

public class four_department extends AppCompatActivity {
    ArrayList<list_Item_menu> Item_4 = new ArrayList<>();
    String[] pitza, pitza_price;
    android.support.v7.widget.RecyclerView recyclerView_4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_department);
        pitza = getResources().getStringArray(R.array.pitza);
        pitza_price = getResources().getStringArray(R.array.pitza_price);
        getListView_4();
        recyclerView_4 = findViewById(R.id.recycleView_4);
        recyclerView_4.hasFixedSize();
        recycleAdaptor adapter = new recycleAdaptor(Item_4, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_4.setLayoutManager(linearLayoutManager);
        recyclerView_4.setAdapter(adapter);
    }

    public void getListView_4() {
        for (int i = 0; i <= pitza_price.length - 1; i++) {
            Item_4.add(new list_Item_menu(pitza[i], pitza_price[i]));
        }
    }
}
