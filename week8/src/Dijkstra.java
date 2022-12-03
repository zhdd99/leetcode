import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.*;

/**
 * Dijkstra 求最短路 II
 */
public class Dijkstra {
    public static void main(String[] args) throws NumberFormatException, IOException {
        StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter cout = new PrintWriter(new OutputStreamWriter(System.out));
//        Scanner input = new Scanner(System.in);
        int n,m,s;
        cin.nextToken();n = (int) cin.nval;
        cin.nextToken();m = (int) cin.nval;
        cin.nextToken();s = (int) cin.nval;
        List<List<Integer>> vers = new ArrayList<>();
        List<List<Integer>> edges = new ArrayList<>();
        boolean[] expand = new boolean[n + 1];
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i ++) {
            vers.add(new ArrayList<>());
            edges.add(new ArrayList<>());
            ans[i] = (int) 1e9;
        }
        ans[s] = 0;
        for (int i = 0; i < m; i ++) {
            int x,y,l;
            cin.nextToken();x = (int) cin.nval;
            cin.nextToken();y = (int) cin.nval;
            cin.nextToken();l = (int) cin.nval;
            vers.get(x).add(y);
            edges.get(x).add(l);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{s, 0});
        while (!q.isEmpty()) {
            int[] point = q.poll();
            if (!expand[point[0]]) {
                expand[point[0]] = true;
                for (int i = 0; i < vers.get(point[0]).size(); i ++) {
                    Integer v = vers.get(point[0]).get(i);
                    Integer e = edges.get(point[0]).get(i);
                    if (ans[v] > ans[point[0]] + e) {
                        ans[v] = ans[point[0]] + e;
                        q.add(new int[]{v, ans[v]});
                    }
                }
            }
        }
        for (int i = 1; i <= n; i ++) {
            cout.print(ans[i] + " ");
        }
        cout.flush();
    }
}
