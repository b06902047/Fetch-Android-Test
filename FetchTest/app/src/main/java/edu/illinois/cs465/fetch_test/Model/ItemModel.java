package edu.illinois.cs465.fetch_test.Model;

public class ItemModel implements Comparable<ItemModel> {
    private int id;
    private int listId;
    private String name;

    public ItemModel(int id, int listId, String name) {
        this.id = id;
        this.listId = listId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(ItemModel o) {
        if(this.listId == o.listId)
            return this.name.compareTo(o.name);

        if(this.listId > o.listId)
            return 1;
        else
            return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemModel data = (ItemModel) o;

        if (id != data.id || listId != data.listId) return false;
        if (!name.equals(data.name)) return false;
        return true;
    }
}
