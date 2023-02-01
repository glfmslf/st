package com.yy.st.sort;

/**
 * @author yuyou
 * @since 2023/2/1 14:03
 */
public class InsertionMain {

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 8, 9, 6, 1, 0};
        sort(a);
        BaseMain.printSortResult(a);
    }

    private static void sort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0 ; --j) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }
}
