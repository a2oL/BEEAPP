package com.hr.beetestapp;

import android.app.Activity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hr.beetestapp.adapter.CategAdapter;
import com.hr.beetestapp.model.Payload;
import com.kumulos.android.Kumulos;
import com.kumulos.android.ResponseHandler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    CategAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HashMap<String, String> params = new HashMap<>();

        Kumulos.call("getAllStoriesV2", params, new ResponseHandler() {
            @Override
            public void onFailure(@Nullable Throwable error) {
                super.onFailure(error);
            }

            @Override
            public void didCompleteWithResult(@Nullable Object result) {
                Gson gson = new Gson();
                String json = gson.toJson(result);
                JsonParser parser = new JsonParser();
                JsonArray gsonArr = parser.parse(json).getAsJsonArray();
                ArrayList<Payload> lista = new ArrayList();
                ArrayList<String> categ = new ArrayList();
                ArrayList<String> categ2 = new ArrayList();
                for (JsonElement obj : gsonArr) {
                    JsonObject gsonObj = obj.getAsJsonObject();
                    String name = gsonObj.get("name").getAsString();
                    String titles = gsonObj.get("titles").getAsString();
                    String imageUrl = gsonObj.get("imageUrl").getAsString();
                    String descriptions = gsonObj.get("descriptions").getAsString();
                    String dynamicCategories = gsonObj.get("dynamicCategories").getAsString();
                    JsonArray gsonArr2 = parser.parse(dynamicCategories).getAsJsonArray();
                    String listacateg = "";
                    String lang = "en";
                    for (JsonElement objs : gsonArr2) {
                        String gsonObjs = objs.getAsString();
                        if(gsonObjs.startsWith(lang))
                        {
                            listacateg = gsonObjs;
                            categ.add(gsonObjs);
                        }
                    }

                    String levelV2 = gsonObj.get("levelV2").getAsString();
                    lista.add(new Payload(name, titles, imageUrl, descriptions, listacateg, levelV2));
                }

                for (int i =0 ; i <categ.size() ; i ++)
                {
                    if (categ2.size() > 0)
                    {
                        boolean exito = false;
                        for (int j = 0 ; j < categ2.size(); j ++ )
                        {
                            if(categ.get(i).equals(categ2.get(j)))
                            {
                                exito = true;
                            }
                        }
                        if (!exito)
                        {
                            categ2.add(categ.get(i));
                        }
                    }
                    else
                    {
                        categ2.add(categ.get(i));
                    }
                }

                runOnUiThread(new Runnable() {
                    public void run() {
                        RecyclerView recyclerView = findViewById(R.id.rev_categ);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapter = new CategAdapter(getParent(),getApplicationContext(), lista, categ2);
                        recyclerView.setAdapter(adapter);
                    }
                });

                super.didCompleteWithResult(result);
            }
        });

    }
}