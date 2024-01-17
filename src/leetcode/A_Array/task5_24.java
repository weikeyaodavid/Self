package leetcode.A_Array;

import java.util.ArrayList;
import java.util.List;

public class task5_24 {

    //165. Compare Version Numbers
    //split（"."） 方法需要转意符号，要不以为是正则表达式 split（"//."）
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while(i < s1.length || j < s2.length){
            String a = i < s1.length ? s1[i] : "0";
            String b = i < s2.length ? s2[j] : "0";
            int a1 = Integer.parseInt(a);
            int b1 = Integer.parseInt(b);
            if(a1 > b1){
                return 1;
            }else if(a1 < b1){
                return -1;
            }else {
                i++;
                j++;
            }
        }
        return 0;
    }



    //763. Partition Labels
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] ref = new int[26];
        for(int i = 0; i < s.length(); i++){
            ref[s.charAt(i) - 'a'] = i;
        }
        int first = 0;
        int last = 0;
        for(int i = 0; i < s.length(); i++){
            last = Math.max(ref[s.charAt(i) - 'a'], last);
            if(last == i){
                res.add(last - first + 1);
                first = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");
    }
}
