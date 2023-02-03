package edu.illinois.cs465.fetch_test;
import edu.illinois.cs465.fetch_test.Adapters.ListAdapter;
import edu.illinois.cs465.fetch_test.Model.ItemModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    private ArrayList<ItemModel> itemList;

    public String loadJson(){
        // Load data from hiring.json
        String jsonData = null;

        try {
            InputStream is = getAssets().open("hiring.json");

            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();
            jsonData = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return jsonData;
    }

    public static ArrayList<ItemModel> filterData(JSONArray jsonArray) throws JSONException {
        // Filter data with blank or null "name" field
        ArrayList<ItemModel> filteredList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String name = jsonObject.getString("name");
            if(name.compareTo("null") == 0 || name.compareTo("") == 0)
                continue;

            int id = jsonObject.getInt("id");
            int listId = jsonObject.getInt("listId");

            ItemModel newItem = new ItemModel(id, listId, name);
            filteredList.add(newItem);
        }

        return filteredList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load and filter data
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(loadJson());
            itemList = filterData(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Sort data
        Collections.sort(itemList);

        // Display data with recyclerview
        RecyclerView recyclerView;
        ListAdapter listAdapter;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new ListAdapter(itemList);
        recyclerView.setAdapter(listAdapter);
    }


}