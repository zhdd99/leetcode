import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-10-23
 */
public class Question697 {
    public class Position{
        int count;
        int l;
        int r;

        public Position(int count, int l, int r) {
            this.count = count;
            this.l = l;
            this.r = r;
        }
    }
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Position> map = new HashMap<>();
        Integer minStep = Integer.MAX_VALUE;
        Integer maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            Position position = map.computeIfAbsent(nums[i], key -> new Position(0, finalI, finalI));
            position.r = finalI;
            position.count = position.count + 1;
            if (position.count >= maxCount) {
                minStep = position.count > maxCount ? position.r - position.l + 1 : Math.min(minStep, position.r - position.l + 1);
                maxCount = position.count;
            }
        }
        return minStep;
    }
}
