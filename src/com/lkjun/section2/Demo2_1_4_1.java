package com.lkjun.section2;

/**
 * Created by IntelliJ IDEA.
 * Author: Micro Jun
 * Date: 2020/3/8
 * File: Demo2_1_4.java
 */

/**
 * 深度优先搜索
 * 部分和问题
 * <p>
 * 给定整数a1,a2、、、an，判断是否可以从中选出若干数，是他们的和恰好为k
 * <p>
 * input：
 * n = 4;
 * a={1,2,4,7}
 * k = 13
 * <p>
 * output:
 * YES {13=2+4+7}
 */
public class Demo2_1_4_1 {

    static int[] a;
    static int n, k;

    void solve() {
        if (dfs(0, 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    boolean dfs(int i, int num) {

        if (num == k) {
            return true;
        }

        if(i == n) {
            return false;
        }

        if (dfs(i + 1, num)) {
            return true;
        }
        if (dfs(i + 1, num + a[i])) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        a = new int[]{1, 2, 4, 7};
        n = 4;
        k = 13;

        new Demo2_1_4_1().solve();
    }
}
