package com.yy.st.sort;

/**
 * 冒泡排序
 * @author yuyou
 * @since 2023/1/31 17:46
 */
public class BubbleSortMain {
    public static void main(String[] args) {

        int[] array = {9, 4, 3, 2, 9, 7, 1, 0, 5};
        bubble(array);
        BaseSortMain.printSortResult(array);
    }

    public static void bubble(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }

            }
            if (!flag) {
                break;
            }
        }
    }
}
