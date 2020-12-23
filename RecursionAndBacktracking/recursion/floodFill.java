package recursion;

public class floodFill {
    public static void main(String[] args) {
        int a[][] = {{1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,0,0},
                    {1,0,0,1,1,0,1,1},
                    {1,2,2,2,2,0,1,0},
                    {1,1,1,2,2,0,1,0},
                    {1,1,1,2,2,2,2,0},
                    {1,1,1,1,1,2,1,1},
                    {1,1,1,1,1,2,2,1}};

        print(a);
        System.out.println();

        func(a, 7, 0, 9, 1);

        print(a);
    }

    public static void func(int a[][] , int r, int c, int toFill, int prevFill) {
        int rows = a.length;
        int cols = a[0].length;

        if(r < 0 || r>= rows || c < 0 || c >= cols){
            return;
        }
        if(a[r][c] != prevFill){
            return;
        }

        a[r][c] = toFill;

        func(a,r-1,c,toFill,prevFill);      //upward
        func(a,r,c-1,toFill,prevFill);      //left
        func(a,r+1,c,toFill,prevFill);      //down
        func(a,r,c+1,toFill,prevFill);      //right
    }
    public static void print(int a[][]) {
        for(int arr[] : a){
            for(int item : arr){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
