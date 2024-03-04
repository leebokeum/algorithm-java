package bit.Q1;

import bit.BitUtils;

/**
 * 문제
 * 두 개의 32비트 수 N과 M이 주어지고, 비트 위치 i와 j가 주어졌을 때, M을 N에 삽입하는 메서들을 구현하라.
 * M은 N의 j번째 비트에서 시작하여 i번째 비트에서 끝난다.
 * j번째 비트에서 i번째 비트까지에는 M을 담기에 충분한 공간이 있다고 가정한다.
 * 다시말해 M = 10011라면, j와 i사이에 적어도 다섯 비트가 있다고 가정해도 된다는 것이다.
 * j = 3이고 i = 2인 경우처럼 M을 삽입할 수 없는 상황은 발생하지 않는다.
 *
 * 해결법
 * 3가지 단계를 거쳐서 문제를 해결할 수 있을 것이다.
 * 1. N의 i에서 j까지의 비트를 0으로 만든다.
 * 2. M을 쉬프트해서 j부터 i번 비트자리에 오도록 만든다.
 * 3. M 과 N을 합한다.
 */
public class Q1 {

	public static int updateBits(int n, int m, int i, int j) {
		// Validation
		if (i > j || i < 0 || j >= 32) {
			return 0;
		}
		
		/* Create a mask to clear bits i through j in n
		/* EXAMPLE: i = 2, j = 4. Result should be 11100011.
		 * (Using 8 bits for this example.  This is obviously not actually 8 bits.)
		 */
		int allOnes = ~0; // allOnes = 11111111
		
		int left = j < 31 ? (allOnes << (j + 1)) : 0; // 1s until position j, then 0s. left = 11100000	
	  	int right = ((1 << i) - 1); // 1s after position i.  right = 00000011
		int mask = left | right; // All 1s, except for 0s between i and j. mask = 11100011

		/* Clear i through j, then put m in there */
		int n_cleared = n & mask; // Clear bits j through i.
		int m_shifted = m << i; // Move m into correct position.
		
		/* OR them, and we're done! */
		return n_cleared | m_shifted; 
	}
	
	public static void main(String[] args) {
		int a = ~23423;
		System.out.println(BitUtils.toFullBinaryString(a));
		int b = 5;
		System.out.println(BitUtils.toFullBinaryString(b));
		int c = updateBits(a, b, 29, 31);
		System.out.println(BitUtils.toFullBinaryString(c));
	}


}
