package com.mahmoudreda.ustCoffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class third_department extends AppCompatActivity {

    ArrayList<list_Item_menu> Item3 = new ArrayList<>();
    String[] mail, price;
    android.support.v7.widget.RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_department);
        mail = getResources().getStringArray(R.array.mail);
        price = getResources().getStringArray(R.array.price);
        getListView();
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.hasFixedSize();
        recycleAdaptor adapter = new recycleAdaptor(Item3, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void getListView() {
        for (int i = 0; i <= price.length-1; i++) {
            Item3.add(new list_Item_menu(mail[i], price[i]));
        }
    }
}
