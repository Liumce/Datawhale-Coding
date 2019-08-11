package task3;

/**
 * 实现：归并排序、快速排序、插入排序、冒泡排序、选择排序、堆排序
 * Created by liumao 2019/8/11 0011
 **/
public class MergeSort {

    /**
     * 功能:递归分治数据
     * @param arr 要分治的数组
     * @param proir	数组起始位置
     * @param rear 数组终止位置
     */
    public void mergeSort(int[] arr, int proir, int rear) {
        //终止条件
        if (proir>=rear) return;;

        //取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int mid = proir + (rear-proir)/2;

        //递归分治
        mergeSort(arr,proir,rear);
        mergeSort(arr,mid+1,rear);

        //有序数组的合并
        merge(arr,proir,mid,rear);
    }
    /**
     * 功能: 合并 merge
     * @param arr 要合并的数组
     * @param proir 数组起始的下标
     * @param mid	第二个数组起始的下标
     * @param rear 数组结束的下标
     */
    private void merge(int[] arr, int proir, int mid, int rear) {
        int meProir = proir,meRear = mid+1,count = 0;

        int[] temp = new int[rear-proir+1];
        //两个有序数组合并
        while (meProir <= proir && meRear <= rear) {
            if (arr[meProir] <= arr[meRear]) {
                temp[count++] = arr[meProir++];
            }else {
                temp[count++] = arr[meRear++];
            }
        }
        int priorAfter  = proir;
        int midAfter = mid;
        if (meRear <= rear) {
            priorAfter = meRear;
            midAfter = rear;
        }
        while (priorAfter <= midAfter) {
            temp[count++] = arr[priorAfter];
        }
        for (int i = 0;i<= rear-proir; i++) {
            arr[proir+1] = temp[i];
        }
    }
}

