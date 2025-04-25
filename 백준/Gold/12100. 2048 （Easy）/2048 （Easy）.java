import java.util.*;

public class Main {
    static int N;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 보드 크기 입력

        int[][] board = new int[N][N]; // 초기 보드 상태

        // 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dfs(0, board); // 최대 5번 이동해보기
        System.out.println(max); // 얻을 수 있는 최대 블록 출력
    }

    // 깊이 우선 탐색으로 최대 5번 이동
    static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            max = Math.max(max, getMaxBlock(board)); // 최대 블록 갱신
            return;
        }

        for (int dir = 0; dir < 4; dir++) { // 0: ←, 1: →, 2: ↑, 3: ↓
            int[][] moved = move(board, dir); // 해당 방향으로 이동
            dfs(depth + 1, moved); // 다음 단계로 탐색
        }
    }

    // 현재 보드에서 가장 큰 블록 값 반환
    static int getMaxBlock(int[][] board) {
        int val = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                val = Math.max(val, board[i][j]);
            }
        }
        return val;
    }

    // 보드를 주어진 방향(dir)으로 이동 후 새 보드 반환
    static int[][] move(int[][] board, int dir) {
        int[][] newBoard = new int[N][N];

        // 기존 보드 복사
        for (int i = 0; i < N; i++) {
            newBoard[i] = board[i].clone();
        }

        // 각 행/열에 대해 처리
        for (int i = 0; i < N; i++) {
            int[] line = new int[N]; // 이동 및 병합된 결과 저장
            boolean[] merged = new boolean[N]; // 병합 여부 추적
            int idx = 0;

            // 원래 보드에서 값을 읽어와서 line에 채움
            for (int j = 0; j < N; j++) {
                int r = i, c = j;

                // 방향에 따라 r, c를 조정
                if (dir == 1) c = N - 1 - j;       // → 오른쪽
                if (dir == 2) { r = j; c = i; }     // ↑ 위쪽
                if (dir == 3) { r = N - 1 - j; c = i; } // ↓ 아래쪽

                // 값을 가져옴 (행/열 전환 고려)
                int val = board[r][c];

                if (val == 0) continue; // 0은 무시

                if (line[idx] == 0) {
                    line[idx] = val; // 비어있으면 저장
                } else if (line[idx] == val && !merged[idx]) {
                    line[idx] *= 2;       // 값이 같고 아직 병합 안 했으면 병합
                    merged[idx] = true;   // 병합 체크
                } else {
                    idx++;            // 다음 칸으로 이동
                    line[idx] = val;  // 저장
                }
            }

            // 만들어진 line을 newBoard에 다시 채움
            for (int j = 0; j < N; j++) {
                int r = i, c = j;

                // 다시 방향에 따라 좌표 변환
                if (dir == 1) c = N - 1 - j;
                if (dir == 2) { r = j; c = i; }
                if (dir == 3) { r = N - 1 - j; c = i; }

                if (dir < 2) newBoard[r][c] = line[j];
                else newBoard[c][r] = line[j];
            }
        }

        return newBoard;
    }
}
