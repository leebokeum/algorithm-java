package stack.Q3;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    // 스택을 담을 List
    ArrayList<StackQ3> stacks = new ArrayList<StackQ3>();

    // 하나의 스택의 크기
    public int capacity;

    // 생성시 스택의 크기를 결정한다.
    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 마지막 스택 가져오기
     */
    public StackQ3 getLastStack() {
        // 스택 리스트가 비어 있다면 null
        if (stacks.isEmpty()) {
            return null;
        }

        // 스택 리스트의 크기 - 1 번째 스택 반환
        return stacks.get(stacks.size() - 1);
    }

    /**
     * 값 입력
     */
    public void push(int value) {
        // 리스트의 마지막 스택 가져오기
        StackQ3 last = getLastStack();

        if (last != null && !last.isFull()) {
            // 가져온 스택이 null 이 아니고, 가득차 있지 않다면
            last.push(value);
        } else {
            // 마지막스택이 null 이거나 가득차 있다면, 새로운 스택을 만든다.
            StackQ3 stack = new StackQ3(capacity);
            stack.push(value);
            stacks.add(stack);
        }
    }

    /**
     * 스택에서 값 꺼내기
     */
    public int pop() {
        // 리스트의 마지막 스택 가져오기
        StackQ3 last = getLastStack();
        if (last == null) {
            throw new EmptyStackException();
        }

        // 마지막 스택에서 값을 꺼낸다.
        int value = last.pop();

        // 값을 꺼내고 난 후 스택이 비었다면, 리스트에서 제거해준다.
        if (last.size == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return value;
    }

    /**
     * 스택이 비었는지 여부
     */
    public boolean isEmpty() {
        StackQ3 last = getLastStack();
        return last == null || last.isEmpty();
    }
}
