package leetcode.J_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class task5_05 {

    //76. Minimum Window Substring
    public String minWindow(String s, String t) {
        Map<Character, Integer> lookup = new HashMap<>();
        for (char c : s.toCharArray()) lookup.put(c, 0);
        for (char c : t.toCharArray()) {
            if (lookup.containsKey(c)) lookup.put(c, lookup.get(c) + 1);
            else return "";
        }
        int start = 0;
        int min_len = Integer.MAX_VALUE;
        int counter = t.length();
        String res = "";
        for (int end = 0; end < s.length(); end ++) {
            char c1 = s.charAt(end);
            if (lookup.get(c1) > 0) counter--;
            lookup.put(c1, lookup.get(c1) - 1);
            while (counter == 0) {
                if (min_len > end - start) {
                    min_len = end - start;
                    res = s.substring(start, end);
                }
                char c2 = s.charAt(start);
                //其他元素在 end 未走之前只可能 < 0, 只有指定元素才会 = 0
                if (lookup.get(c2) == 0) counter++;
                lookup.put(c2, lookup.get(c2) + 1);
                start++;
            }
        }
        return res;
    }



    //3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = 0;
        int max = 0;
        while(right < s.length()){
            if(!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), 0);
            }else {
                while(s.charAt(right) != s.charAt(left)){
                    map.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            length = right - left + 1;
            max = Math.max(max, length);
            right++;
        }
        return max;
    }
}
