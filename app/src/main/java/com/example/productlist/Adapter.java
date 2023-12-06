package com.example.productlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<NumberModel> listNumber;

    public Adapter(List<NumberModel> list){
        this.listNumber = list;
    };

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.frame_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

    public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView3);

        }

        ;
    }
}
