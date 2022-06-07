package set_map.map.treeMap;

public class TreeEntry {
    public int key;
    public String value;

    public TreeEntry left;
    public TreeEntry right;

    public TreeEntry(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Entry{%d=>%s}",key,value);
    }
}
