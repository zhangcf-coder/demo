package com.example.demo.algorithm.service.impl;

import com.example.demo.algorithm.domain.ListNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class AlgorithmServiceImpl {

    /**
     * 题目：猜年龄
     * 美国数学家维纳（N.Wiener）智力早熟，11岁就上了大学，他曾在1935-1936年应邀来中国清华大学讲学，一次，他参加某个重要会议，年轻的脸孔引人注目，于是有人询问他的年龄，他回答：
     * <p>
     * “我年龄的立方是个4位数，我年龄的4次方是个六位数，这10个数字正好包含了从0到9这10个数字，每个都恰好出现1次，请你推算一下，他当时到底多年轻，
     * <p>
     * 通过浏览器，直接提交他那时的年龄数字，
     * <p>
     * 注意：不要提交解答过程，或其他的说明文字”
     */
    public static int calculateAge() {
        // 假设年龄是在10-100之间
        for (int i = 10; i < 100; i++) {
            int a = i * i * i;
            int b = a * i;
            String c = a + "";
            String d = b + "";
            String e = c + d;
            if (c.length() == 4 && d.length() == 6) {
                for (int j = 0; j < 10; j++) {
                    if (e.indexOf(j + "") < 0) {
                        break;
                    }
                    return i;
                }
            }
        }
        return 0;
    }

    /**
     * 问题描述
     * 　　现在时间是 a 点 b 分，请问 t 分钟后，是几点几分？
     * 输入格式
     * 　　输入的第一行包含一个整数 a。
     * 　　第二行包含一个整数 b。
     * 　　第三行包含一个整数 t。
     * 输出格式
     * 　　输出第一行包含一个整数，表示结果是几点。
     * 　　第二行包含一个整数，表示结果是几分。
     */
    public static void calculateTime() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        // 总分钟数 % 60 最终分钟数
        int i = (c + b) % 60;
        // 总分钟数 / 60 分钟折合后的小时数
        int k = (c + b) / 60;
        // 输入小时数 + 分钟折合后的小时数 = 总小时数
        // 总小时数 % 24 = 答案需要输出的小时数
        int m = (a + k) % 24;
        System.out.println("小时=" + m);
        System.out.println("分钟=" + i);
    }

    public static void main(String args[]) {
        calculateTime();
    }

    /**
     * 两数相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int ceil = 0;
        while (l1 != null || l2 != null) {
            int l1value = l1 != null ? l1.val : 0;
            int l2value = l2 != null ? l2.val : 0;
            int sum = l1value + l2value + ceil;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            ceil = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(ceil > 0) {
            tail.next = new ListNode(ceil);
        }
        return head;
    }

}
