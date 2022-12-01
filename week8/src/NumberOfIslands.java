/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-12-01
 */
public class NumberOfIslands {
    int[] f;
    int m, n;
    int[] dx = new int[] {0, 1};
    int[] dy = new int[] {1, 0};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        f = new int[m * n];
        for (int i = 0; i < m * n; i ++) {
            f[i] = i;
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 2; k ++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni < 0 || nj < 0 || ni >= m || nj >= n) {
                            continue;
                        }
                        if (grid[ni][nj] == '1') {
                            unionSet(genIndex(i, j), genIndex(ni, nj));
                        }
                    }
                } else {
                    f[genIndex(i, j)] = -1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m * n; i ++) {
            if (f[i] == i) {
                ans ++;
            }
        }
        return ans;
    }

    int genIndex(int i, int j) {
        return i * n + j;
    }

    void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f[x] = y;
        }
    }

    int find(int x) {
        if (f[x] != x) {
            f[x] = find(f[x]);
        }
        return f[x];
    }
}
