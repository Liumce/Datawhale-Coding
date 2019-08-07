package task2;

/**
 * 功能：数组、链表实现队列
 * Created by liumao 2019/8/7 0007
 **/

public class Queue<T> {

    public class ArrayQueue {
        private Object[] arrQueue;
        private int front;
        private  int rear;

        public ArrayQueue() {
        }

        public ArrayQueue(int size) {
            arrQueue = new Object[size];
            front = 0;
            rear = 0;
        }

        public boolean enQueue(Object obj) {
            if ((rear+1)%arrQueue.length==front){
                return false;
            }
            arrQueue[rear] = obj;
            rear = (rear+1)%arrQueue.length;
            return true;
        }

        public Object deQueue() {
            if (rear==front){
                return null;
            }
            Object obj = arrQueue[front];
            front = (front+1)%arrQueue.length;
            return obj;
        }

    }

    public class LinkedQueue {
        Node rear;
        Node front;
        private int size;

        public LinkedQueue(int size) {
            this.size = size;
            this.rear = null;
            this.front = null;
        }
        public class Node{
            T t;
            Node next;
        }

        public boolean isEmpty(){
            return rear == null;
        }

        public void enQueue(T data) {
            Node oldLast = front;
            front = new Node();
            front.next = null;
            if (size==0){
                front=rear;
            }else {
                oldLast = front;
            }
            size ++;
        }

        public T deQueue() {
            T t = rear.t;
            rear = front.next;
            if (size==0) front=null;
            size--;
            return t;
        }
    }
}
