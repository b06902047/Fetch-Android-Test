package edu.illinois.cs465.fetch_test;
import edu.illinois.cs465.fetch_test.Adapters.ListAdapter;
import edu.illinois.cs465.fetch_test.Model.ItemModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    private ArrayList<ItemModel> itemList;

    public static String stream(URL url) {
        // Retrieve data from url
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
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

        // Load data
        final String[] data = {""};
        try{
            URL url = new URL("https://fetch-hiring.s3.amazonaws.com/hiring.json");
            Thread thread = new Thread() {
                @Override
                public void run() {
                    data[0] = stream(url);
                }
            };
            thread.start();
            thread.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // Filter data
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(data[0]);
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