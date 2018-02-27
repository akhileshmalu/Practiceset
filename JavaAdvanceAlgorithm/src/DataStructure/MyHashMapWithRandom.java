package DataStructure;

import java.util.*;

/**
 * Design a data structure that supports insert, delete, search and getRandom in constant time while accepting
 * duplicate values
 *
 * Design a data structure that supports following operations in Θ(1) time.
 * insert(x): Inserts an item x to the data structure if not already present.
 * remove(x): Removes an item x from the data structure if present.
 * search(x): Searches an item x in the data structure.
 * getRandom(): Returns a random element from current set of elements
 *
 * @author: Akhilesh Maloo
 * @date: 2/2/18.
 */
public class MyHashMapWithRandom {

    ArrayList<Integer> keySet = new ArrayList<>();

    // map carries key & value as List of index in ketSet Array
    HashMap<Integer, List<Integer>> valToIndex = new HashMap<>();

    public void add(int key) {

        if(!valToIndex.containsKey(key)) {
            keySet.add(key);
            List<Integer> list = new ArrayList<>();
            list.add(keySet.size()-1);
            valToIndex.put(key, list);
        } else {

            List<Integer> list = valToIndex.get(key);
            keySet.add(key);
            list.add(keySet.size()-1);
            valToIndex.put(key,list);
        }

    }

    public void remove(int k) {

        if(!valToIndex.containsKey(k))
            return;

        List<Integer> list = valToIndex.get(k);
        int indexToDel  = list.get(list.size()-1);

        // remove this from keySet in constant time
        int lastItem = keySet.get(keySet.size()-1);
        Collections.swap(keySet, indexToDel, keySet.size()-1);
        keySet.remove(keySet.size()-1);


        // resetting my map
        // 1. set correct index value of recently swapped item
        list = valToIndex.get(lastItem);
        list.set(list.size()-1, indexToDel);
        valToIndex.put(lastItem, list);

        // 2. remove index of deleted key in map
        list = valToIndex.get(k);
        if(list.size() == 1) {
            valToIndex.remove(k);
        } else {
            list.remove(list.size()-1);
            valToIndex.put(k , list);
        }
    }

    public Integer getRandom() {
        int random = (int)(Math.random() * keySet.size());
        return keySet.get(random);
    }

    public void display() {
        System.out.println("Map: " + valToIndex);
        System.out.println("KeySet: " + keySet);
        System.out.println();
    }


    public static void main(String[] args) {
        MyHashMapWithRandom map = new MyHashMapWithRandom();

        map.add(1);
        map.add(7);
        map.add(4);
        map.add(4);
        map.add(1);
        map.add(8);
        map.add(1);
        map.add(7);
        map.add(6);

        map.display();

        map.remove(8);

        map.display();

        System.out.println(map.getRandom());

    }

}
