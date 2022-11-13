/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-11-13
 */
public class CountOfRangeSum {
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            sums = new long[nums.length + 1];
            sums[0] = 0;
            for (int i = 0; i < nums.length; i ++) {
                sums[i + 1] = nums[i] + sums[i];
            }
            int ans = dfs(sums, 0, sums.length - 1, lower, upper);
            return ans;
        }
        public long[] sums;

        public int dfs(long[] sums, int left, int right, int lower, int upper) {
            if (left == right) {
                return 0;
            }
            int mid = (left + right) / 2;
            int ansl = dfs(sums, left, mid, lower, upper);
            int ansr = dfs(sums, mid + 1, right, lower, upper);
            int ans = ansl + ansr;
            int rmin = mid + 1, rmax = mid + 1;
            for (int lmin = left; lmin <= mid; lmin ++) {
                while (rmin <= right && sums[rmin] - sums[lmin] < lower) {
                    rmin ++;
                }
                while (rmax <= right && sums[rmax] - sums[lmin] <= upper) {
                    rmax ++;
                }
                ans += rmax - rmin;
            }
            long[] sort = new long[right - left + 1];
            int l = left;
            int r = mid + 1;
            int index = 0;
            while (l <= mid || r <= right) {
                if (r > right || (l <= mid && sums[l] < sums[r])) {
                    sort[index ++] = sums[l ++];
                } else {
                    sort[index ++] = sums[r ++];
                }
            }
            for (int i = 0; i < index; i ++) {
                sums[left + i] = sort[i];
            }
            return ans;
        }

    }
}
