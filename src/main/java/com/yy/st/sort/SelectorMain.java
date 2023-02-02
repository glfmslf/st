package com.yy.st.sort;

/**
 * @author yuyou
 * @since 2023/2/1 15:42
 */
public class SelectorMain {
    public static void main(String[] args) {
        int[] a = {11, 5, 8, 66, 0, 3, 2, 7, 6};
        sort(a);
        BaseMain.printSortResult(a);
    }


    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
    }
}
