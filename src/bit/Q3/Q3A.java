package bit.Q3;

/**
 * 문제
 * 어떤 정수가 주어졌을때 여러분은 이 정수의 비트 하나에 0에서 1로 바꿀 수 있다.
 * 이때 1이 연속으로 나올 수 있는 가장 긴 길이를 구하는 코드를 작성하라.
 *
 * 해결법
 * 1. 연속된 0수열과 1수열의 길이를 표현하는 배열로 바꿔서 생각해보기
 * 11011101111을 오른쪽에서 왼쪽으로 읽으면 [0(0),4(1),1(0),3(1),1(0),2(1)]로 구성될 것이고 이 배열을 읽으면서 0수열이 1인 경우 인접한 1수열을 합치는 경우를 따져 보면 된다.
 */
public class Q3A {
	
	public static int SEQUENCE_LENGTH = 32;
	
	public static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}	
	
	public static int longestSequence(int n) {
		int maxSeq = 0;
		
		for (int i = 0; i < SEQUENCE_LENGTH; i++) {
			maxSeq = Math.max(maxSeq,  longestSequenceOf1s(n, i));
		}
		
		return maxSeq;
	}
	
	public static int longestSequenceOf1s(int n, int indexToIgnore) {
		int max = 0;
		int counter = 0;
		for (int i = 0; i < SEQUENCE_LENGTH; i++) {
			if (i == indexToIgnore || getBit(n, i)) {
				counter++;
				max = Math.max(counter, max);
			} else {
				counter = 0;
			}
		}
		return max;
	}	
	
	public static void main(String[] args) {
		int original_number = Integer.MAX_VALUE;
		int new_number = longestSequence(original_number);
			
		System.out.println(Integer.toBinaryString(original_number));
		System.out.println(new_number);			
	}

}
