package task1;

/**
 * 功能：实现单链表反转
 * Created by liumao 2019/8/5
 **/
public class ReverseLinkedList {

    static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
        // 生成一个新的结点
        public static Node createNode(int value) {
            return new Node(value,null);
        }

        /**
         * 功能：单链表反转  1234   4321
         * 若存在没有遍历完的结点，头指针就向后移动，继续遍历
         * @param  list 反转链表
         */
        public static Node reverse(Node list) {
            //定义头结点
            Node headNode = null;
            //定义尾指针
            Node preNode = null;
            //指向list链表
            Node currentNode = list;
            //如果指针指向的链表不为空
            while (currentNode != null) {
                //先将指针指向的结点中存储的下一个结点地址存储到nextNode中
                Node nextNode = currentNode.next;
                //判断指针指向该结点是否有结点，若null，则指针处于链表的最后一位，该结点的最后一位结点为null,即没有结点
                if (nextNode == null) {
                    //如果是最后一个结点，则把它作为反转链表的头结点
                    headNode = currentNode;
                }
                //将反转后的链表地址存储到在单链表拆解下来的结点地址域中
                currentNode.next = preNode;
                //尾结点向前移动一个结点
                preNode = currentNode;
                //头指针向后移动
                currentNode = nextNode;
            }
            return headNode;
        }

        /**
         * 功能:单链表的合并
         * @param node1:链表 node1
         * @param node2:链表 node2
         * @return
         */
        public static Node mergeSortedLists(Node node1, Node node2) {
            //判断两个单链表是否为null
            if (node1 == null) return node2;
            if (node2 == null) return node1;
            //分别将两个链表赋值给 p、q
            Node p = node1;
            Node q = node2;
            //定义一个头结点
            Node head;
            //比较两个结点数据域中元素的大小
            if (p.data < q.data) {
                //如果  p 数据小于 q 数据，将 p 结点赋值给head
                head = p;
                //数据小的那条链表的指针向后移动一位
                p = p.next;
            } else {
                //否则，移动另一个指针
                head = q;
                q = q.next;
            }
            //将 head 结点赋值给 r
            Node r = head;
            //判断两个链表指针指到最后一个结点,要想跳出循环，肯定p、q其中有一个先遍历完
            while (p != null && q != null) {
                //如果没有指到最后的结点,继续进行比较大小
                if (p.data < q.data) {
                    //r 继承着 head 继续向下添加结点
                    r.next = p;
                    p = p.next;
                } else {
                    r.next = q;
                    q = q.next;
                }
                //r 指针向下移动，指向新添加的结点
                r = r.next;
            }
            //判断 p、q 两个链表哪一个先遍历完，最后将剩余的链表拼接合成到链表的最后
            if (p != null) {
                r.next = p;
            } else {
                r.next = q;
            }
            //返回头结点
            return head;
        }
    }
    /**
     * 功能:求中间结点
     * 思路:定义一个指针 fast 用来移动做逻辑判断
     * @param list:传入要求中间结点的链表
     * @return
     */
    public static Node findMiddleNode(Node list) {
        //如果单链表为 null,就返回 null
        if (list == null) return null;
        //slow 指向的就是 fast.next 与 fast.next.next 中间的那个结点
        Node fast = list;
        Node slow = list;
        //循环遍历满足fast指针条件单链表
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //返回的slow就是中间结点
        return slow;
    }
    //输入链表的所有值
    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
}
