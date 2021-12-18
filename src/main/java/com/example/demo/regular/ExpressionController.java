package com.example.demo.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionController {

    public static void main(String args[]) {
        String r = "${123}";
        String pattern = "\\$\\{(.+)\\}";
        Matcher m = Pattern.compile(pattern).matcher(r);
        String valueStr = r;
        // ${var}变量替换成userInfo中的值
        while (m.find()) {
            String s = m.group(1);
            System.out.println(s);
        }
    }
}