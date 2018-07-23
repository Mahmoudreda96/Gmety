package com.mahmoudreda.ustCoffe;

import android.annotation.SuppressLint;
import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

class recycleAdaptor extends RecyclerView.Adapter<recycleAdaptor.ViewHolder> {


    public ArrayList<list_Item_menu> list = new ArrayList<>();
    public Context context;

    public recycleAdaptor(ArrayList<list_Item_menu> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view1 = inflater.inflate(R.layout.coustmerlayout_menu, null);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(final recycleAdaptor.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");
                myRef.setValue(list.get(position).name);
                Toast.makeText(context, " تم اضافة " + list.get(position).name, Toast.LENGTH_LONG).show();

            }
        });
        // - replace the contents of the view with that element
        holder.mail.setText(list.get(position).name);
        holder.price.setText(list.get(position).price);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mail;
        public TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            mail = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
        }
    }
}