package com.mahmoudreda.ustCoffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import java.util.ArrayList;

public class first_department extends AppCompatActivity {
    ArrayList<list_Item_menu> Item_1 = new ArrayList<>();
    String[] wagpat, wagpat_price;
    android.support.v7.widget.RecyclerView recyclerView_1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist_department);

        wagpat = getResources().getStringArray(R.array.wagpat);
        wagpat_price = getResources().getStringArray(R.array.wagpat_price);
        getListView_1();
        recyclerView_1 = findViewById(R.id.recycleView_1);
        recyclerView_1.hasFixedSize();
        recycleAdaptor adapter = new recycleAdaptor(Item_1, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_1.setLayoutManager(linearLayoutManager);
        recyclerView_1.setAdapter(adapter);
    }

    public void getListView_1() {
        for (int i = 0; i <= wagpat_price.length - 1; i++) {
            Item_1.add(new list_Item_menu(wagpat[i], wagpat_price[i]));
        }
    }
}
