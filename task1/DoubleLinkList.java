package task1;

/**
 * 功能：双向链表实现增删操作
 * Created by liumao 2019/8/4
 **/
public class DoubleLinkList<T> {

    private Link<T> prior;
    private Link<T> next;

    class Link<T> {
        public T val;
        public Link<T> next;
        public Link<T> pre;

        public Link(T val) {
            this.val = val;
        }
        public void displayCurrentNode() {
            System.out.println(val + " ");
        }
    }

    //初始化首尾指针
    public DoubleLinkList() {
        prior = null;
        next = null;
    }
    public boolean isEmpty() {
        return prior == null;
    }

    //从尾部依次增加，下标往后移
    public void addList(T value) {
        Link<T> newLink = new Link(value);
        if (isEmpty()) {
            next = newLink;
        }else {
            prior.pre = newLink;
        }
        newLink.next = prior;
        prior = newLink;
    }

    // 从头删除
    public void delete() {
        if (prior.next == null) {
            next = null;
        }else {
            prior.next.pre = null;
        }
        prior = prior.next;
    }

    //输出双向链表元素
    public void display() {
        Link<T> cur = prior;
        while (cur!=null) {
            cur.displayCurrentNode();
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        DoubleLinkList<Integer> dList = new DoubleLinkList<Integer>();
        dList.addList(1);
        dList.addList(4);
        dList.addList(7);
        dList.addList(45);
        dList.addList(8);
        dList.addList(70);
        dList.addList(4551);
        dList.display();

        System.out.println("========");
        dList.delete();
        dList.display();

    }
}
