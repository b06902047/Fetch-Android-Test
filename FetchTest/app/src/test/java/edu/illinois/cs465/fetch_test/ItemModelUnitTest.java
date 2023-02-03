package edu.illinois.cs465.fetch_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import edu.illinois.cs465.fetch_test.Model.ItemModel;
import static org.junit.Assert.assertEquals;

public class ItemModelUnitTest {
    @Test
    public void testSortData() {

        ArrayList<ItemModel> itemList = new ArrayList<>();
        itemList.add(new ItemModel(657, 2, "Item 657"));
        itemList.add(new ItemModel(23, 1, "Item 23"));
        itemList.add(new ItemModel(1, 3, "Item 1"));
        itemList.add(new ItemModel(6, 1, "Item 6"));
        itemList.add(new ItemModel(65, 2, "Item 65"));
        itemList.add(new ItemModel(642, 2, "Item 642"));

        Collections.sort(itemList);

        assertEquals(itemList.get(0), new ItemModel(23, 1, "Item 23"));
        assertEquals(itemList.get(1), new ItemModel(6, 1, "Item 6"));
        assertEquals(itemList.get(2), new ItemModel(642, 2, "Item 642"));
        assertEquals(itemList.get(3), new ItemModel(65, 2, "Item 65"));
        assertEquals(itemList.get(4), new ItemModel(657, 2, "Item 657"));
        assertEquals(itemList.get(5), new ItemModel(1, 3, "Item 1"));
    }
}
