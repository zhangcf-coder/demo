package com.example.demo.algorithm;

import java.util.ArrayList;

public class Solution {

    public static int[] reversePrint(ListNode head) {
        ListNode current = head;

        ArrayList<Integer> result = new ArrayList<>();
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        int size = result.size();
        int[] arr = new int[size];
        int j = size - 1;
        if (size > 0) {
            for (Integer item : result) {
                arr[j] = item;
                j--;
            }
        }
        return arr;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode node = new ListNode(current.val);
            node.next = pre;
            pre = node;
            current = current.next;
        }
        return pre;
    }

    public Node copyRandomList(Node head) {
        Node result = null;
        Node current = head;
        while (current != null) {
            result = new Node(current.val);
            result.next = current.next;
            result.random = current.random;
            current = current.next;
        }
        return result;
    }

    /**
     * 替换字符串解法1 自己写的
     *
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        if (s.length() > 0) {
            String[] s1 = s.split(" ", -1);
            for (int i = 0; i < s1.length; i++) {
                stringBuffer.append(s1[i]);
                if (i != s1.length - 1) {
                    stringBuffer.append("%20");
                }
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 替换字符串解法2 官方写的
     *
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    public static String reverseLeftWords(String s, int n) {
        int length = s.length();
        char[] chars = new char[length];
        if (length > 0) {
            int split = 0;
            for (int i = 0; i < length; i++) {
                if (i >= n) {
                    chars[split] = s.charAt(i);
                    split++;
                } else {
                    chars[length - n + i] = s.charAt(i);
                }
            }
        }
        return new String(chars, 0, length);
    }

    public static void main(String args[]) {
//        ListNode head = new ListNode(1);
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        head.next = listNode1;
//        listNode1.next = listNode3;
//        ListNode ints = reverseList(head);
//        System.out.println(JSONUtils.toJSONString(ints));
//        ListNode listNode = reverseList(head);
//        System.out.println(JSONUtils.toJSONString(listNode));
//        Node head = new Node(7);
//        replaceSpace("     ");
        System.out.println(reverseLeftWords("abcdefg", 2));

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
