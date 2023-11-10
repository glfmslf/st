package com.yy.st.leetcode;

public class Solution {
    public static void main(String[] args) {
        int[] result = successfulPairs(new int[]{3, 1, 2}, new int[]{8,5,8}, 16);
        for (int i : result) {
            System.out.println(i);

        }
    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
       // 对potions排序
        quickSort(potions, 0, potions.length - 1);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int value = spells[i];
            int compareValue = (int) (success + value - 1) / value - 1;
            //查找>=compareValue 二分查找 下标
            res[i] = potions.length - middleSearch(potions, 0, potions.length - 1, compareValue);
        }
        return res;
    }

    private static int middleSearch(int[] potions,int min,int max,int compareValue) {
        int res = max + 1;
        while (min <= max) {
            int middle = min + (max - min) / 2;
            if (potions[middle] > compareValue) {
                res = middle;
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }
        return res;
    }

    private static void quickSort(int[] potions, int min, int max) {
        if (min < max) {
            int middle = partition(potions, min, max);
            quickSort(potions, min, middle - 1);
            quickSort(potions, middle + 1, max);
        }
    }

    private static int partition(int[] potions, int min, int max) {
        int baseValue = potions[max];
        int index = min - 1;
        for (int i = min; i < max; i++) {
            if (potions[i] < baseValue) {
                index++;
                int temp = potions[index];
                potions[index] = potions[i];
                potions[i] = temp;
            }
        }
        int temp = potions[++index];
        potions[index] = baseValue;
        potions[max] = temp;
        return index;
    }

}