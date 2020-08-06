package com.day3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapInsertionOrder {
    public static void main(String[] args) {

        Map<String, Integer> scoreMap = new LinkedHashMap<>();
        scoreMap.put("USA", 10);
        scoreMap.put("Japan", 9);
        scoreMap.put("Canada", 8);
        scoreMap.put("EU", 6);

        System.out.println(scoreMap);

        // LinkedHashMap keeps insertion order
        // HashMap does't keep insertion order



    }
}
