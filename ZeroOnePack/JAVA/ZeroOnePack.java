/*
 * Input:4 5 2 1 3 2 12 10 20 15
 * Output:1 1 0 1
 *
 * 状态转移方程：
 *
 * m(i, j) = max{m(i + 1, j), m(i + 1, j - w[i]) + v[i]}, j >= w[i]
 *           m(i + 1, j),                                 0 <= j < w[i]
 */

import java.util.Scanner;

public class ZeroOnePack {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();               //物品个数
        int c = sc.nextInt();               //背包容量

        int[] w = new int[n + 1];           //物品重量
        for (int i = 1; i <= n; i++)
            w[i] = sc.nextInt();

        int[] v = new int[n + 1];           //物品价值
        for (int i = 1; i <= n; i++)
            v[i] = sc.nextInt();

        int[][] m = new int[n + 1][c + 1];  //状态表
        knapsack(v, w, c, n, m);
        int[] x = new int[n + 1];           //生成解
        traceback(m, w, c, n, x);

        for (int i = 1; i <= n; i++)
            System.out.print(x[i] + " ");
    }

    /*
     * 构造状态表
     */
    public static void knapsack (int[] v, int[] w, int c, int n, int[][] m) {
        //初始化
        int Max = Math.min(w[n] - 1, c);
        for (int i = 0; i <= Max; i++)
            m[n][i] = 0;
        for (int i = w[n]; i <= c; i++)
            m[n][i] = v[n];

        for (int i = n - 1; i > 1; i--) {
            Max = Math.min(w[i] - 1, c);
            for (int j = 0; j <= Max; j++)
                m[i][j] = m[i + 1][j];
            for (int j = w[i]; j <= c; j++)
                m[i][j] = Math.max(m[i + 1][j], m[i + 1][j - w[i]] + v[i]);
        }
    }

    /*
     * 构造最优解
     */
    public static void traceback (int[][] m, int[] w, int c, int n, int[] x) {
        for (int i = 1; i < n; i++)
            if (m[i][c] == m[i + 1][c])
                x[i] = 0;
            else {
                x[i] = 1;
                c -= w[i];
            }
        x[n] = (m[n][c] > 0) ? 1 : 0;
    }
}
