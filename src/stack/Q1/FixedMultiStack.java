package stack.Q1;

import java.util.Arrays;
import java.util.EmptyStackException;

public class FixedMultiStack {

    // 스택의 갯수 = 3개
    private int numberOfStacks = 3;

    // 스택의 크기 (생성시 결정)
    private int stackCapacity;

    // 전체 스택(3개)에 저장될 데이터가 저장될 공간
    private int[] values;

    // 각 스택에 들어있는 데이터의 크기를 저장할 공간
    private int[] sizes;


    // 생성자 : 생성시 스택의 크기를 결정함
    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    /**
     * 스택에 값을 추가
     * @param stackNum : 스택의 번호
     * @param value : 값
     */
    public void push(int stackNum, int value) throws FullStackException {
        // 해당 스택이 가득차 있는지 확인
        if (isFull(stackNum)) {
            throw new FullStackException();
        }

        // 해당 스택의 크기를 증가 시킨다.
        sizes[stackNum]++;

        // 해당 스택의 가장 위(top)에 값을 추가한다.
        values[indexOfTop(stackNum)] = value;
    }

    /**
     * 스택에서 값을 꺼낸다.
     * @param stackNum : 스택의 번호
     */
    public int pop(int stackNum) {
        // 해당 스택이 비어있는지 확인
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        // 해당 스택의 가장 위(top)의 index 를 구한다.
        int topIndex = indexOfTop(stackNum);

        // 값을 꺼낸다.
        int value = values[topIndex];

        // 꺼낸자리는 비워준다.
        values[topIndex] = 0;

        // 해당 스택의 크기를 감소 시켜준다.
        sizes[stackNum]--;

        // 꺼낸 값을 반환한다.
        return value;
    }

    /**
     * 스택의 가장 위(top)에 있는 값을 확인
     * @param stackNum : 스택의 번호
     */
    public int peek(int stackNum) {
        // 해당 스택이 비어있는지 확인
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        // 해당 스택의 top 위치를 찾아서, 값을 반환
        return values[indexOfTop(stackNum)];
    }

    /**
     * 스택이 비어있는지 여부 반환
     * @param stackNum : 스택의 번호
     */
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    /**
     * 스택이 가득찼는지 여부 반환
     * @param stackNum : 스택의 번호
     */
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    /* Returns index of the top of the stack. */

    /**
     * 스택의 가장 위(top)에 있는 값의 Index 반환한다.
     * @param stackNum : 스택의 번호
     */
    private int indexOfTop(int stackNum) {
        // 해당 스택의 시작 index
        int offset = stackNum * stackCapacity;

        // 해당 스택의 현재 크기
        int size = sizes[stackNum];

        // 시작 Index + 현재 크기 - 1 = 현재 스택의 top index
        return offset + size - 1;
    }

    /**
     * 모든 스택의 값들 반환
     */
    public int[] getValues() {
        return values;
    }

    /**
     * 스택의 값들
     * @param stackNum : 스택의 번호
     */
    public int[] getStackValues(int stackNum) {
        int[] items = new int[sizes[stackNum]];

        for (int i = 0; i < items.length; i++) {
            items[i] = values[stackNum * stackCapacity + i];
        }
        return items;
    }

    public String stackToString(int stackNum) {
        int[] items = getStackValues(stackNum);
        return stackNum + ": " + Arrays.toString(items);
    }
}
