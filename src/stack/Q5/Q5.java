package stack.Q5;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class Q5 {
    /**
     * 스택 정렬: 가장 작은 값이 위로 오도록 스택을 정렬하는 프로그램을 작성하라.
     * 추가적으로 하나 정도의 스택은 사용해도 괜찮지만, 스택에 보관된 요소를 배열 등의 다른 자료구조로 복사할 수는 없다.
     * 스택은 push, pop, peek, isEmpty의 네 가지 연산을 제공해야 한다
     */
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            int r = ThreadLocalRandom.current().nextInt(0,  1000);
            s.push(r);
        }

        sort(s);

        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static Stack<Integer> mergesort(Stack<Integer> inStack) {
        if (inStack.size() <= 1) {
            return inStack;
        }

        Stack<Integer> left = new Stack<Integer>();
        Stack<Integer> right = new Stack<Integer>();
        int count = 0;
        while (!inStack.isEmpty()) {
            count++;
            if (count % 2 == 0) {
                left.push(inStack.pop());
            } else {
                right.push(inStack.pop());
            }
        }

        left = mergesort(left);
        right = mergesort(right);

        while (!left.isEmpty() || !right.isEmpty()) {
            if (left.isEmpty()) {
                inStack.push(right.pop());
            } else if (right.isEmpty()) {
                inStack.push(left.pop());
            } else if (right.peek().compareTo(left.peek()) <= 0) {
                inStack.push(left.pop());
            } else {
                inStack.push(right.pop());
            }
        }

        Stack<Integer> reverseStack = new Stack<Integer>();
        while (!inStack.isEmpty()) {
            reverseStack.push(inStack.pop());
        }

        return reverseStack;
    }

    public static void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()) {
            /* Insert each element in s in sorted order into r. */
            int tmp = s.pop();
            while(!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }

        /* Copy the elements back. */
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }
}
