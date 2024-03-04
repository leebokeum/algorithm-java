package bit.Q3;

/**
 * 문제
 * 어떤 정수가 주어졌을때 여러분은 이 정수의 비트 하나에 0에서 1로 바꿀 수 있다.
 * 이때 1이 연속으로 나올 수 있는 가장 긴 길이를 구하는 코드를 작성하라.
 **/
public class Q3D {

	public static int flipBit(int a) {
		/* If all 1s, this is already the longest sequence. */
		if (~a == 0) return Integer.BYTES * 8;
		
		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 1; // We can always have a sequence of at least one 1
		while (a != 0) {
			if ((a & 1) == 1) {
				currentLength++;
			} else if ((a & 1) == 0) {
				/* Update to 0 (if next bit is 0) or currentLength (if next bit is 1). */
				previousLength = (a & 2) == 0 ? 0 : currentLength;
				currentLength = 0;
			}
			maxLength = Math.max(previousLength + currentLength + 1, maxLength);
			a >>>= 1;
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		int[][] cases = {{-1, 32}, {Integer.MAX_VALUE, 32}, {-10, 31}, {0, 1}, 
				{1, 2}, {15, 5}, {1775, 8}};
		for (int[] c : cases) {
			int x = flipBit(c[0]);
			boolean r = (c[1] == x);
			System.out.println(c[0] + ": " + x + ", " + c[1] + " " + r);
		}

	}

}
