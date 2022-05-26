package heap.leetcode.P17_14;

import java.util.*;
class Solution {
    public void adjust_heap(int[] heap,int t){
        if(heap[0]>t){
            heap[0]=t;
            shiftDown(heap,heap.length,0);
        }
    }

    public int[] smallestK(int[] arr, int k) {
        if(arr.length==0||k==0){
            return new int[0];
        }
        int[] heap=makeHeap(arr,k);
        for(int i=k;i<arr.length;i++){
            adjust_heap(heap,arr[i]);
        }
        return heap;
    }
    public int[] makeHeap(int[] arr,int k){
        int[] list=Arrays.copyOf(arr,k);
        for(int i=(k-2)/2;i>=0;i--){
            shiftDown(list,k,i);
        }
        return list;
    }
    public void shiftDown(int[] arr,int size,int i){
        while(true){
            int left=2*i+1;
            if(left>=size){
                return;
            }
            int right =left+1;
            int max=left;
            if(right<size&&arr[right]>arr[left]){
                max=right;
            }

            if(arr[i]>=arr[max]){
                return;
            }

            int t =arr[i];
            arr[i]=arr[max];
            arr[max]=t;

            i=max;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};

    }
}