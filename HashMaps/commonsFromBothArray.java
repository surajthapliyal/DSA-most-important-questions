import java.util.HashMap;

public class commonsFromBothArray {
    public static void main(String[] args) {
        int a[] = {1,1,2,2,3,3,4,4,5,5,6};
        int b[] = {2,45,1,24,3,3,2,1,4,5,6,1,1};

        HashMap<Integer, Integer> h1 = new HashMap<>();

        // making frequency map for a:
        for (int i = 0; i < a.length; i++) {
            if (h1.containsKey(a[i])) {
                h1.put(a[i], h1.get(a[i]) + 1);
            } else {
                h1.put(a[i], 1);
            }
        }
        // now loop on b and if the key is also present in b then print and remove key from a:
        for (int i = 0; i < b.length; i++) {
            int key = b[i];
            if (h1.containsKey(key)) {
                System.out.print(key + "  ");
                h1.remove(key);
            } else {
                continue;
            }
        }
    }
}
