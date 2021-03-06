package heap.leetcode.p1046;

import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int stone : stones) {
            pq.offer(stone);
        }
        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();
            if(a>b){
                pq.offer(a-b);
            }
        }
        return pq.isEmpty() ? 0:pq.poll();
    }
}
