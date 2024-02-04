package stack;

public class Recursive {
    public static void main(String[] args) {
        recursive(4);
    }

    /**
     * 재귀함수
     *  - 함수의 동작방식이 스택을 표현 할 수 있는 좋은 예시
     * @param data
     */
    public static void recursive(int data) {
        if (data < 0) {
            System.out.println("ended");
        } else {
            System.out.println(data);
            recursive(data - 1);
        }
    }
}
