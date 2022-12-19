import java.util.*;
/**
 * 使用A*算法，解二进制矩阵中的最短路径
 */
public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        depth = new HashMap<>();
        queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{0, 1 + evaluation(0, 0)});
        depth.put(0, 1);
        while (!queue.isEmpty()) {
            int[] step = queue.poll();
            if (step[0] == n * n - 1) return step[1];
            int[] pos = getPos(step[0]);
            int x = pos[0];
            int y = pos[1];
            for (int k = 0; k < 8; k ++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (validPos(nx, ny)) {
                    int nextNum = getNum(nx, ny);
                    if (grid[nx][ny] != 0) continue;
                    if (depth.containsKey(nextNum) && depth.get(nextNum) <= depth.get(step[0]) + 1) continue;
                    depth.put(nextNum, depth.get(step[0]) + 1);
                    queue.add(new int[]{nextNum, depth.get(nextNum) + evaluation(nx, ny)});
                }
            }
        }
        return -1;
    }
    int n;
    PriorityQueue<int[]> queue;
    Map<Integer, Integer> depth;
    int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    int[] dy = {1, -1, 1, 0, -1, 1, 0, -1};
    public int getNum(int i, int j) {
        return i * n + j;
    }

    public int[] getPos(int num) {
        return new int[]{num / n, num % n};
    }

    public boolean validPos(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    public int evaluation(int x, int y) {
        return Math.max(n - 1 - x, n - 1 - y);
    }
}
