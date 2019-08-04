package task1;

/**
 * 功能：合并两个有序数组
 * Created by liumao 2019/8/4 0004
 **/
public class MergeArray {
    static int[] arr1 = new int[] {1,2,3,4,5};
    static int[] arr2 = new int[] {8,9};
    static int[] arr3 = new int[arr1.length + arr2.length];

    public static void main(String[] args) {
        merge(arr1,arr2,arr3);
        for (int i = 0;i<arr3.length;i++){
            System.out.print(arr3[i] + " ");
        }
    }

    /**
     * 功能：合并两个有序数组
     * @param a 数组a
     * @param b 数组b
     * @param c 合并数组
     */
    public static void merge(int [] a, int[] b, int[] c) {
        if (a==null||b==null) {
            return;
        }else {
            int i = 0;
            int j = 0;
            int n = 0;
            while (i<a.length && j<b.length) {
                if (a[i]<=b[j]) {
                    c[n] = a[i];
                    i++;
                    n++;
                }else {
                    c[n] = b[j];
                    j++;
                    n++;
                }
            }
            while (i>=a.length) {
                if (j<b.length) {
                    c[n] = b[j];
                    j++;
                    n++;
                }else {
                    break;
                }
            }

        }
    }
}
