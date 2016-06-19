/*
 * Input:3 / * 2
 * Output:/ * 2 / 2 * * / 2 * 2 / 2 * / 2 / *
 * */

import java.util.Scanner;

public class Perm {

    public static void perm (Object[] list, int k, int m) {
        if (k == m) {
            for (int i = 0; i <= m; i++) {
                System.out.print(list[i] + " ");
            }
            //System.out.println();
        } else {
            for (int i = k; i <= m; i++) {
                swap(list, k, i);
                perm(list, k + 1, m);
                swap(list, k, i);
            }
        }
    }

    public static void swap(Object[] list, int k, int m) {
        Object t;
        t = list[k];
        list[k] = list[m];
        list[m] = t;
    }

    public static void main(String[] args) {
        String[] list = new String[100];
        //int i = 0;
        Scanner sc = new Scanner(System.in);

        /*
        String s = sc.nextLine();
        String str[] = s.split(" ");
        for (String num : str) {
            list[i++] = num;
        }
        */
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list[i] = sc.next();
        }

        //System.out.println();
        //perm(list, 0, i - 1);
        perm(list, 0, n - 1);
    }
}
