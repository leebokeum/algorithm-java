package bit.Q2;

/**
 * 문제
 * 0.72와 같이 0과 1 사이의 실수가 double 타입으로 주어졌을때 ,그 값을 2진수 형태로 출력하는 코드를 작성하라.
 * 길이가 32이하인 문자열로 2진수로 정확히 표현할 수 없다면 ERROR를 출력하라
 *
 * 해결법
 * 정수가 아닌 수를 이진수로 표현한다면 0.101(2)처럼 될 것이다.
 * 소숫점 아래부분을 출력하기 위해서는 2를 곱해서 2n이 1보다 크거나 같은지를 확인하는 방법이 있다.
 * 2*n이 1보다 크다는것은 소숫점 바로 다음수가 1이라는 뜻이고
 * 사실 2를 곱한다는 것은 왼쪽으로 쉬프트 하는 것을 의미한다.
 */
public class Q2 {
	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
	
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() > 32) {
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
	
	public static String printBinary2(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
	
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() >= 32) {
				return "ERROR";
			}
			if (num >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
	}	
	
	public static void main(String[] args) {
		String bs = printBinary(.125);
		System.out.println(bs);
		
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = printBinary(num);
			String binary2 = printBinary2(num);
			if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
				System.out.println(num + " : " + binary + " " + binary2);
			}
		}
	}
}
