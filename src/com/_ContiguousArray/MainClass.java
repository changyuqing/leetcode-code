package com._ContiguousArray;
/*
 * https://leetcode.com/problems/contiguous-array
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Solution {
    /* 这是我提交leetcode的代码，后来看了官方解答后发现其实只要一个数组存最左索引就可以了，还有就是可以用HashMap做
    public int findMaxLength(int[] nums) {
        // temp可以算一个0-n的nums子串的“和”，nums[i]=0->temp+1，nums[i]=1->temp-1
        int length = nums.length;
        int[] sumMinIndex = new int[length * 2 + 1];    // 创建子串和的最右索引数组
        int[] sumMaxIndex = new int[length * 2 + 1];    // 创建子串和的最左索引数组
        int temp = 0, min = 0, max = 0;
        sumMaxIndex[length] = sumMinIndex[length]=0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                temp += 1;
                if (temp > max) {
                    max = temp;
                    // 第一次出现和=temp时，最左索引=最右索引=i+1
                    sumMaxIndex[temp + length] = sumMinIndex[temp + length] = i+1;
                } else {
                    // 其他情况下只需要更新最右索引
                    sumMaxIndex[temp + length] = i+1;
                }
            } else {
                temp -= 1;
                if (temp < min) {
                    min = temp;
                    sumMaxIndex[temp + length] = sumMinIndex[temp + length] = i+1;
                } else {
                    sumMaxIndex[temp + length] = i+1;
                }
            }
        }

        int maxLength = 0;
        for (int i = min + length; i <= max + length; i++) {
            if (sumMaxIndex[i] - sumMinIndex[i] > maxLength) {
                maxLength = sumMaxIndex[i] - sumMinIndex[i];
            }
        }
        return maxLength;
    }
     */
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int temp = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i=0;i<nums.length;i++){
            temp = temp + (nums[i]==0?1:-1);
            if(map.containsKey(temp)){
                maxLength = Math.max(maxLength,i-map.get(temp));
            }else {
                map.put(temp,i);
            }
        }
        return maxLength;
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
            int[] nums = stringToIntegerArray(line);

            int ret = new Solution().findMaxLength(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
