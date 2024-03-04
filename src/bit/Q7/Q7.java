package bit.Q7;

import bit.BitUtils;

/**
 * 문제
 * 명령어를 가능한 적게 사용하면서 주어진 정수의 짝 수 번째 비트의 값과 홀수 번째 비트의 값을 바꾸는 프로그램을 작성하라
 * (예: 0번째 비트와 1번째 비트를 바꾸고, 2번째 비트와 3번째 비트를 바꾸는 식)
 *
 * 해결법
 * 이 문제를 풀때에도 다른 방향에서 생각해 볼 필요가 있다.
 * 개별 비트 쌍 단위로 연산해 나가는 것은 어려울 수 있고 , 그다지 효율적이지 못한 것 같다.
 */
public class Q7 {

	public static int swapOddEvenBits(int x) { 
		return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) ); 
	}
	
	public static void main(String[] args) {
		int a = 234321;
		System.out.println(a + ": " + BitUtils.toFullBinaryString(a));
		int b = swapOddEvenBits(a);
		System.out.println(b + ": " + BitUtils.toFullBinaryString(b));
	}
}
