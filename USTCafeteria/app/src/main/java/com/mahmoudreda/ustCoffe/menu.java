package com.mahmoudreda.ustCoffe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {

    Button x, y, z, t, v, s, w;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manio);
        x = findViewById(R.id.wagapat);
        y = findViewById(R.id.makarona);
        z = findViewById(R.id.sandwetshat);
        t = findViewById(R.id.pitza);
        v = findViewById(R.id.helw);
        s = findViewById(R.id.mshrobat);
        w = findViewById(R.id.my_order);


        //to transfer to another layout
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), first_department.class);
                startActivity(i);
            }
        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), scound_department.class);
                startActivity(i);
            }
        });
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), third_department.class);
                startActivity(i);
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), four_department.class);
                startActivity(i);
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), five_department.class);
                startActivity(i);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), six_department.class);
                startActivity(i);
            }
        });
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), order.class);
                startActivity(i);
            }
        });

    }
}