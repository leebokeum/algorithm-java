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

        // 채스판 전체를 0과 1로 번갈아 가며 채우기
        fillChessboard(chessboard);

        // 문제에서 삭제할 공간을 -1로 설정 (삭제된 공간은 -1이라고 간주한다)
        chessboard[0][CHESS_SIZE-1] = -1;
        chessboard[CHESS_SIZE-1][0] = -1;

        // 체스판 출력하여 눈으로 보기
        printChessboard(chessboard);


        // 도미노가 전체를 덮을 수 있을지 판다
        if (!isDominoPlacementPossible(chessboard)) {
            System.out.println("31개의 도미노로 보드 전체를 덮을 수 없습니다.");
        } else {
            System.out.println("31개의 도미노로 보드 전체를 덮을 수 있습니다.");
        }
    }


    private static boolean isDominoPlacementPossible(int[][] chessboard) {
        int count0 = 0;
        int count1 = 0;

        for (int[] row : chessboard) {
            for (int cell : row) {
                if (cell == 0) {
                    count0++;
                    continue;
                }

                if (cell == 1) {
                    count1++;
                }
            }
        }

        System.out.println("0의 갯수" + count0);
        System.out.println("1의 갯수" + count1);

        // 0의 갯수 또는 1의 갯수가 DOMINO_SIZE 보다 큰것이 있다면 false
        if (count0 > DOMINO_SIZE ) {
            return false;
        }

        if (count1 > DOMINO_SIZE ) {
            return false;
        }

        return true;
    }

    /**
     * 체스 전체를 0 과 1로 번갈아 가며 채운다.
     */
    private static void fillChessboard(int[][] chessboard) {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    chessboard[i][j] = 1;
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
