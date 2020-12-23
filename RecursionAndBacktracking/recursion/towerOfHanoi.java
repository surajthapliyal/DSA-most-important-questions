package recursion;
// move all blocks from one tower to another in such a way that only one block can be 
// shift once at a time and no large block can come above a small block :
public class towerOfHanoi {
    public static void main(String[] args) {
        moves(4, 'A', 'C', 'B');
    }
    public static void moves(int n , char a , char b , char c) {
        
        if(n==0) return;
        
        moves(n-1 , a , c, b);
        System.out.println("Move " + n + "th disk from " + a + " to " + c);
        moves(n-1, b, a, c);
    }
}
