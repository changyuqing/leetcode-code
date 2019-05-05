package com._ReverseKGroup;

// https://leetcode.com/problems/reverse-nodes-in-k-group

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode t, t1, t2, t3, tH, tT, tT1, tT2, newHead;
        newHead = new ListNode(0);
        newHead.next = head;
        tT = tH = newHead;
        while (tT.next != null) {
            for (int i = 0; i < k && tT != null; i++) {
                tT = tT.next;
            }
            if (tT == null) {
                return newHead.next;
            }
            tT = tT.next;

            t = t1 = tH.next;
            t2 = t1.next;
            t1.next = tT;
            for (int i = 1; i < k; i++) {
                t3 = t2.next;
                t2.next = t1;
                t1 = t2;
                t2 = t3;
            }
            tH.next = t1;
            tH = tT = t;
        }
        return newHead.next;
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
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            ListNode ret = new Solution().reverseKGroup(head, k);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}