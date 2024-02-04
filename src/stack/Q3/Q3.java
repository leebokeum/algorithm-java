package stack.Q3;

public class Q3 {
    /**
     * 접시 무더기: 접시 무더기를 생각해 보자. 접시를 너무 높이 쌓으면 무너져 내릴 것이다.
     * 따라서 현실에서는 접시를 쌓다가 무더기 높이가 어느 정도 높아지면 새로운 무더기를 만든다. 이것을 흉내 내는 자료구조 SetOfStacks 를 구현해 보라.
     * SetOfStacks 는 여러 개의 스택으로 구성되어 있으며, 이 전 스택이 지정된 용량을 초과하는 경우 새로운 스택을 생성해야 한다.
     * setOfStacks.push() 와 SetOfStacks.pop() 은 스택이 하나인 경우와 동일하게 동작해야 한다 (다시 말해, pop()은 정확히 하나의 스택이 있을 때와 동일한 값을 반환해야 한다).
     */
    public static void main(String[] args) {
        int capacity_per_substack = 5;
        SetOfStacks set = new SetOfStacks(capacity_per_substack);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i < 35; i++) {
            System.out.println("Popped " + set.pop());
        }
    }
}
