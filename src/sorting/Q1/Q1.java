package sorting.Q1;

import sorting.SortUtils;

/**
 * 정렬된 병합: 정렬된 배열 A와 B가 주어진다.
 * A의 끝에는 B를 전부 넣을 수 있을 만큼 충분한 여유 공간이 있다.
 * B와 A를 정렬된 상태로 병합하는 메서드를 작성하라.
 */
public class Q1 {

	public static void main(String[] args) {
		// 두개의 배열
		int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
		int[] b = {1, 4, 6, 7, 9, 11};

		// 합병
		merge(a, b, 8, 6);

		System.out.println("정렬 : " + SortUtils.arrayToString(a));
	}


	/**
	 * 두개의 배열 병합 정렬
	 */
	public static void merge(int[] a, int[] b, int countA, int countB) {

		// 배열 A의 마지막 원소 인덱스
		int indexA = countA - 1;

		// 배열 B의 마지막 원소 인덱스
		int indexB = countB - 1; /* Index of last element in array a */

		// 배열 병합된 배열의 마지막 위치
		int indexMerged = countB + countA - 1;
	
		// A와 B를 마지막 원소부터 병합해 나간다.
		while (indexB >= 0) {
			// A의 마지막 원소 > B의 마지막 원소
			if (indexA >= 0 && a[indexA] > b[indexB]) {
				a[indexMerged] = a[indexA];
				indexA--; 
			} else {
				a[indexMerged] = b[indexB];
				indexB--;
			}

			// 인덱스 이동
			indexMerged--;
		}
	}

}
