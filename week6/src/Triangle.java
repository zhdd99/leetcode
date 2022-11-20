import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-11-20
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>(triangle.size());
        for (int i = 0; i < triangle.size(); i ++) {
            List<Integer> dpj = new ArrayList<>();
            dp.add(dpj);
            for (int j = 0; j <= i; j ++) {
                if (i < 1) {
                    dpj.add(triangle.get(i).get(j));
                    continue;
                }
                if (j < 1) {
                    dpj.add(triangle.get(i).get(j) + dp.get(i - 1).get(j));
                    continue;
                }
                if (j >= i) {
                    dpj.add(triangle.get(i).get(j) + dp.get(i - 1).get(j - 1));
                    continue;
                }
                dpj.add(triangle.get(i).get(j) + Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)));
            }
        }
        List<Integer> dpLast = dp.get(triangle.size() - 1);
        int ans = dpLast.get(0);
        for (int i = 1; i < dpLast.size(); i ++) {
            ans = Math.min(dpLast.get(i), ans);
        }
        return ans;
    }
}
