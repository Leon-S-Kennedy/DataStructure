package stack_queue.leetcode.p844;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stack=new LinkedList<>();
        String str1= extracted(s,stack);
        stack.clear();
        String str2= extracted(t,stack);
        return str1.equals(str2);
    }

    private String extracted(String s, Deque<Character> stack) {
        for (char c : s.toCharArray()) {
            if(stack.isEmpty()){
                if (c=='#'){
                    ;
                }else {
                    stack.push(c);
                }
            }else {
                if(c!='#'){
                    stack.push(c);
                }else {
                    stack.pop();
                }
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        String s="ab#c";
        String t="ad#c";
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare(s, t));
    }
}