import java.util.PriorityQueue;

import javafx.util.Pair;

/**
 * 239. 滑动窗口最大值
 */
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for (int i = 0; i < nums.length; i ++) {
            queue.add(new Pair<>(nums[i], i));
            while (queue.peek().getValue() < i - k + 1) {
                Pair<Integer, Integer> p = queue.poll();
            }
            if (i >= k - 1) {
                ans[i - k + 1] = queue.peek().getKey();
            }
        }
        return ans;
    }
}
