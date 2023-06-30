package com.yy.st;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Console;

import java.util.UUID;

/**
 * @author yuyou
 * @since 2023/6/15 17:52
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println(Convert.digitToChinese(-11145.6111));
        System.out.println(Math.round(111.11 * 100.0));
        System.out.println(UUID.randomUUID());
        System.out.println(cn.hutool.core.lang.UUID.randomUUID());
        System.out.println(cn.hutool.core.lang.UUID.fastUUID());
        Console.log("1111111");
    }

}
