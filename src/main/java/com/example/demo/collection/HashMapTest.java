package com.example.demo.collection;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String args[]) {
        // 演示链表转红黑树代码
//        showLinkToTree();
        // 演示

    }

    private static void showLinkToTree() {
        HashMap<Integer, Integer> map = new HashMap(16);

        int j = 0;
        for(int i = 0; i < 9; i++) {
            map.put(j, i);
            j+=16;
        }

        j = 0;
        for(int i = 0; i < 7; i++) {
            map.remove(j, i);
            j+=16;
        }
    }
}
