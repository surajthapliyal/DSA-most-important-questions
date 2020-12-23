package backtracking;

public class shortestPathInABinaryMaze {
    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
                        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
                        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
                        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

        int result = shortestPath(maze, 0, 0, 5, 0);
        if(result >= 1000000){
            System.out.println("No Path Possible!");
        }else{
        System.out.println("Shortest path = " + result);
        }
    }

    static int shortestPath(int maze[][] , int i , int j , int x , int y){
        int rows = maze.length;
        int cols = maze[0].length;

        // to record which path is visited:
        boolean vis[][] = new boolean[rows][cols];

        return shortestPath(maze , i , j , x , y , vis);
    }

    static boolean isValidPath(int maze[][] , int i , int j , boolean vis[][]){
        int rows = maze.length;
        int cols = maze[0].length;

        // valid only if i is valid index for row , j is valid index for col
        // and if the block is having 1 in it as we can only move in the 1's blocks
        // and if the path is not visited previously:
        return i>=0 && j>=0 && i<rows && j<cols && maze[i][j]==1 && !vis[i][j];
    }
    // method overloading:
    static int shortestPath(int maze[][] , int i , int j , int x , int y , boolean vis[][]){
        // if there is no path then return the max value to indicate no smallest path:
        if(!isValidPath(maze, i, j, vis)) return 1000000;
        //if source is the destination itself : 
        if(i==x && j==y) return 0;

        // first make the path visited true in which you are already :
        vis[i][j] = true;

        // now move all valid sides and find path length from all paths :
        int left = shortestPath(maze, i, j-1, x, y, vis) + 1;
        int bottom =  shortestPath(maze, i+1, j, x, y, vis) + 1;
        int right =  shortestPath(maze, i, j+1, x, y, vis) + 1;
        int top = shortestPath(maze, i-1, j, x, y, vis) + 1;

        // now do backtrack i.e., mark this path false back , as in another path
        // whose route crosses between this path will not be able to check if this
        // path is already true :
        vis[i][j] = false;


        // now return the smallest path from all paths :
        return Math.min(Math.min(left , right), Math.min(top , bottom));
    } 
}
