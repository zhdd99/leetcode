import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表 II
 */
public class Question210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] rd = new int[numCourses];
        int[] ans = new int[numCourses];
        List<Integer>[] to = new ArrayList[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (null == to[prerequisites[i][1]]) {
                to[prerequisites[i][1]] = new ArrayList<>();
            }
            to[prerequisites[i][1]].add(prerequisites[i][0]);
            rd[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (rd[i] == 0) {
                queue.add(i);
            }
        }
        int pos = 0;
        while (!queue.isEmpty()) {
            ans[pos] = queue.poll();
            if (to[ans[pos]] != null) {
                for (int i = 0; i < to[ans[pos]].size(); i++) {
                    rd[to[ans[pos]].get(i)]--;
                    if (rd[to[ans[pos]].get(i)] == 0) {
                        queue.add(to[ans[pos]].get(i));
                    }
                }
            }
            pos++;
        }
        if (pos < numCourses - 1) {
            return new int[0];
        } else {
            return ans;
        }
    }
}
