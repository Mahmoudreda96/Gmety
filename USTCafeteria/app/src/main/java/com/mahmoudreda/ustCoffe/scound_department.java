package com.mahmoudreda.ustCoffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import java.util.ArrayList;

public class scound_department extends AppCompatActivity {

    ArrayList<list_Item_menu> Item_2 = new ArrayList<>();
    String[] makarona, makarona_price;
    android.support.v7.widget.RecyclerView recyclerView_2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scound_department);
        makarona = getResources().getStringArray(R.array.makarona);
        makarona_price = getResources().getStringArray(R.array.makarona_price);
        getListView_2();
        recyclerView_2 = findViewById(R.id.recycleView_2);
        recyclerView_2.hasFixedSize();
        recycleAdaptor adapter = new recycleAdaptor(Item_2, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView_2.setLayoutManager(linearLayoutManager);
        recyclerView_2.setAdapter(adapter);
    }

    public void getListView_2() {
        for (int i = 0; i <= makarona_price.length - 1; i++) {
            Item_2.add(new list_Item_menu(makarona[i], makarona_price[i]));
        }
    }
}