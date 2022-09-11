package com.yy.st.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author: yuyou
 * CREATED_DATE: 2022/1/21 5:04 下午
 */
public class User {

    @JSONField(serialize = false)
    public Integer getAge() {
        System.out.println("1++++++");
        return 1;
    }


    @JsonIgnore
    public Integer getName() {
        System.out.println("2+++++++");
        return 2;
    }

    public boolean isSex() {
        System.out.println("3++++++++++++");
        return false;
    }

    public Integer findSome() {
        System.out.println("4++++++++++++");
        return 4;
    }

    public Integer checkXXX() {
        System.out.println("5+++++++++");
        return 5;
    }

    public boolean checkYYY() {
        System.out.println("6++++++++");
        return false;
    }
    public static String reverseOnlyLetters(String s) {
        int left = 0;
        int length = s.length();
        int right = length - 1;
        char[] sArry = s.toCharArray();
        while(left < right){
            if(!Character.isLetter(s.charAt(left))){
                left ++;
                continue;
            }
            if(!Character.isLetter(s.charAt(right))){
                right--;
                continue;
            }
            char temp = sArry[left];
            sArry[left] = sArry[right];
            sArry[right] = temp;
            left++;
            right--;
        }
        return new String(sArry);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result1 = new ListNode(0);
        ListNode result = result1;
        ListNode l11 = l1;
        ListNode l22 = l2;
        int carry = 0;
        while(l11 !=null || l22 != null){
            int l = 0;
            int r = 0;
            if(l11 != null){
                l = l11.val;
            }
            if(l22 != null){
                r = l22.val;
            }
            int n = (l + r + carry) % 10;
            carry = (l + r + carry) / 10;
            result.next = new ListNode(n);
            l11 = l11.next;
            l22 = l22.next;
            result = result1.next;
        }
        if(carry > 0){
            result.next = new ListNode(carry);
        }
        return result1.next;
    }

    public static void main(String[] args) throws JsonProcessingException {

//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        System.out.println(addTwoNumbers(l1,l2));
//        String s = "2";
//        System.out.println(s.charAt(3));
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime localDateTime1 = localDateTime;
//        LocalDateTime localDateTime2 = localDateTime.plusDays(1);
//        System.out.println(localDateTime.isBefore(localDateTime1));
//        System.out.println(localDateTime.compareTo(localDateTime1));
//        System.out.println(localDateTime.compareTo(localDateTime2));
//        System.out.println(localDateTime.isAfter(localDateTime1));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.stream().filter(i -> i==2).findFirst().orElse(null));
        }


        //        Integer i = null;
//
//        System.out.println(String.valueOf(i) == null);
//        System.out.println("null".equals(String.valueOf(i)));

//        System.out.println(pushDominoes2(".L.R...LR..L.."));

    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        Deque<Integer> queue = new ArrayDeque<>();
        int[] time = new int[n];
        Arrays.fill(time, -1);
        List<Character>[] force = new List[n];
        for (int i = 0; i < n; i++) {
            force[i] = new ArrayList<Character>();
        }
        for (int i = 0; i < n; i++) {
            char f = dominoes.charAt(i);
            if (f != '.') {
                queue.offer(i);
                time[i] = 0;
                force[i].add(f);
            }
        }

        char[] res = new char[n];
        Arrays.fill(res, '.');
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (force[i].size() == 1) {
                char f = force[i].get(0);
                res[i] = f;
                int ni = f == 'L' ? i - 1 : i + 1;
                if (ni >= 0 && ni < n) {
                    int t = time[i];
                    if (time[ni] == -1) {
                        queue.offer(ni);
                        time[ni] = t + 1;
                        force[ni].add(f);
                    } else if (time[ni] == t + 1) {
                        force[ni].add(f);
                    }
                }
            }
        }
        return new String(res);
    }

    public static String pushDominoes2(String dominoes) {
//        .L.R...LR..L..
        char[] s = dominoes.toCharArray();
        int n = s.length, i = 0;
        char left = 'L';
        while (i < n) {
            int j = i;
            while (j < n && s[j] == '.') { // 找到一段连续的没有被推动的骨牌
                j++;
            }
            char right = j < n ? s[j] : 'R';
            if (left == right) { // 方向相同，那么这些竖立骨牌也会倒向同一方向
                while (i < j) {
                    s[i++] = right;
                }
            } else if (left == 'R' && right == 'L') { // 方向相对，那么就从两侧向中间倒
                int k = j - 1;
                while (i < k) {
                    s[i++] = 'R';
                    s[k--] = 'L';
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(s);
    }
}
