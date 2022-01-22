package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AlgorithmTest {



    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        List<Integer> list = new ArrayList<Integer>();
//        ListNode current = listNode;
//        while (current != null) {
//            list.add(current.val);
//            current = current.next;
//        }
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        for(int i = list.size() - 1; i>=0; i--) {
//            result.add(list.get(i));
//        }
//        return result;
        Stack stack = new Stack();
        stack.push("2");
        stack.peek();
        stack.pop();
        return null;
    }
    public static void main(String args[]) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        printListFromTailToHead(listNode1);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}