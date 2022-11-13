import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-11-13
 */
public class SurroundedRegions {
    class Solution {
        public void solve(char[][] board) {
            to = new ArrayList<>();
            int[] dx = new int[] {-1, 0, 0, 1};
            int[] dy = new int[] {0, -1, 1, 0};
            m = board.length;
            n = board[0].length;
            visited = new boolean[m][n];
            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    List<Integer> toPoints = new ArrayList<>();
                    to.add(toPoints);
                    if (board[i][j] == 'O') {
                        for (int k = 0; k < 4; k ++) {
                            int ni = i + dx[k];
                            int nj = j + dy[k];
                            if (valid(ni, nj) && board[ni][nj] == 'O') {
                                toPoints.add(getHash(ni, nj));
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O' && !visited[i][j]) {
                        dfs(i, j);
                    }
                }
            }
            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j ++) {
                    if (!visited[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public int m, n;

        public List<List<Integer>> to;

        public boolean[][] visited;

        public int getHash(int i, int j) {
            return i * n + j;
        }

        public boolean valid(int i, int j) {
            return i >= 0 && j >= 0 && i < m && j < n;
        }

        public void dfs(int i, int j) {
            visited[i][j] = true;
            List<Integer> toPoints = to.get(getHash(i, j));
            for (int point : toPoints) {
                int ni = point / n;
                int nj = point % n;
                if (!visited[ni][nj]) {
                    dfs(ni, nj);
                }
            }
        }
    }
}
