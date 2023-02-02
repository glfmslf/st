package com.yy.st.sort;

/**
 * 归并排序
 * @author yuyou
 * @since 2023/2/2 18:22
 */
public class MergeSortMain {


    public static void merge(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (right - left) / 2 + left;
        merge(a, left, middle);
        merge(a, middle + 1, right);

    }

    public static void mergeData(int[] a, int[] p, int[] q, int left, int right, int middle) {
        int l = left;
        int r = right;
        int m = middle + 1;
        int k = 0;
        int[] result = new int[a.length];
        while (l < middle && middle < r) {
            if (a[l] <= a[m]) {
                result[k++] = a[l++];
            }else {
                result[k++] = a[m++];
            }
        }
        if (l <= right) {
            for (int i = l; i <= middle; i++) {
                result[k++] = a[i];
            }

        } else if (m <= r) {
            // q有剩余
            for (int i = m; i <= right; i++) {
                result[k++] = a[i];
            }
        }
    }
}
