package Book.Part3;

public class Stack<Integer> {
    private Node head;
    private int min;
    private static class Node<T> {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }

        private int getData() {
            return (this.data);
        }
    }

    public Stack() {
        this.head = null;
        this.min = java.lang.Integer.MIN_VALUE;
    }

    public Stack(int data) {
        if (this.head == null) {
            this.head = new Node<>(data);
            this.min = data;
        }
    }

    public void add(int data) {
        Node<Integer> node = new Node<>(data);
        if (this.head == null) {this.min = data;}
        else {this.min = data < this.min ? data : this.min;}
        node.next = this.head;
        head = node;
    }

    public int poll() {
        Node<Integer> node = this.head;
        if (node != null) {
            this.head = node.next;
            this.min = this.findMin();
            return (node.getData());
        }
        return 0;
    }

    public int peek() {
        Node<Integer> node = this.head;
        if (node != null) {
            return (node.getData());
        }
        return 0;
    }

    public void clean() {
        this.head = null;
    }

    private int findMin() {
        Node node = this.head;
        int min = java.lang.Integer.MAX_VALUE;
        while (node != null) {
            min = min < node.getData() ? min : node.getData();
            node = node.next;
        }
        return min;
    }

    public int min () {
        return this.min;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node node = this.head;
        if (node != null) {
            while (node.next != null) {
                str.append(node.data + "->");
                node = node.next;
            }
            str.append(node.data);
        }
        return str.toString();

    }

}
