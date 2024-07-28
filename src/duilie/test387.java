package duilie;

public class test387 {
    class Solution {
        public int firstUniqChar(String s) {
            int[] cnt = new int[26];
            //初始值给-1
            for (int i = 0; i < 26; ++i) {
                cnt[i] = -1;
            }
            //遍历字符串，记录每个字符最后出现的位置
            char[] cs = s.toCharArray();
            for (int  i = 0; i < cs.length; ++i) {
                if (cnt[cs[i] - 'a'] == -1) {
                    cnt[cs[i] - 'a'] = i;
                } else {
                    cnt[cs[i] - 'a'] = -2;
                }
            }
            //找到第一个非-2的值，即第一个只出现一次的字符
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 26; ++i) {
                if (cnt[i] >= 0) {
                    ans = Math.min(ans, cnt[i]);
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
}
