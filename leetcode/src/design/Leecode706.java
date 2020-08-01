package design;

import java.util.Arrays;

public class Leecode706 {

    // Design HashMap Problem.

    // solution is MyHashMap Class
}


class MyHashMap {

    int[] keys;

    public MyHashMap() {
        keys = new int[10000];
        Arrays.fill(keys, -1);
    }


    public void put(int key, int value) {
        keys[key] = value;
    }


    public int get(int key) {
        if (keys[key] != -1) {
            return keys[key];
        }

        return -1;
    }

    public void remove(int key) {
        keys[key] = -1;
    }
}