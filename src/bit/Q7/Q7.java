package bit.Q7;

import bit.BitUtils;

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
