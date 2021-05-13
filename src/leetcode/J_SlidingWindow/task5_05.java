package leetcode.J_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class task5_05 {

    //76. Minimum Window Substring
    public String minWindow(String s, String t) {
        return null;
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
