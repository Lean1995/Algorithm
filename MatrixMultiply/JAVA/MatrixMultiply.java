/*
 * Input:6 30 35 15 5 10 20 25
 * Output:((A1(A2A3))((A4A5)A6))
 * */

import java.util.Scanner;

class MatrixMultiply {

    static int[][] s = new int[100][100];

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] p = new int[100];

        int n = sc.nextInt();
        for (int i = 0; i <= n; i++)
            p[i] = sc.nextInt();

        /*
        int n = 6;
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        */

        int u = RMC(1, n, p);

        /*
        System.out.println("u = " + u);
        System.out.println("s[][] = ");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
        */

        Print(1, n);
        System.out.println();
    }

    public static int RMC (int i, int j, int[] p) {
        if (i == j)
            return 0;
        int u = RMC(i, i, p) + RMC(i + 1, j, p) + p[i - 1] * p[i] * p[j];
        s[i][j] = i;
        for (int k = i + 1; k < j; k++) {
            int t = RMC(i, k, p) + RMC(k + 1, j, p) + p[i - 1] * p[k] * p[j];
            if (t < u) {
                u = t;
                s[i][j] = k;
            }
        }

        return u;
    }

    public static void Print (int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
            return ;
        } else {
            System.out.print("(");
            Print(i, s[i][j]);
            Print(s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
