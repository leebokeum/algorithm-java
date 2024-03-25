package sorting.Q7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 빠트린 정수: 음이 아닌 정수 40억개로 이루어진 입력 파일이 있다.
 * 이 파일 에 없는 정수를 생성하는 알고리즘을 작성하라.
 * 단, 메모리는 1GB만 사용 할 수 있다.
 */
public class Q7 {

	// 양의 정수 최대 값
	public static long numberOfInts = ((long) Integer.MAX_VALUE) + 1;

	// 1 byte 에 8bit 이니까  numberOfInts/8 만큼 크기의 BV(bit vector)를 만든다.
	public static byte[] bitfield = new byte [(int) (numberOfInts / 8)];

	public static void main(String[] args)  throws IOException {
		findOpenNumber();
	}

	/**
	 * 빠트린 정수 찾기
	 */
	public static void findOpenNumber() throws FileNotFoundException {
		// 숫자를 읽는다.
		Scanner in = new Scanner(new FileReader("/Users/user/example-workspace/algorithm-java/src/sorting/Q7/input2.txt"));


		// 파일의 모든 숫자를 읽는다.
		while (in.hasNextInt()) {
			int n = in.nextInt ();

			byte fieldValue = bitfield [n / 8];

			// OR 연산을 사용해서 bitfield에 상응하는 숫자를 찾아 n번째 위치에 값을 넣는다. (OR : 대응 되는 비트중 하나라도 1이면 1을 반환함)
			// (예을 들어 숫자 10은 바이트(byte) 배열에서 두 번째 인덱스 2번째 비트의 위치를 의미한다.)
			bitfield[n / 8] = (byte) (fieldValue | (1 << (n % 8)));
		}

		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				// 각 바이트의 비트를 개별적으로 확인한다.
				// 만약 0번째 비트가 찾고자 하는 비트라면 그에 상응하는 값을 출력한다.
				int value =  bitfield[i] & (1 << j);

				if (value == 0) {
					System.out.println (i * 8 + j);
					return;
				}
			}
		}		
	}
}
