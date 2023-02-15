package com.yy.st.sort;

/**
 * 归并排序
 * @author yuyou
 * @since 2023/2/2 18:22
 */
public class MergeSortMain {

    public static void main(String[] args) {
        int[] a = {3, 5, 6, 2, 4, 0, 9, 1, 5, 6, 7};
        int[] result = merge(a,0,a.length - 1);
        BaseSortMain.printSortResult(result);

    }


    public static int[] merge(int[] a, int left, int right) {
        if (left >= right) {
            return new int[]{a[left]};
        }
        int middle = (right - left) / 2 + left;
        merge(a, left, middle);
        merge(a, middle + 1, right);
        return mergeData(a, left, right, middle);
    }

    public static int[] mergeData(int[] a, int left, int right, int middle) {
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
        return result;
    }
}
