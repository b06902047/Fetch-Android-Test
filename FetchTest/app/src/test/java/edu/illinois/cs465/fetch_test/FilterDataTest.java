package edu.illinois.cs465.fetch_test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import edu.illinois.cs465.fetch_test.Model.ItemModel;
import static org.junit.Assert.assertEquals;

public class FilterDataTest{
    @Test
    public void testFilterData() throws JSONException {
        // Prepare the data
        JSONObject jo1 = new JSONObject();
        jo1.put("id", 1);
        jo1.put("listId", 2);
        jo1.put("name", "null");

        JSONObject jo2 = new JSONObject();
        jo2.put("id", 5);
        jo2.put("listId", 2);
        jo2.put("name", "Item 5");

        JSONObject jo3 = new JSONObject();
        jo3.put("id", 7);
        jo3.put("listId", 3);
        jo3.put("name", "");

        JSONArray ja = new JSONArray();
        ja.put(jo1);
        ja.put(jo2);
        ja.put(jo3);

        // Apply the filter
        ArrayList<ItemModel> itemList = new ArrayList<>();
        itemList = MainActivity.filterData(ja);

        // Verify the filtered data
        assertEquals(itemList.size(), 1);
        assertEquals(itemList.get(0), new ItemModel(5, 2, "Item 5"));
    }
}
