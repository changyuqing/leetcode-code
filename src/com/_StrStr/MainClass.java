package com._StrStr;

// https://leetcode.com/problems/implement-strstr

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
//        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
//            int j = 0;
//            for (; j < needle.length(); j++) {
//                if (haystack.charAt(i + j) != needle.charAt(j)) {
//                    break;
//                }
//            }
//            if (j == needle.length()) {
//                return i;
//            }
//        }
        int[] next = new int[needle.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < needle.length() - 1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        i = 0;
        j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }
}

public class MainClass {
    public static String stringToString(String input) {
//        System.out.println(input);
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String haystack = stringToString(line);
            line = in.readLine();
            String needle = stringToString(line);

            int ret = new Solution().strStr(haystack, needle);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}