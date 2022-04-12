package com.example.demo.algorithm;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    public static int findRepeatNumber(int[] nums) {
        int result = -1;
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean add = sets.add(nums[i]);
            if (!add) {
                return nums[i];
            }
        }
        return result;
    }

    public static int findRepeatNumber1(int[] nums) {
        int arrs[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrs[nums[i]]++;
            if (arrs[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int size = nums.length;
        int start = 0;
        int end = size - 1;
        int mid = size / 2;
        int j = 1;
        int count = 1;
        for (int i = 0; i < size; i++) {
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                while (true) {
                    if (mid + j < size - 1 && nums[mid + j] == target) {
                        count++;
                    } else if (mid - j >= 0 && nums[mid - j] == target) {
                        count++;
                    } else {
                        return count;
                    }
                    j++;
                }
            }
            mid = (end + start) / 2;
        }

        return 0;
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                arr[0] = arr[i];
            } else if (arr[i] < arr[1]) {
                arr[1] = arr[i];
            } else if (arr[i] < arr[2]) {
                arr[2] = arr[i];
            } else if (arr[i] < arr[3]) {
                arr[3] = arr[i];
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private int getNode(TreeNode root) {
        return 0;
    }

    public char firstUniqChar(String s) {
        if (s == "") return ' ';
        int[] arr = new int[26];
        int size = s.length();
        for (int i = 0; i < size; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < size; i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return (isSymmetric1(root.left, true) == isSymmetric1(root.right, false)) &&
                (isSymmetric1(root.right, false) == isSymmetric1(root.left, true));
    }

    private static int isSymmetric1(TreeNode root, boolean b) {
        if (b) {
            if (root.left != null) {
                isSymmetric1(root.left, b);
            }
        } else {
            if (root.right != null) {
                isSymmetric1(root.right, b);
            }

        }
        return root.val;
    }

//    /**
//     * 镜像反转
//     * @param root
//     * @return
//     */
//    public TreeNode mirrorTree(TreeNode root) {
//        return mirrorTree2(root.left, root.right);
//    }

//    private TreeNode mirrorTree2(TreeNode leftRoot, TreeNode rightRoot) {
//        if(root.left == null && root.right == null) {
//            return root;
//        }
//        mirrorTree2(root.left);
//        TreeNode val = root.right;
//        root.right = root.left;
//        root.left = val;
//        return root;
//    }

    public static int[] printNumbers(int n) {
        StringBuffer lenStr = new StringBuffer("1");
        for (int i = 0; i < n; i++) {
            lenStr.append("0");
        }

        int len = Integer.parseInt(lenStr.toString());
        int[] ints = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode pre = null;
        ListNode current = head;
        ListNode newNode = head;
        while (current != null) {
            ListNode node = new ListNode(current.val);
            if (i >= m && i <= n) {
                node.next = pre;
                pre = node;
                if (i == n) {
                    if (newNode == null) {
                        newNode = node;
                    } else {
                        newNode.next = pre;
                    }

                }
            } else if (i > n) {
                newNode.next = current;
                break;
            }
            current = current.next;
            i++;
        }
        return newNode;
    }

    /**
     * 天啊 算法太难了
     * 想不出来啊
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (current.val == next.val) {
                current = current.next;
            }
        }

        return head;
    }


    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode pre = list1;
        while (current1 != null && current2 != null) {
            if (current1 == null) {
                pre.next = current2;
            } else if (current2 == null) {
                return list1;
            } else if (current1.val < current2.val) {
                ListNode node = new ListNode(current2.val);
                pre.next = node;
                node.next = current2;
                current2.next = current1;
                current2 = current2.next;
            }
            pre = current1;
            current1 = current1.next;
        }
        return list1;
    }

    public static ListNode copyListNode(ListNode head) {
        int i = 1;
        ListNode pre = null;
        ListNode current = head;
        ListNode newNode = null;
        while (current != null) {

        }
        return newNode;
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
//        System.out.println(reverseLeftWords("abcdefg", 2));

//        int[] nums = new int[]{18, 3, 1, 0, 2, 5, 7};
//        int repeatNumber = findRepeatNumber1(nums);
//        System.out.println("repeatNumber=" + repeatNumber);
//        int[] nums = new int[]{1, 2, 3};
//        int count = search(nums, 6);
//        System.out.println("count=" + count);
//        System.out.println('b' - 'a');
// =================开始========================================
//
//        TreeNode head = new TreeNode(1);
//        TreeNode treeNode1 = new TreeNode(2);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(3);
////        TreeNode treeNode5 = new TreeNode(6);
////        TreeNode treeNode6 = new TreeNode(9);
//        head.right = treeNode1;
//        head.left = treeNode2;
////        treeNode1.left = treeNode3;
//        treeNode1.right = treeNode3;
////        treeNode2.left = treeNode5;
//        treeNode2.right = treeNode4;
//        System.out.println(isSymmetric(head));
        // =================结束========================================

        // =================开始========================================
//        int[] result = {0,0,1,2,4,2,2,3,1,4};
//        int[] leastNumbers = getLeastNumbers(result, 8);
//        System.out.println(JSONObject.toJSON(leastNumbers));

        // =================结束========================================

        // =================开始========================================
//        System.out.println(JSONObject.toJSON(printNumbers(2)));
        // =================结束========================================

        // =================开始========================================
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        reverseBetween(head, 1, 1);
        // =================结束========================================
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
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
