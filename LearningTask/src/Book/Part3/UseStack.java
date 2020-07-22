package Book.Part3;

public class UseStack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        System.out.println(stack);
        System.out.println(stack.min());
        stack.add(4);
        stack.add(3);
        stack.add(2);
        stack.add(1);
        stack.add(0);
        System.out.println(stack.min());
        System.out.println(stack);
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack);
        System.out.println(stack.min());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
