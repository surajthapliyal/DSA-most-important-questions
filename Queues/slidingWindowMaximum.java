import java.util.*;

public class slidingWindowMaximum {
    public static void main(String[] args) {
        int a[] = {4,3,1,2,5,3,4,7,1,9};
        int k = 3;
        // usingQueue(a,k);
        solution s =  new solution();
        int ans[] = s.usingDeque(a, k);
        for(int each : ans){
            System.out.print(each + " ");
        }
    }
    static void usingQueue(int a[],int k){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<a.length;i++){
            // initializing first window:
            if(i<k)q.add(a[i]);
            // for mid windows:
            else{
                // print max of that window:
                System.out.print(Collections.max(q) + " ");
                // for moving window one step forward,remove one element from front and add one from rear:
                q.remove();
                q.add(a[i]);
            }
        }
        // print max of last window:
        System.out.print(Collections.max(q) + " ");
    }

    static class solution  {
        public int[] usingDeque(int a[],int k){
            int n = a.length;
            // if array is empty or contains only one element ,return:
            if(n<=1) return a;
            int ans[] = new int[n-k+1];
            Deque<Integer> dq = new LinkedList<>();
            int i = 0;
            
            // for first window:
            for(;i<n;i++){
                if(i<k){
                    // if new element to be added is large than the element in the last of the deque
                    // then remove the last element of the deque until it becomes empty or the new element to 
                    // add is not small than the last element:
                    while(!dq.isEmpty() && a[dq.peekLast()] <= a[i]){
                        dq.removeLast();
                    }
                    // now add the index of the new element in the deque at last:
                    dq.addLast(i);
                }else{
                    // add max element in the ans :
                    ans[i-k] = a[dq.peekFirst()];      //as max element is in the first of the deque.


                    // now moving window forward:
                    while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                        dq.removeFirst();
                    }
                    while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) {
                        dq.removeLast();
                    }
                    dq.addLast(i);
                }
            }
            // for last window :
            ans[i-k] = a[dq.peekFirst()];
            return ans;
        }
    }
}
