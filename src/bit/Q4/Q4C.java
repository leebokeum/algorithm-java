package bit.Q4;

import bit.BitUtils;

/**
 * 문제
 * 양의 정수가 하나 주어졌다.
 * 이 숫자를 2진수로 표기했을때 1비트의 개수가 같은 숫자중에서 주어진 수보다 크지만 가장 작은 수와, 작지만 가장 큰 수를 구하여라 .
 */
public class Q4C {
	public static int getNextArith(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		/* If c is 0, then n is a sequence of 1s followed by a sequence of 0s. This is already the biggest
		 * number with c1 ones. Return error.
		 */
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		
		/* Arithmetically:
		 * 2^c0 = 1 << c0
		 * 2^(c1-1) = 1 << (c0 - 1)
		 * next = n + 2^c0 + 2^(c1-1) - 1;
		 */
		
		return n + (1 << c0) + (1 << (c1 - 1)) - 1;
	}
	
	public static int getPrevArith(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while (((temp & 1) == 1) && (temp != 0)) {
			c1++;
			temp >>= 1;
		}
		
		/* If temp is 0, then the number is a sequence of 0s followed by a sequence of 1s. This is already
		 * the smallest number with c1 ones. Return -1 for an error.
		 */
		if (temp == 0) { 
			return -1;
		}
		
		while ((temp & 1) == 0 && (temp != 0)) {
			c0++;
			temp >>= 1;
		}

		/* Arithmetic:
		 * 2^c1 = 1 << c1
		 * 2^(c0 - 1) = 1 << (c0 - 1)
		 */
		return n - (1 << c1) - (1 << (c0 - 1)) + 1;		
	}
	
	public static void main(String[] args) {
		int i = 13948;
		int p1 = getPrevArith(i);
		int n1 = getNextArith(i);
		BitUtils.binPrint(p1);
		BitUtils.binPrint(n1);
	}

}
