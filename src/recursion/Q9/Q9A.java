package recursion.Q9;

import java.util.HashSet;
import java.util.Set;

public class Q9A {
	public static void main(String[] args) {
		// 유효한 괄호 쌍을 생성한다.
		Set<String> list = generateParens(3);


		// 생성한 괄호 출력
		for (String s : list) {
			System.out.println(s);
		}

		// 총 만들 수 있는 괄호 수
		System.out.println(list.size());
	}

	/**
	 * 괄호 생성하기
	 * - 해법은 f(n-1)의 결과로 만들어낸 괄호에 새로운 괄호쌍을 더해서 f(n)을 만든다.
	 */
	public static Set<String> generateParens(int count) {
		// 중복 제거를 위해 set을 사용한다.
		Set<String> validParens = new HashSet<String>();

		if (count == 0) {
			validParens.add("");
			return validParens;
		}

		Set<String> prev = generateParens(count - 1);

		for (String str : prev) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					String s = insertInside(str, i);
					validParens.add(s);
				}
			}
			validParens.add("()" + str);
		}

		return validParens;
	}

	/**
	 * 괄호쌍 삽입
	 */
	public static String insertInside(String str, int leftIndex) {
		String left = str.substring(0, leftIndex + 1);
		String right = str.substring(leftIndex + 1);
		return left + "()" + right;
	}
}
