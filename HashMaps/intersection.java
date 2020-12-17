import java.util.HashMap;

public class intersection {
    public static void main(String[] args) {
        int a[] = {1,1,2,2,2,3,5};
        int b[] = {1,1,1,2,2,4,5};
        HashMap<Integer,Integer> h = new HashMap<>();

        // creating frequency map for a:
        for(int i=0;i<a.length;i++){
            int key = a[i];
            if(h.containsKey(key)){
                h.put(key,h.get(key)+1);
            }else{
                h.put(key,1);
            }
        }

        // now loop for b and if b[i]key is present in map,
        // then decrease value by 1 , if value become 0 , do nothing.
        for(int i=0;i<b.length;i++){
            int key = b[i];
            if(h.containsKey(key) && h.get(key) > 0){
                System.out.print(key + " ");
                h.put(key,h.get(key) - 1);
            }else{
                continue;
            }
        }
    }
}
