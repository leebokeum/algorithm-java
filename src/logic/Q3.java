package logic;

/**
 * 8X8 크기의 체스판이 있는데,
 * 대각선 반대 방향 끝에 있는 셀(cell) 두 개가 떨어져 나갔다. 하나의 도미노로 정확히 두 개의 정사각형을 덮을 수 있을 때, 31개의 도미노로 보드 전체를 덮을 수 있겠는가?
 * 여러분의 답 이 옳다는 것을 증명하라. 예를 들거나, 왜 가능 혹은 불가능한지를 보이면 된다.
 */
public class Q3 {
    final static int DOMINO_SIZE = 31;
    final static int CHESS_SIZE = 8;
    public static void main(String[] args) {
        int[][] chessboard = new int[CHESS_SIZE][CHESS_SIZE];

        // 대각선 양 끝 을 2로 설정
        chessboard[0][CHESS_SIZE-1] = 2;
        chessboard[CHESS_SIZE-1][0] = 2;

        // 채스판 마주보는 대각선을 1로 채우기
        fillChessboard(chessboard);

        // 체스판 출력
        printChessboard(chessboard);


        // 도미노가 전체를 덮을 수 있을지 판다
        if (!isDominoPlacementPossible(chessboard)) {
            System.out.println("31개의 도미노로 보드 전체를 덮을 수 없습니다.");
        } else {
            System.out.println("31개의 도미노로 보드 전체를 덮을 수 있습니다.");
        }
    }


    private static boolean isDominoPlacementPossible(int[][] chessboard) {
        int countOne = 0;
        for (int[] row : chessboard) {
            for (int cell : row) {
                if (cell == 1) {
                    countOne++;
                }
            }
        }

        // "1"의 개수가 31보다 크면 false
        return countOne <= DOMINO_SIZE;
    }

    /**
     * 체스의 마주보는 대각선을 1로 채운다.
     */
    private static void fillChessboard(int[][] chessboard) {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    chessboard[i][j] = 1; // 대각선 "1"로 채우기
                }
            }
        }
    }

    /**
     * 체스판 출력하기
     */
    private static void printChessboard(int[][] chessboard) {
        for (int[] row : chessboard) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
