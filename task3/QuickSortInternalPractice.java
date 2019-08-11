package task3;

import java.util.Scanner;

/**
 * 功能：快排实现 O(n) 时间复杂度内找到一组数据的第 K 大元素
 * Created by liumao 2019/8/11 0011
 **/
public class QuickSortInternalPractice {
    //在O(n)时间复杂度里找到一个无序数组的第k大元素
    public static void findK(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        int k = new Scanner(System.in).nextInt() - 1;
        method(array, 0, n - 1, k);
    }

    public static void method(int[] array, int l, int r, int k) {
        if (k < l || k > r) {
            throw new IndexOutOfBoundsException("索引越界异常！");
        }
        if (l > r) {
            return;
        }
        int randomIndex = (int) Math.random() * (r - l + 1) + l;
        swap(array,l,randomIndex);
        int p = partition3(array, l, r);
        if (p > k) {
            method(array, l, p - 1, k);
        } else if (p < k) {
            method(array, p + 1, r, k);
        } else {
            System.out.println(array[p]);
        }
    }

    private static void swap(int[] array, int l, int randomIndex) {
//        int tep = 0;
//        array[tep] = array[l];
//        array[l] = array[randomIndex];
//        array[randomIndex] = tep;
    }

    public static int partition3(int[] array, int l, int r) {
        int val = array[l];
        int j = l;
        int i = l + 1;
        for (; i <= r; i++) {
            if (array[i] < val) {
                swap(array, j + 1, i);
                j++;
            }
        }
        swap(array, l, j);
        return j;
    }

}
