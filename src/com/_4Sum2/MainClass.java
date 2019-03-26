package com._4Sum2;
/*
 * https://leetcode.com/problems/4sum-ii
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;

        Map<Integer,Integer> AB = new HashMap<Integer,Integer>();
        for (int a:A){
            for (int b:B){
                if(AB.containsKey(a+b)){
                    AB.put(a+b, AB.get(a+b)+1);
                }else {
                    AB.put(a+b,1);
                }
            }
        }
        for (int c:C){
            for (int d:D){
                if(AB.containsKey(-c-d)){
                    count+=AB.get(-c-d);
                }
            }
        }

        return count;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);
            line = in.readLine();
            int[] B = stringToIntegerArray(line);
            line = in.readLine();
            int[] C = stringToIntegerArray(line);
            line = in.readLine();
            int[] D = stringToIntegerArray(line);

            int ret = new Solution().fourSumCount(A, B, C, D);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}