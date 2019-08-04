package task1;

/**
 * 功能：单链表增删操作
 * Created by liumao 2019/8/4
 **/
public class SingleLinkedList {

    // 定义链表结点
    class Node{
        // 数据域
        int data;
        // 指针域
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static void main(String[] args) {

        SingleLinkedList sLinkedList = new SingleLinkedList();
        sLinkedList.insertvalue(1);
        sLinkedList.insertvalue(2);
        sLinkedList.insertvalue(3);
        sLinkedList.insertvalue(4);

        System.out.println("插入后：");
        sLinkedList.print();
//        System.out.println("按索引查找：" + sLinkedList.findByIndex(2));
        System.out.println("删除后：");
        sLinkedList.deleteByValue(3);
        sLinkedList.print();
    }

    //设置头结点为空
    private Node head = null;

    public void insertvalue(int value) {
        Node newNode = new Node(value,null);
        insertToTail(newNode);
    }

    public void insertToTail(Node newNode) {
        if (head==null){
            head = newNode;
            return;
        }
        Node p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = newNode;
    }

    public void insert(Node p,int value) {
        Node newNode = new Node(value,null);
        insert(p,newNode);
    }

    public void insert(Node p, Node newNode) {
        if (p==null){
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    public void deleteByValue(int value) {

        if (head==null){
            return;
        }
        Node p = head;
        Node q = null;
        while (p.next != null && p.data != value) {
            q = p;
            p = p.next;
        }
        q.next = p.next;

    }

    public void print() {
        Node p = head;
        while (p!=null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
    }

    public Node findByIndex(int index) {
        Node p  = head;
        int pos = 1;
        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }
}
