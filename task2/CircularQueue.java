package task2;

/**
 * 功能：循环队列
 * Created by liumao 2019/8/7 0007
 **/
public class CircularQueue {

    private int[] items;
    private int size;

    private int head;
    private int tail;

    public CircularQueue() {
        this.head = 0;
        this.tail = 0;
    }
    public CircularQueue(int capacity){
        items = new int[capacity];
        size = capacity;
    }
    public Boolean enqueue(int data) {
        if ((tail+1)%size == head) return false;
        items[tail] = data;
        tail = (tail+1) % size;
        return true;
    }
    public int dequeue(){
        if (tail == head) return -1;
        int temp = items[head];
        head = (head+1) % size;
        return temp;
    }
    public void print() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i]+" ");
        }
    }
}
