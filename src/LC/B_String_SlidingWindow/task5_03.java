/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package LC.B_String_SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author weikeyao
 * @version task5_03.java, v 0.1 2023年12月21日 23:11 weikeyao
 */
public class task5_03 {

    //3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int res = 0;
        int right = 0;
        Map<Character, Integer> dic = new HashMap<>();
        while(right < s.length()){
            dic.put(s.charAt(right), dic.getOrDefault(s.charAt(right), 0) + 1);
            while(dic.get(s.charAt(right)) > 1){
                dic.put(s.charAt(left), dic.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    //209. Minimum Size Subarray Sum
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            target = target - nums[right];
            while(0 >= target){
                res = Math.min(res, right - left + 1);
                target = target + nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    //438. Find All Anagrams in a String
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> cur = new HashMap<>();
        Map<Character, Integer> dir = new HashMap<>();
        int count = 0;
        int left = 0;
        int right = 0;
        for(int a = 0; a < p.length(); a++){
            dir.put(p.charAt(a), dir.getOrDefault(p.charAt(a), 0) + 1);
        }

        while(right < s.length()){
            if(dir.get(s.charAt(right)) != null){
                cur.put(s.charAt(right), cur.getOrDefault(s.charAt(right), 0) + 1);
                if(cur.get(s.charAt(right)) <= dir.get(s.charAt(right))){
                    count++;
                }
            }
            while(count == p.length()){
                if(right - left + 1 == p.length()){
                    res.add(left);
                }
                if(dir.get(s.charAt(left)) != null){
                    cur.put(s.charAt(left), cur.get(s.charAt(left)) - 1);
                    if(cur.get(s.charAt(left)) < dir.get(s.charAt(left))){
                        count--;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }

    //1004. Max Consecutive Ones III
    public int longestOnes(int[] nums, int k) {
        int maxOne = 0;
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < nums.length){
            if(nums[right] == 1){
                maxOne++;
            }
            while(right - left + 1 > maxOne + k){
                if(nums[left] == 1){
                    maxOne--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    //424. 替换后的最长重复字符
    // 窗口内重复最多次数的字母 historyCharMax + K > 历史   更新
    public static int characterReplacement(String s, int k) {
        int[] numCount = new int[26];
        int left = 0;
        int right = 0;
        int historyCountMax = 0;
        int res = 0;
        while(right < s.length()){
            numCount[s.charAt(right) - 'A'] = numCount[s.charAt(right) - 'A'] + 1;
            historyCountMax = Math.max(numCount[s.charAt(right) - 'A'], historyCountMax);
            if(historyCountMax + k < right - left + 1){
                numCount[s.charAt(left) - 'A'] = numCount[s.charAt(left) - 'A'] - 1;
                left++;
            }
            res = Math.max(right - left + 1, res);
            right++;
        }
        return res;
    }
}