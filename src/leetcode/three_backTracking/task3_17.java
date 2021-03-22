package leetcode.three_backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class task3_17 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    //palindrome 回文
    //131
    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }
    private void dfs(String s, int startIndex){
          if(startIndex == s.length()){
              res.add(new ArrayList<>(path));
              return;
          }
          for(int i = startIndex; i < s.length(); i++){
              if(!isPalindrome(s.substring(startIndex, i + 1)))continue;
              path.add(s.substring(startIndex, i + 1));
              dfs(s, i + 1);
              path.remove(path.size() - 1);
          }
    }
    private boolean isPalindrome(String example){
        char[] a = example.toCharArray();
        int i = 0;
        int y = a.length - 1;
        while(i <= a.length - 1){
            if(a[i] != a[y])return false;
            i++;
            y--;
        }
        return true;
    }


    //17 Letter Combinations of a Phone Number
    //用StringBuffer去处理字符串      append / deleteCharAt
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == "")return new ArrayList<>();
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(digits, phoneMap, 0, new StringBuffer());
        return ans;
    }
    private void dfs(String digits, Map<Character, String> phoneMap, int startIndex, StringBuffer path){
        if(startIndex > digits.length() - 1){
            ans.add(path.toString());
            return;
        }
        for(int i = 0; i < phoneMap.get(digits.charAt(startIndex)).length(); i++){
            path.append(phoneMap.get(digits.charAt(startIndex)).charAt(i));
            dfs(digits, phoneMap, startIndex + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
