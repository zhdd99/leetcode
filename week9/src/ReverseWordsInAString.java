/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-12-10
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                if (word.length() > 0) {
                    ans.insert(0, ans.length() > 0 ? word.append(" ").toString() : word.toString());
                    word = new StringBuilder();
                }
            } else {
                word.append(ch);
            }
        }
        if (word.length() > 0) {
            ans.insert(0, ans.length() > 0 ? word.append(" ").toString() : word.toString());
        }
        return ans.toString();
    }
}
