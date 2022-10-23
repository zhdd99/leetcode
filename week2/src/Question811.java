import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on ${YEAR}-${MONTH}-${DAY}
 */
public class Question811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> result = new HashMap<>();
        for (String str : cpdomains) {
            String[] numAndUrl = str.split(" ");
            int num = Integer.parseInt(numAndUrl[0]);
            String[] subDomains = numAndUrl[1].split("\\.");
            StringBuilder pre = new StringBuilder();
            for (int j = subDomains.length - 1; j >= 0; j--) {
                pre.insert(0, subDomains[j]);
                Integer count = result.computeIfAbsent(pre.toString(), key -> 0);
                result.put(pre.toString(), count + num);
                pre.insert(0, ".");
            }
        }
        List<String> ans = new ArrayList<>();
        result.forEach((key, value) -> {
            ans.add("" + value + " " + key);
        });
        return ans;
    }
}