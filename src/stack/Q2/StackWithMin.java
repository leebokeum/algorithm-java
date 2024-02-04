package stack.Q2;

import java.io.Serial;
import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
    @Serial
    private static final long serialVersionUID = -6505403047080943439L;

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
}