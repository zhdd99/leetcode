/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-11-27
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int m = 1;
        for (int i = 1; i <= n; i ++) {
            if (i * i > n) {
                m = i - 1;
                break;
            }
        }
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            f[i] = (int)1e9;
        }

        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (i * i <= j) {
                    f[j] = Math.min(f[j], f[j - i * i] + 1);
                }
            }
        }
        return f[n];
    }
}
