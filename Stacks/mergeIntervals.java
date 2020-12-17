import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
class pairs// implements Comparable<pairs>{
    {
    int start;
    int end;
    pairs(int start , int end){
        this.start = start;
        this.end = end;
    }
    // public int compareTo(pairs other){
    //     if(this.start != other.start) return this.start - other.start;
    //     else return this.end - other.end;
    // }
}
public class mergeIntervals {
    public static void main(String[] args) {
        ArrayList<pairs> a = new ArrayList<>();
        pairs p1 = new pairs(1,3);
        pairs p2 = new pairs(2,6);
        pairs p3 = new pairs(8,10);
        pairs p4 = new pairs(8,9);
        pairs p5 = new pairs(9,11);
        pairs p6 = new pairs(15, 18);
        pairs p7 = new pairs(2, 4);
        pairs p8 = new pairs(16, 17);

        a.add(0, p1);
        a.add(1, p2);
        a.add(2, p3);
        a.add(3, p4);
        a.add(4, p5);
        a.add(4, p6);
        a.add(4, p7);
        a.add(4, p8);

        for(pairs p : a){
            System.out.print("("+p.start + "," + p.end + ")" + " ");
        }

        System.out.println();
        solution(a);
    }
    static void solution(ArrayList<pairs> a){
        // if we dont implements comparable in the pair class then we can do this for sorting :

        Collections.sort(a , new Comparator<pairs>(){
            public int compare(pairs a , pairs b){
                // if both start are same then sort on the basis of end otherwise sort on the basis of start:
                return a.start - b.start == 0 ? a.end - b.end : a.start - b.start;
            }
        });

        // Collections.sort(a);
        Stack<pairs> s = new Stack<>();
        s.push(a.get(0));
        for(int i=1;i<a.size();i++){
            if(a.get(i).start <= s.peek().end){ 
                pairs toCheckWith = s.pop();

                pairs newPair = merge(a.get(i) , toCheckWith);
                s.push(newPair);
            }
            else s.push(a.get(i));
        }
        ArrayList<pairs> ans = new ArrayList<>(s);
        // Collections.sort(ans);
        Collections.sort(ans,new Comparator<pairs>(){
            public int compare(pairs a , pairs b){
                return a.start - b.start == 0 ? a.end - b.end : a.start - b.start;
            }
        });
        
        for(int i=0;i<ans.size();i++){
            System.out.print("(" + ans.get(i).start + "," + ans.get(i).end + ")");
        }
    }
    static pairs merge(pairs pair1, pairs pair2){
        int newStart = Math.min(pair1.start , pair2.start);
        int newEnd = Math.max(pair1.end , pair2.end);
        pairs newPair = new pairs(newStart, newEnd);
        return newPair;
    }
}
