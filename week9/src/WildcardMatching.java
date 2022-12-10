/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-12-10
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] f = new boolean[n + 1][m + 1];
        //初始化条件
        f[0][0] = true;
        for (int i = 1; i <= m; i ++) {
            if (p.charAt(i) == '*') {
                f[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                // 如果当前i，j两个字符相等
                boolean charMatch = f[i - 1][j - 1] && s.charAt(i) == p.charAt(j);
                // 如果是？
                boolean questionMatch = f[i - 1][j - 1] && p.charAt(j) == '?';
                // 如果是*, 选择用f[i - 1][j]或者不用
                boolean starMatch = false;
                if (p.charAt(j) == '*') {
                    starMatch = f[i - 1][j] || f[i][j - 1];
                }
                f[i][j] = charMatch || questionMatch || starMatch;
            }
        }
        return f[n][m];
    }
}
