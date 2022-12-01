/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-12-01
 */
public class RedundantConnection {
    int[] f;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        f = new int[n + 1];
        for (int i = 0; i <=n; i ++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i ++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (!unionSet(x, y)) {
                return new int[]{x, y};
            }
        }
        return new int[]{};

    }
    int find(int x) {
        if (f[x] != x) {
            f[x] = find(f[x]);
        }
        return f[x];
    }
    boolean unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f[x] = y;
            return true;
        }
        return false;
    }
}
