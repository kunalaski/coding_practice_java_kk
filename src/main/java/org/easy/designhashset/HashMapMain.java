package org.easy.designhashset;

public class HashMapMain {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        assert myHashMap.get(1) == 1;    // return 1, The map is now [[1,1], [2,2]]
        assert myHashMap.get(3) == -1;    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        assert myHashMap.get(2) == 1;    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        assert myHashMap.get(2) == -1;
    }

}
