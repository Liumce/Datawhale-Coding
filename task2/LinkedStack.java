package task2;

/**
 * 功能：用链表实现链式栈
 * Created by liumao 2019/8/7 0007
 **/

public class LinkedStack<T> {

    Node<T> top = null;
    public boolean isEmpty(){
        return top == null;
    }

    public void push(T data){
        Node<T> newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        T tmp = top.data;
        top = top.next;
        return tmp;
    }

    public T seek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }
}
class Node<T> {
    Node<T> next = null;
    T data;

    public Node(T data) {
        this.data = data;
    }
}

