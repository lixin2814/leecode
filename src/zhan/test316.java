package zhan;

public class test316 {
    class Solution {
        public String removeDuplicateLetters(String s) {

            int[] cnt = new int[26];
            boolean[] vis = new boolean[26];
            char[] t = s.toCharArray();
            for (char c : t) {
                cnt[c - 'a']++;
            }
            StringBuilder stk = new StringBuilder();
            for (char c : t) {
                cnt[c - 'a']--;
                if (vis[c - 'a']) continue;
                // 放入的最后一个字符比当前这个大，且后面还有，当前的应该放前面。
                while (stk.length() > 0 && stk.charAt(stk.length() - 1) > c && cnt[stk.charAt(stk.length() - 1) - 'a'] > 0) {
                    //  最后一个字符拿出，标记未访问
                    vis[stk.charAt(stk.length() - 1) - 'a'] = false;
                    stk.deleteCharAt(stk.length() - 1);
                }
                stk.append(c);
                vis[c - 'a'] = true;
            }
            return stk.toString();
        }
    }
}
