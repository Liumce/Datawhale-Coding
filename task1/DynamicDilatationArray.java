package task1;

/**
 * 功能：实现动态扩容
 * 数组数据类型：int
 * Created by liumao 2019/8/4
 **/
public class DynamicDilatationArray {

    //定义一个大小为20容量的静态数组
    static int[] array = new int[20];

    public static void main(String[] args) {

        array = dynamicDilatationArray(array);
        for (int i = 0;i<array.length;i++) {
            array[i] = i;
            System.out.println(array[i]);
        }
    }

    public static int [] dynamicDilatationArray(int [] array) {
        int [] newArray = new int[array.length*3];
        // arraycopy 可以实现将一个数组的指定个数元素复制到另一个数组中
        System.arraycopy(array,0,newArray,0,array.length);
        return newArray;

    }
}
