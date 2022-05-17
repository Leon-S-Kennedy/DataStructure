package stack_queue.leetcode.p622;

class MyCircularQueue {
    int[] array;
    int frontIndex;
    int rearIndex;
    int size;

    public MyCircularQueue(int k) {
        array=new int[k];
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }else{
            array[rearIndex]=value;
            rearIndex=(rearIndex+1)%array.length;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        frontIndex=(frontIndex+1)%array.length;
        size--;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }else{
            return array[frontIndex];
        }
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }else{
            return array[(rearIndex-1+array.length)%array.length];
        }

    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==array.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */