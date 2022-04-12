package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MinStack {
    /**
     * initialize your data structure here.
     */
    /**
     * initialize your data structure here.
     */
    Stack stack;
    List<Integer> sortStackList;

    public MinStack() {
        stack = new Stack();
        sortStackList = new ArrayList<>();
    }

    public void push(int x) {
        stack.push(x);
        sortStackList.add(x);
    }

    public void pop() {
        stack.pop();
        if(sortStackList != null && sortStackList.size()>0) {
            sortStackList.remove(sortStackList.size() - 1);
        }

    }

    public int top() {
        if(stack.size() > 0) {
            return (int) stack.peek();
        }
        return -1;
    }

    public int min() {
        if (sortStackList != null && sortStackList.size()>0) {
            List<Integer> re = new ArrayList<>(sortStackList);
            Collections.sort(re);
            return re.get(0);
        }
        return -1;
    }

    public static void main(String args[]) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        System.out.println(minStack.top());
    }
}
