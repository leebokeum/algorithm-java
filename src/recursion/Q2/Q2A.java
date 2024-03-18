package recursion.Q2;

import java.util.ArrayList;
public class Q2A {

	public static final int SIZE = 5;
	public static void main(String[] args) {

		// 5 X 5 메트릭스에 70% 확률로 길을 만든다. (1은 갈 수 있는길, 0은 못가는길)
		boolean[][] grid = Q2Utils.randomBooleanMatrix(SIZE, SIZE, 70);

		// 메트릭스를 출력한다.
		Q2Utils.printMatrix(grid);

		// 경로를 탑색하여 반환한다.
		ArrayList<Point> path = findPath(grid);

		// 경로가 있다면 경로를 출력하고, 없다면 No path found. 를 출력한다.
		if (path != null) {
			System.out.println(path);
		} else {
			System.out.println("No path found.");
		}
	}

	/**
	 * 경로 탐색
	 */
	public static ArrayList<Point> findPath(boolean[][] grid) {
		if (grid == null || grid.length == 0) return null;

		// 경로를 저장할 List
		ArrayList<Point> path = new ArrayList<Point>();

		/**
		 * 경로를 탐색한다.
		 *  - param1 : grid
		 * 	- param2 : 시작 지점 (마지막 종료지점인 최우측 하단 부터 시작)
		 *  - param3 : 돌아오면서 저장할 경로 path
		 */
		if (findPath(grid, grid.length - 1, grid[0].length - 1, path)) {
			return path;
		}

		return null;
	}

	/**
	 * 재귀 탐색
	 *  - param1 : grid
	 * 	- param2 : 시작 지점 (마지막 종료지점인 최우측 하단 부터 시작)
	 *  - param3 : 돌아오면서 저장할 경로 path
	 */
	public static boolean findPath(boolean[][] grid, int row, int col, ArrayList<Point> path) {
		// 메트릭스 범위를 넘어가거나 유효하지 않는 길이라면 (out of bounds or not available)
		if (col < 0 || row < 0 || !grid[row][col]) {
			return false;
		}
		
		// 왼쪽으로 먼저가서 길을 찾고, 그다음 위쪽으로 가서 길을 찾는다. 길을 찾을 때마다 경로를 계속 추가한다.
		if ((row == 0 && col == 0) || findPath(grid, row, col - 1, path) || findPath(grid, row - 1, col, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}
		
		return false;
	}
	




}
