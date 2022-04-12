package com.example.demo.collection;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

public class HashMapTest {

    @Test
    private void showLinkToTree() {
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

    @Test
    private void showReplaceAllMethod() {
        HashMap<String, Integer> map = new HashMap(16);
        map.put("1", 2);
        map.put("2", 3);
        map.put("3", 4);
        map.replaceAll((key, value) -> value + 1 );
        map.replace("3", 12);
        System.out.println(JSONObject.toJSONString(map));
    }

    @Test
    private void showMergeMethod() {
        HashMap<String, Integer> map = new HashMap(16);
        map.put("1", 2);
        map.put("2", 13);
        map.put("3", 4);
        map.merge("9", 4, (oldValue, value) -> oldValue+1 );
        System.out.println(JSONObject.toJSONString(map));
    }

    @Test
    private void showComputeMethod() {
        HashMap<String, Integer> map = new HashMap(16);
        map.put("1", 2);
        map.put("2", 13);
        map.put("3", 4);
        map.compute("2", (key, value) -> value + 3);
        System.out.println(JSONObject.toJSONString(map));
    }
}
