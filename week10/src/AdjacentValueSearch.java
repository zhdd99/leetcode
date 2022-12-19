import java.util.*;
import java.util.Map.Entry;

/**
 * 用语言内置的有序集合库实现邻值查找
 */
public class AdjacentValueSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        for (int i = 1; i <= length; i ++) {
            int curr = sc.nextInt();
            Entry<Integer, Integer> floor = sortedMap.floorEntry(curr);
            Entry<Integer, Integer> higher = sortedMap.higherEntry(curr);
            if (floor != null && higher != null) {
                if (curr - floor.getKey() > higher.getKey() - curr) {
                    System.out.println(higher.getKey() - curr + " " + higher.getValue());
                } else {
                    System.out.println(curr - floor.getKey() + " " + floor.getValue());
                }
            } else if (floor != null || higher != null) {
                if (floor != null) {
                    System.out.println(curr - floor.getKey() + " " + floor.getValue());
                } else {
                    System.out.println(higher.getKey() - curr + " " + higher.getValue());
                }
            }
            sortedMap.put(curr, i);
        }
    }
}