import java.util.*;

/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on ${YEAR}-${MONTH}-${DAY}
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        int ans = 0;
        for (int i = 1; i <= n; i ++) {
            s[i] = s[i - 1] + nums[i - 1];
            ans += countMap.getOrDefault(s[i] - k, 0);
            int count = countMap.getOrDefault(s[i], 0);
            count ++;
            countMap.put(s[i], count);
        }
        return ans;
    }
}