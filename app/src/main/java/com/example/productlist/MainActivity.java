package com.example.productlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.HandlerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    ExecutorService executorService;
    Handler mainThreadHandler;
    TextView textView;
    private RecyclerView recyclerView;
    HttpHandler httpHandler = new HttpHandler();


    private LinearLayoutManager layoutManager;


    String url =  "https://hostingalunos.upt.pt/~dam/products.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB_handler db = new DB_handler(this);
        if(!db.doesDatabaseExist()){
            db.addNumber(new NumberModel(1,1));
            db.addNumber(new NumberModel(2,2));
            db.addNumber(new NumberModel(3,3));
        };

        button = findViewById(R.id.button_save);
        recyclerView = findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<NumberModel> list = db.getAllNumbers();
        Adapter adapter = new Adapter(list);
        button.setOnClickListener((view)->{
            recyclerView.setAdapter(adapter);
        });
    }


    @Override
    public void onClick(View v) {

    }
}
