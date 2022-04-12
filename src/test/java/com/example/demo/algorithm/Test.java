package com.example.demo.algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Test {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        int num = Integer.parseInt(in.nextLine());
//        int[] nums = new int[4095];
//        String[] s1 = str.split(",");
//        for(int i = 0; i < s1.length; i++) {
//            if(s1[i].contains("-")) {
//                String[] s2 = s1[i].split("-");
//                int start = Integer.parseInt(s2[0]);
//                int end = Integer.parseInt(s2[1]);
//                for(int j = start; j <= end; j++) {
//                    nums[j] = 1;
//                }
//            } else {
//                int n = Integer.parseInt(s1[i]);
//                nums[n] = 1;
//            }
//        }
//        nums[num] = 0;
//        StringBuilder sb = new StringBuilder();
//        for(int i = 1; i < nums.length; i++) {
//            if(nums[i] == 0) {
//                continue;
//            }
//            if(nums[i] == 1) {
//                if(nums[i-1] == 0 && nums[i+1] == 0) {
//                    sb.append(i + ",");
//                } else if(nums[i-1] == 0 && nums[i+1] != 0){
//                    sb.append(i + "-");
//                } else if(nums[i-1] != 0 && nums[i+1] != 0) {
//
//                }else if(nums[i-1] != 0 && nums[i+1] == 0) {
//                    sb.append(i + ",");
//                }
//            }
//        }
//        System.out.println(sb.toString().substring(0, sb.length() - 1));

//    }






    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String convert = in.nextLine();
        char[] chars = convert.toCharArray();
        int lCount = 0;
        int rCount = 0;
        int fCount = 0;
        int bCount = 0;
        int aCount = 0;
        int cCount = 0;
        for(int i = 0; i < convert.length(); i++) {
            String sub = convert.substring(i, i + 1);
            if(StringUtils.equals(sub, "L")) {
                lCount++;
            }
            if(StringUtils.equals(sub, "R")) {
                rCount++;
            }
            if(StringUtils.equals(sub, "F")) {
                fCount++;
            }
            if(StringUtils.equals(sub, "B")) {
                bCount++;
            }
            if(StringUtils.equals(sub, "A")) {
                aCount++;
            }
            if(StringUtils.equals(sub, "C")) {
                cCount++;
            }
        }
        int ll = 0;
        int rr = 0;
        int ff = 0;
        int bb = 0;
        int aa = 0;
        int cc = 0;
        int l = lCount - rCount;
        if(l < 0) {
            rr = (-l)%4;
        } else {
            ll = l%4;
        }
        int f = fCount - bCount;
        if(f < 0) {
            bb = -f%4;
        } else {
            ff = f%4;
        }
        int a = aCount - cCount;
        if(a < 0) {
            cc = -a%4;
        }else {
            aa = a%4;
        }

    }












}
