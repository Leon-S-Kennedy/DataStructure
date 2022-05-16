package stack_queue.leetcode.p20;

import java.util.*;

class Solution {
    public boolean pipei(char a,char b){
        if(a=='('&&b==')'){
            return true;
        }else if(a=='['&&b==']'){
            return true;
        }else return a == '{' && b == '}';
    }
    public boolean isValid(String s) {
        Deque<Character> stack=new LinkedList<>();
        char[] c=s.toCharArray();
        for( char c1: c){
            if(c1=='('||c1=='['||c1=='{'){
                stack.push(c1);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    if(!pipei(stack.pop(),c1)){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}