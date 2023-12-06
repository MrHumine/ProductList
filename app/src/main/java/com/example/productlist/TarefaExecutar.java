package com.example.productlist;

import static java.lang.Thread.sleep;

import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutorService;

public class TarefaExecutar {
    ExecutorService executor;
    Handler resultHandler;
    TextView textView;
    ProgressBar progressBar;
    private ListProducts listProducts;
    public TarefaExecutar(ExecutorService executor, Handler resultHandler, TextView textView, String url) {
        this.executor = executor;
        this.resultHandler = resultHandler;
        this.textView = textView;
        listProducts = new ListProducts();

        this.executor.execute(new Runnable() {
            @Override
            public void run() {
                doWork(url);
                atualizaInterface(listProducts.toString());
            }
        });
    }
    private void doWork(String url) {
        String jsonStr;
        HttpHandler handler;
        int progresso;

        handler = new HttpHandler();
        jsonStr = handler.lerInformacao(url);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                JSONArray product = jsonObj.getJSONArray("Prodcut-name");
                for (int i = 0; i < product.length(); i++) {
                    JSONObject musicasJSONObject = product.getJSONObject(i);
                    String product_name = musicasJSONObject.getString("product_name");
                    Integer id_product = musicasJSONObject.getInt("id_product");
                    String quantity = musicasJSONObject.getString("quantity");
                    listProducts.add(new Products(id_product, product_name, quantity));
                    sleep(100);
                    atualizaInterface();
                }
            } catch (JSONException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void atualizaInterface() {

        resultHandler.post(new Runnable() {
            @Override
            public void run() {}
        });
    }

    private void atualizaInterface(String mensagem) {

        resultHandler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(mensagem);
            }
        });
    }
}
