package Book.Part2;

public class LinkedListNode {
    public  LinkedListNode head, next, previous, last;
    public int data;

    public LinkedListNode(int data, LinkedListNode n, LinkedListNode p) {
        this.data = data;
        setNext(n);
        setPrevious(p);
        this.head = p;
        this.last = n;
    }

    public LinkedListNode(int data) {
        this.head = this;
        this.last = this;
        this.data = data;
    }

    public LinkedListNode() { }

    public void add(int num) {
        LinkedListNode elem = new LinkedListNode(num);
        if (this.head == null) {
            this.head = elem;
            this.last = elem;
        } else {
            LinkedListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = elem;
            elem.previous = cur;
            this.last = elem;
        }
    }

    public void add(LinkedListNode elem) {
        if (this.head == null) {
            this.head = elem;
            this.last = elem;
        } else {
            LinkedListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = elem;
            elem.previous = cur;
            this.last = elem;
        }
    }

    public void setNext(LinkedListNode node) {
        next = node;
        if (head == null) {
            head = node;
        }
        if (this == last) {
            last = node;
        }
        //System.out.println(head.data);
        if (node != null && node.previous != this) {
            node.next = this.next.next;
            this.next = node;
        }
    }

    public void setPrevious(LinkedListNode node) {
        previous = node;
        if (this == head) {
            head = node;
        }
        if (node != null && node.next != this) {
            node.previous = this.previous.previous;
            this.previous = node;
        }
    }

    public LinkedListNode clone() {
        LinkedListNode list2 = null;
        if (this != null) {
            list2 = next.clone();
        }
        LinkedListNode head2 = new LinkedListNode(data, list2, null);
        return head2;
    }

    public LinkedListNode get() {
        return this;
    }

    public int size() {
        int i = 0;
        LinkedListNode node = this.head;
        for (; node != null; i++) {
            node = node.next;
        }
        return (i);
    }

    public LinkedListNode get(int ind) {
        LinkedListNode node = this.head;
        if (node == null || ind >= node.size()) {
            return null;
        }
        for (int i = 0; i < ind; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");
        LinkedListNode cur = this.head;
        if (cur != null) {
            for(;cur.next != null; cur = cur.next) {
                res.append(cur.data);
                res.append("->");
            }
            res.append(cur.data);
        }
        return (res.toString());
    }
}
