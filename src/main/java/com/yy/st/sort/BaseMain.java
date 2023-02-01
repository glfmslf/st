package com.yy.st.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author yuyou
 * @since 2023/2/1 14:12
 */
public class BaseMain {

    public static void printSortResult(int[] a) {
        System.out.println("排序结果");
        System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}
