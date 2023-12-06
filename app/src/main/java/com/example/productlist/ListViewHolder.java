package com.example.productlist;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    private TextView textView2;

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public void setTextView2(TextView textView2) {
        this.textView2 = textView2;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public TextView getTextView2() {
        return textView2;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    private TextView textView5;
    private CheckBox checkBox;
    public ListViewHolder(View itemView){
        super(itemView);
        textView = itemView.findViewById(R.id.textView3);
        textView2 = itemView.findViewById(R.id.textView1);
        checkBox = itemView.findViewById(R.id.checkBox);
    };
    public TextView getTextView() {
        return textView;
    }

    public TextView setTextView(){
        return textView;
    };
}
