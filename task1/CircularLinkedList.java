package task1;

/**
 * 功能：循环链表的增删操作
 * Created by liumao 2019/8/4
 **/
public class CircularLinkedList {

    public static class LNode {
        private int data;
        private LNode next;

        public LNode(int data) {
            this.data = data;
            this.next = null;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public LNode getNext() {
            return next;
        }

        public void setNext(LNode next) {
            this.next = next;
        }

    }

    private LNode headNode;

    public CircularLinkedList() {
        headNode = null;
    }

    public int CircularListLength() {
        int length = 0;
        LNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
            if (headNode == currentNode){
                break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        for (int i = 0;i<5;i++) {
            circularLinkedList.insert(new LNode(1));
        }
        circularLinkedList.deleteNode();
        circularLinkedList.PrintCircularList();
    }

    public void insert(LNode nodeInsert) {
        if (headNode == null) {
            headNode = nodeInsert;
            headNode.setNext(headNode);
        }else {
            LNode currentNode = headNode;
            while (currentNode.getNext() != headNode){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(nodeInsert);
            nodeInsert.setNext(headNode);
        }
    }

    public void deleteNode() {
        LNode temp = headNode;
        LNode currentNode = headNode;
        if (headNode == null) {
            System.out.println("List Empty");
            return;
        }

        while (currentNode.getNext() != headNode) {
            temp = currentNode;
            currentNode = currentNode.getNext();
            return;
        }
    }

    public void PrintCircularList() {
        LNode currentNode = headNode;
        while (currentNode != null) {
            System.out.println(currentNode.getNext() + " ------");
            currentNode  = currentNode.getNext();
            if (currentNode == headNode){
                break;
            }
        }
        System.out.println(currentNode.getData());
    }
}
