package bit.Q6;

import bit.BitUtils;

/**
 * 정수 A와 정수 B를 2진수로 표현했을 때, A를 B로 바꾸기 위해 뒤집어야 하는 비트의 개수를 구하는 함수를 작성하라
 * 입력 : 29(혹은 11101) , 15( 혹은 01111)
 * 출력 : 2
 */
public class Q6B {
	public static void main(String[] args) {
		int a = 29;
		int b = 15;
		System.out.println(a + ": " + BitUtils.toFullBinaryString(a));
		System.out.println(b + ": " + BitUtils.toFullBinaryString(b));

		System.out.println("Required number of bits: " + bitSwapRequired(a, b));
	}

	/**
	 * 간단하게 XOR(^) 을 이용하여 해결한다.
	 *  - XOR : 대응되는 비트가 서로 다르면 1을 반환함
	 */
	public static int bitSwapRequired(int a, int b){
		// 총 변경할 bit 갯수
		int count = 0;

		// a 와 b를 XOR 한 결과
		int result = a ^ b;
		System.out.println("a ^ b : " + BitUtils.toFullBinaryString(result));

		// result 에서 1을 뺀 값에 다시 원래 result 값을 AND 하여 카운트 한다.
		while (result != 0) {
			result = result & (result-1);
			count++;
		}

		return count;
	}
}
