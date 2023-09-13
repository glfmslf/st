package com.yy.st;

import java.util.StringJoiner;

/**
 * @author yuyou
 * @since 2023/8/30 14:03
 */
public class PrintTest {
    public static void main(String[] args) {
        String orderNo = "510999920230411173634001";
        StringJoiner stringJoiner = new StringJoiner(",");
        for (int i = 0; i < 300; i++) {
            String temp = orderNo + i;
            stringJoiner.add(temp);
        }
        System.out.println(stringJoiner);
    }

}
