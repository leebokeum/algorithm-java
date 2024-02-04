package stack;

public class StackTest {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        for (int i=1; i<=5 ; i++) {
            stack.push(i);
            System.out.println(stack.peek());
        }

        System.out.println(stack.pop());
        System.out.println(stack.peek());    //4출력
        System.out.println(stack.isEmpty());    //false 출력
    }
}
