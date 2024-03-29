package task3;

/**
 * 快排
 * Created by liumao 2019/8/11 0011
 **/
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = new int[] {4,3,7,2,9,1};
        quickSort.quickSort(a, 6);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public void quickSort(int a[],int n) {
        quickSortInternally(a,0,n-1);
    }

    /**
     * 功能:快速排序递归函数
     * @param a 数组
     * @param arrProir 起始位置
     * @param arrRear 终止位置
     */
    private void quickSortInternally(int[] a, int arrProir, int arrRear) {
        //终止条件
        if(arrProir >= arrRear) return;

        //获取区分点 pivot
        int q = partition(a, arrProir, arrRear);

        //区分点两端开始递归
        quickSortInternally(a,arrProir,q-1);
        quickSortInternally(a,q+1,arrRear);
    }

    /**
     * 功能:获取区分点
     * @param a 数组
     * @param p 起始位置
     * @param r 终止位置
     * @return 返回区分点
     */
    public int partition(int[] a,int p,int r) {
        //将最后一个元素作为区分点
        int pivot = a[r];
        int i = p;

        for (int j = p; j < r; ++j) {
            if(a[j] < pivot) {
                //确保 i 永远指向第一个大于 pivot 的数
                if(i == j) {
                    i++;
                }else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;

        System.out.println("i=" + i);
        return i;
    }
}
