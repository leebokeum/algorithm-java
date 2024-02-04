package stack.Q5;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class Q5 {
    /**
     * 스택 정렬: 가장 작은 값이 위로 오도록 스택을 정렬하는 프로그램을 작성하라.
     * 추가적으로 하나 정도의 스택은 사용해도 괜찮지만, 스택에 보관된 요소를 배열 등의 다른 자료구조로 복사할 수는 없다.
     * 스택은 push, pop, peek, isEmpty 의 네 가지 연산을 제공해야 한다
     */
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        System.out.println("정렬 전");

        // 정렬 전 값 랜덤으로 입력
        for (int i = 0; i < 10; i++) {
            int r = ThreadLocalRandom.current().nextInt(0,  1000);
            System.out.print(r + ", ");
            s.push(r);
        }

        // 정렬
        sort(s);
        System.out.println();
        System.out.println("정렬 후");

        // 정렬된 값 출력
        while(!s.isEmpty()) {
            System.out.print(s.pop() + ", ");
        }
    }

    /**
     * 스택 정렬 함수
     */
    public static void sort(Stack<Integer> rawStack) {

        // 정렬된 값을 담을 스택
        Stack<Integer> sortedStack = new Stack<Integer>();

        // 1. 스택의 모든 값을 비교하며 sortedStack 에 담는다.
        while(!rawStack.isEmpty()) {
            // 스택의 값을 꺼낸다.
            int tmp = rawStack.pop();

            // sortedStack 에 있는 값을 비교한다.
            // sortedStack 의 값이 더 크다면 다시 꺼내서 rawStack 에 담는다.
            while(!sortedStack.isEmpty() && sortedStack.peek() > tmp) {
                rawStack.push(sortedStack.pop());
            }

            // 더 이상 큰 값이 없다면, sorted 스택에 담는다.
            sortedStack.push(tmp);
        }

        // 2. 정렬된 스택을 다시 원래 스택에 꺼내서 담는다.
        while (!sortedStack.isEmpty()) {
            rawStack.push(sortedStack.pop());
        }
    }

}
