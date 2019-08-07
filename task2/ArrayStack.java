package task2;

/**
 * 功能：用数组实现顺序栈
 * Created by liumao 2019/8/7 0007
 **/
public class ArrayStack {

    private String[] items;
    private int count;
    private int size;

    public ArrayStack(int size) {
        this.size = size;
        this.items = new String[size];
        this.count = 0;
    }
    public boolean push(String item) {
        if (count == size) return false;
        items[count] = item;
        ++count;
        return true;
    }
    public String pop() {
        if (count == 0) return null;
        String tmp = items[count-1];
        --count;
        return tmp;
    }
}
