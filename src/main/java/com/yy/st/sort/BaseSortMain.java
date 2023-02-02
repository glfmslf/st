package com.yy.st.sort;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author yuyou
 * @since 2023/2/1 14:12
 */
public class BaseSortMain {

    public static void printSortResult(int[] a) {
        System.out.println("排序结果");
        System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    public static void main(String[] args) {
        int[][] a = new int[100000][2000];
        int n = a.length;
        int length = a[0].length;
        int[][] in = new int[n][length];
        long cu = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < length; j++) {
                int c = new Random().nextInt(length);
                a[i][j] = c;
                in[i][j] = c;
            }
        }
        System.out.println("数据创建完成 coast = " + (System.currentTimeMillis() - cu) + "  " + LocalDateTime.now());

        long current = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int[] b = a[i];
            BubbleSortMain.bubble(b);
        }
        System.out.println("冒泡排序耗时 coast = " + (System.currentTimeMillis() - current) + "  " + LocalDateTime.now());

        long current2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int[] b  =in[i];
            InsertionSortMain.sort(b);
        }
        System.out.println("插入排序耗时 coast = " + (System.currentTimeMillis() - current2) + "  " + LocalDateTime.now());
        System.out.println("总耗时 coast = " + (System.currentTimeMillis() - cu) + "  " + LocalDateTime.now());

    }
}
