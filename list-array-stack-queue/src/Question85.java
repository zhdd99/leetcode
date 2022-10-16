import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-10-16
 */
public class Question85 {
    class Block {
        int hight;
        int width;

        public Block(int hight, int width) {
            this.hight = hight;
            this.width = width;
        }
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] hights = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    hights[i][j] = i > 0 ? hights[i - 1][j] + 1 : 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < hights.length; i++) {
            Deque<Block> stack = new LinkedList<>();
            for (int j = 0; j < hights[i].length; j++) {
                int cross = 0;
                while (!stack.isEmpty() && hights[i][j] <= stack.peek().hight) {
                    //单调栈计算面积
                    Block top = stack.pop();
                    cross += top.width;
                    ans = Math.max(ans, top.hight * cross);
                }
                stack.push(new Block(hights[i][j], cross + 1));
            }
        }
        return ans;
    }
}
