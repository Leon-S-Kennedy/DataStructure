package aboutCollection.leetcode.p118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> rows=new ArrayList<>();
        rows.add(1);
        ans.add(rows);
        if(numRows==1){
            return ans;
        }
        rows=new ArrayList<>();
        rows.add(1);
        rows.add(1);
        ans.add(rows);
        if(numRows==2){
            return ans;
        }
        for (int i = 2; i <numRows ; i++) {
            rows=new ArrayList<>();
            rows.add(1);
            for (int j = 1; j < i; j++) {
                rows.add((ans.get(i-1).get(j-1)+ans.get(i-1).get(j)));
            }
            rows.add(1);
            ans.add(rows);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generate(10));
    }
}
