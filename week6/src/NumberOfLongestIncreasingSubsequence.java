/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-11-20
 */
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            dp[i] = 1;
            dp2[i] = 1;
        }
        for (int i = 1; i < nums.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp2[i] = dp2[j];
                        dp[i] = dp[j] + 1;
                    } else if (dp[i] == dp[j] + 1) {
                        dp2[i] += dp2[j];
                    }
                }
            }
        }
        int max = 0;
        int ans = 1;
        for (int i = 0; i < nums.length; i ++) {
            if (dp[i] > max) {
                max = dp[i];
                ans = dp2[i];
            } else if(dp[i] == max) {
                ans += dp2[i];
            }
        }
        return ans;
    }
}
