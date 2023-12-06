package com.example.productlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Products> localDataSet;

    public void setProductList(List<Products> productList) {
        this.localDataSet = productList;
        notifyDataSetChanged();
    }

    public MyAdapter() {

        this.localDataSet = localDataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frame_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(new Integer(localDataSet.get(position).getId()).toString());
        holder.productName.setText(localDataSet.get(position).getProduct());
        holder.quantity.setText(localDataSet.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size()-1;
    }

//    public void addLocalDataSet(String text){
//        if (localDataSet.length != 0){
//            String[] newArray = Arrays.copyOf(localDataSet, localDataSet.length + 1);
//            newArray[newArray.length-1] = text;
//            localDataSet = newArray;
//        };
//        if (localDataSet.length == 0){
//            String[] newArray = Arrays.copyOf(localDataSet, localDataSet.length + 1);
//            newArray[newArray.length-1] = text;
//            localDataSet = newArray;
//        };
//
//    };
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView productName;
        TextView quantity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//          id = (TextView) itemView.findViewById(R.id.textViewId);
            productName = (TextView) itemView.findViewById(R.id.textView3);
            quantity = (TextView) itemView.findViewById(R.id.textView3);

        }
    }
}
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
//    private List<String> productList;
//
//    public void setProductList(List<String> productList) {
//        this.productList = productList;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.frame_layout, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        String product = productList.get(position);
//        holder.textView3.setText(product);
//    }
//
//    @Override
//    public int getItemCount() {
//        return productList != null ? productList.size() : 0;
//    }
//
//    static class ViewHolder extends RecyclerView.ViewHolder {
//        TextView textView3;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textView3 = itemView.findViewById(R.id.textView3);
//        }
//    }
//}


