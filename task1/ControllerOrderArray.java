package task1;

/**
 * 功能：实现一个大小固定的有序数组，支持动态增删改操作
 * Created by liumao 2019/8/4
 **/
public class ControllerOrderArray {

    private int[] array;
    private int n;
    private int count;

    public ControllerOrderArray(int n) {
        this.n = n;
        count = 0;
        array = new int[n];
    }

    public static void main(String[] args) {

        ControllerOrderArray corderArr = new ControllerOrderArray(5);

        // 插入
        corderArr.insert(3);
        corderArr.insert(45);
        corderArr.insert(5);
        corderArr.insert(23);
        corderArr.insert(9);

        System.out.println("插入后数组：");
        corderArr.print();

        // 删除
        corderArr.delete(1);
        System.out.println("删除后数组：");
        corderArr.print();

        // 查找
        System.out.println();
        System.out.println("查找该数据的下标为：" + corderArr.find(45));

    }

    /**
     * 功能：插入
     *
     * @param value 插入的元素
     * @return 返回 Boolean类型 插入是否成功
     */
    public Boolean insert(int value) {
        // 判断是否为空
        if (array == null && array.length == 0) {
            return false;
        } else {
            if (count == 0) {
                array[count] = value;
                count++;
                return true;
            }
            // 判断是否大于最后一个元素
            if (value >= array[count - 1]) {
                array[count] = value;
                count++;
                return true;
            }

            // 其他数组元素相互比较挪动位置
            for (int i = 0; i < array.length; i++) {
                if (value >= array[i]) {
                    for (int j = count - 1; j >= i + 1; j--) {
                        array[j + 1] = array[j];
                    }
                    array[i + 1] = value;
                    count++;
                    return true;
                } else {
                    // 插入数组第一个位置
                    for (int j = count - 1; j >= 0; j--) {
                        array[j + 1] = array[j];
                    }
                    array[0] = value;
                    count++;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 功能：删除下标指定元素
     *
     * @param index
     * @return 返回删除的元素
     */
    public int delete(int index) {
        if (index < 0 || index >= array.length) {
            return -1;
        } else {
            for (int i = index; i < count - 1; i++) {
                array[i] = array[i + 1];
            }
        }
        count--;
        return 0;
    }

    /**
     * 功能：查找
     *
     * @param value 查找的元素
     * @return 返回该下标
     */
    public int find(int value) {
        for (int i = 0; i <= count - 1; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }


    //打印数组
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
