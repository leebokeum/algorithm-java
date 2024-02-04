package stack.Q1;

import java.util.Arrays;

public class Q1 {
    /**
     * 한 개로 세 개: 배열 한 개로 스택 세 개를 어떻게 구현할지 설명하라.
     */
    public static void main(String[] args) throws FullStackException {

        // 각 스택의 크기를 4로 하여 FixedMultiStack 을 생성
        FixedMultiStack stacks = new FixedMultiStack(4);
        printStacks(stacks);

        // 스택에 값 추가
        stacks.push(0, 10);
        printStacks(stacks);
        stacks.push(1, 20);
        printStacks(stacks);
        stacks.push(2, 30);
        printStacks(stacks);

        stacks.push(1, 21);
        printStacks(stacks);
        stacks.push(0, 11);
        printStacks(stacks);
        stacks.push(0, 12);
        printStacks(stacks);

        // 스택에서 값 꺼내기
        stacks.pop(0);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);

        stacks.push(0, 13);
        printStacks(stacks);
        stacks.push(1, 22);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);
        stacks.push(2, 32);
        printStacks(stacks);
    }

    // 스택 출력 헬퍼 함수
    public static void printStacks(FixedMultiStack stacks) {
        System.out.println(Arrays.toString(stacks.getValues()));
    }
}
