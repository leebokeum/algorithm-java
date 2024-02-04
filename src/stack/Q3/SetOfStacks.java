package stack.Q3;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    ArrayList<StackQ3> stacks = new ArrayList<StackQ3>();
    public int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public StackQ3 getLastStack() {
        if (stacks.isEmpty()) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public void push(int v) {
        StackQ3 last = getLastStack();
        if (last != null && !last.isFull()) { // add to last
            last.push(v);
        } else { // must create new stack
            StackQ3 stack = new StackQ3(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop() {
        StackQ3 last = getLastStack();
        if (last == null) throw new EmptyStackException();
        int v = last.pop();
        if (last.size == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        StackQ3 stack = stacks.get(index);
        int removed_item;
        if (removeTop) removed_item = stack.pop();
        else removed_item = stack.removeBottom();
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removed_item;
    }

    public boolean isEmpty() {
        StackQ3 last = getLastStack();
        return last == null || last.isEmpty();
    }
}
