package bit.Q4;

import bit.BitUtils;

/**
 * 문제
 * 양의 정수가 하나 주어졌다.
 * 이 숫자를 2진수로 표기했을때 1비트의 개수가 같은 숫자중에서 주어진 수보다 크지만 가장 작은 수와, 작지만 가장 큰 수를 구하여라 .
 *
 * 해결법
 * 이 문제는 두가지 방식으로 풀 수 있다.
 * 원리는 같지만 비트조작으로 하는지, 수학적으로 해결하는지의 차이이다.
 * 우선 비트조작으로 해결하는 것을 살펴보자
 */
public class Q4A {

	public static int countOnes(int i) {
		int count = 0;
		while (i > 0) {
			if ((i & 1) == 1) {
				count++;
			}
			i = i >> 1;
		}
		return count;
	}
	
	public static int countZeros(int i) {
		return 32 - countOnes(i);
	}	
	
	public static boolean hasValidNext(int i) {
		if (i == 0) {
			return false;
		}
		int count = 0;
		while ((i & 1) == 0) {
			i >>= 1;
			count++;
		}
		while ((i & 1) == 1) {
			i >>= 1;
			count++;
		}		
		if (count == 31) {
			return false;
		}
		return true;	
	}
	
	public static boolean hasValidPrev(int i) {
		while ((i & 1) == 1) {
			i >>= 1;
		}
		if (i == 0) {
			return false;
		}
		return true;		
	}

	public static int getNextSlow(int i) {
		if (!hasValidNext(i)) {
			return -1;
		}
		int num_ones = countOnes(i);
		i++;
		while (countOnes(i) != num_ones) {
			i++;
		}
		return i;
	}

	public static int getPrevSlow(int i) {
		if (!hasValidPrev(i)) {
			return -1;
		}		
		int num_ones = countOnes(i);
		i--;
		while (countOnes(i) != num_ones) {
			i--;
		}
		return i;
	}
	
	public static void main(String[] args) {
		int i = 13948;
		int p1 = getPrevSlow(i);
		int n1 = getNextSlow(i);
		BitUtils.binPrint(p1);
		BitUtils.binPrint(n1);
	}
}
