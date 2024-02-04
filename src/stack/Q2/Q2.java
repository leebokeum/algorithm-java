package stack.Q2;

public class Q2 {
    /**
     * 스택 Min:
     *  - 기본적인 push와 pop 기능이 구현된 스택에서 최솟값을 반환하는 min 함수를 추가하려고 한다.
     *  - 어떻게 설계할 수 있겠는가? push, pop, min 연 산은 모두 O(1) 시간에 동작해야 한다.
     */
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        StackWithMin2 stack2 = new StackWithMin2();

        int[] array = {2, 1, 3, 1};
        for (int value : array) {
            stack.push(value);
            stack2.push(value);
            System.out.print(value + ", ");
        }

        System.out.println('\n');
        for (int i = 0; i < array.length; i++) {
            System.out.println("Popped " + stack.pop().value + ", " + stack2.pop());
            System.out.println("New min is " + stack.min() + ", " + stack2.min());
        }
    }
}
