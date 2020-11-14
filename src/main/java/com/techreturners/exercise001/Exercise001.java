package com.techreturners.exercise001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exercise001 {

    // In this Kata, you will be given an array of numbers in which two numbers occur once and the rest occur only twice. 
    // Your task will be to return the sum of the numbers that occur only once.
    // For example, repeats([4,5,7,5,4,8]) = 15 because only the numbers 7 and 8 occur once, and their sum is 15.

    // More examples in exercise001 test cases.

    // Good luck!

    public int singles(int[] arr) {
        // Add your code here!
        int sum = 0;
        int singlesCount = 0;

        HashMap<Integer, Integer> singlesMap = new HashMap<>();

        // Populate map with ints and count of int from arr
        for (int i = 0; i < arr.length; i++) {
            if (singlesMap.containsKey(arr[i])) {
                singlesMap.put(arr[i], singlesMap.get(arr[i]) + 1);
            } else {
                singlesMap.put(arr[i], 1);
            }
            //Java 8 version
            // singlesMap.merge(arr[i], 1, (oldValue, newValue) -> oldValue + 1);
        }

        // Sum unique values
        for (Map.Entry<Integer, Integer> entry : singlesMap.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }

        return sum;
    }
}
