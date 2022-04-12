package com.example.demo.algorithm;

import com.google.common.collect.Lists;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

@Test
public class AlgorithmTest {

    @Mock
    private MinStack minStack;

    @Test
    public void a() {
//        Mockito.when(minStack).

        Mockito.doAnswer(new Answer<Object>() {
            public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                return "called with arguments: " + args;
            }
        }).when(minStack).min();
    }

//    public ListNode reverseBetween (ListNode head, int m, int n) {
//        ListNode current = head;
//        int i = 0;
//        while(current != null) {
//            if(i<m || i > n) {
//                current = current.next;
//                i++;
//            } else {
//                reverse(current);
//            }
//
//        }
//    }
//    private ListNode reverse(ListNode listNode) {
//
//        reverse(listNode);
//    }


    public static int[] preorderTraversal(TreeNode root) {
        // write code here
        List<Integer> all = new ArrayList();
        dfs(root, all);
        int nums[] = new int[all.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = all.get(i);
        }
        return nums;
    }

    private static void dfs(TreeNode root, List<Integer> all) {
        if (root != null) {
            all.add(root.val);
            dfs(root.left, all);
            dfs(root.right, all);
        }
    }

    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if(root == null) {
            return null;
        }
        // write code here
        ArrayList<ArrayList<Integer>> result =  new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left != null) {
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(list);
        }
        return result;
    }

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
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        printListFromTailToHead(listNode1);

        // ==========Merge开始=====================
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode12 = new ListNode(3);
//        ListNode listNode13 = new ListNode(5);
//        listNode1.next = listNode12;
//        listNode12.next = listNode13;
//
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode21 = new ListNode(4);
//        ListNode listNode23 = new ListNode(6);
//        listNode2.next = listNode21;
//        listNode21.next = listNode23;
//        ListNode merge = Merge(listNode1, listNode2);
//        System.out.println(merge);
        // ==========Merge结束=====================

//        int i = 1;
//        int j = 2;
//        int k = 9;
//        System.out.println((k & (i | j) ));
//        if((k & (i | j) ) != 0) {
//            System.out.println("k & (i | j) ) != 0");
//        } else {
//            System.out.println("k & (i | j) ) == 0");
//        }

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        node1.right = node2;
//        node2.left = node3;
//
//        preorderTraversal(node1);
//      =============================================
//        TreeNode treeNode = new TreeNode(1);
//        TreeNode treeNodeLeft = new TreeNode(2);
//        TreeNode treeNodeRight = new TreeNode(3);
//        TreeNode treeNodeLeftLeft = new TreeNode(5);
//        treeNode.left = treeNodeLeft;
//        treeNode.right = treeNodeRight;
//        treeNodeLeft.left = treeNodeLeftLeft;
//        System.out.println(getRigth(treeNode));
//      =============================================
        ListNode head1 = new ListNode(9);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(7);
        head1.next = node1;
        node1.next = node2;

        ListNode head2 = new ListNode(6);
        ListNode node22 = new ListNode(3);
        head2.next = node22;
        addInList (head1, head2);

    }

    public static List<Integer> getRigth(TreeNode treeNode) {
        if(treeNode == null) {
            return null;
        }
        List<Integer> result = Lists.newArrayList();

        Queue<TreeNode> list = new LinkedList<TreeNode>();
        list.offer(treeNode);
        while (!list.isEmpty()) {
            int size = list.size();
            for(int i = 0; i < size; i++) {
                TreeNode p = list.poll();
                if(p.left != null) {
                    list.offer(p.left);
                }
                if(p.right != null) {
                    list.offer(p.right);
                }
                if(i == size -  1) {
                    result.add(p.val);
                }
            }

        }
        return result;
    }


    public static ListNode Merge(ListNode list1, ListNode list2) {
        return null;
    }

    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList (ListNode head1, ListNode head2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        addStatck(list1, head1);
        addStatck(list2, head2);
        int add = 0;
        ListNode pre = null;
        while(!list1.isEmpty() || !list2.isEmpty() || add != 0) {
            int sum = add;
            if(!list1.isEmpty()) {
                sum+=list1.pop();
            }
            if(!list2.isEmpty()) {
                sum+=list2.pop();
            }
            ListNode listNode = new ListNode(sum % 10);
            listNode.next = pre;
            pre = listNode;
            add = 0;
            if(sum > 9) {
                add = sum/10;
            }
        }
        return pre;

    }

    private static void addStatck(LinkedList<Integer> list, ListNode node) {
        while(node != null){
            list.push(node.val);
            node = node.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}