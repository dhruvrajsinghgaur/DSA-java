
import java.util.ArrayList;
import java.util.Arrays;

public class MazeProblems {
    public static void main(String[] args) {
       
        boolean[][] maze = {
        {true, true, true},
        {true, true, true},
        {true, true, true}
        };

        int[][] Patharr = new int[maze.length][maze[0].length];

     mazeproblemdiagonals("", 0, 0);
     System.out.println(mazeproblemdiagonals12("",0, 0));
     mazeproblemObstacles("", 0, 0, maze);
     mazeproblemAlldirections("", 0, 0, maze);
     mazeproblemAlldirectionswithcount("", 0, 0, maze, 0);

        mazeproblemAlldirectionsPathstepsandPathmatrix("", 0, 0, maze, Patharr,1);
      
    }

    // 1
    static void mazeproblem1(String path, int r, int c){
        if (r > 2 || c > 2){
            return;
        }

        if(r == 2 && c == 2){
            System.out.println(path);
            return;
        }
   
         mazeproblem1(path+"D", r+1, c);     // Down
         mazeproblem1(path+"R", r, c+1);     // Right

    }

    // 2
   // my solution and only valid for 2x2 grids
    static void mazeproblem(String path, int r, int c) {
        if (r == 2 && c == 2) {
            System.out.println(path);
            return;
        }

        if (r + c == 3) {
            if (r == 2) {
                mazeproblem1(path + "R", r, c + 1);
            } else {
                mazeproblem1(path + "D", r + 1, c);
            }
        } else {
            mazeproblem1(path + "D", r + 1, c);     // Down
            mazeproblem1(path + "R", r, c + 1);     // Right
        }
    }
    // 3
    // same program inthis we can just provide grid size accordig to us
     static void mazeproblemGrid(String path, int r, int c, int goalrow , int goalcol){
        if (r > goalrow || c > goalcol){
            return;
        }

        if(r == goalrow && c == goalcol){
            System.out.println(path);
            return;
        }
   
         mazeproblemGrid(path+"D", r+1, c, goalrow , goalcol);   // Down
         mazeproblemGrid(path+"R", r, c+1 , goalrow , goalcol);  // Right

    }
     // 4
     // this method will provide no.of paths to reach destination
     static int mazeproblemcount(int r, int c){
        if (r > 2 || c > 2){
            return 0;
        }

        if(r == 2 && c == 2){
            return 1;
        }
         
         int count1 = mazeproblemcount(r+1, c);     // Down
         int count2 = mazeproblemcount(r, c+1);     // Right
    
         return count1 + count2;
    }
    // 5
    // this method returns answers in the form of arraylist 
     static ArrayList<String> mazeproblem12(String path, int r, int c){
        if (r > 2 || c > 2){
            ArrayList<String> list = new ArrayList<>();
            return list;
        }

        if(r == 2 && c == 2){
          ArrayList<String> list = new ArrayList<>();
          list.add(path);
            return list;
        }
   
        ArrayList<String> f =  mazeproblem12(path+"D", r+1, c);     // Down
        ArrayList<String> s =  mazeproblem12(path+"R", r, c+1);     // Right
        f.addAll(s);

        return f;

    }
    // 6
    // this method will provide answers including diagonal paths 
     static void mazeproblemdiagonals(String path, int r, int c){
        if (r > 2 || c > 2){
            return;
        }

        if(r == 2 && c == 2){
            System.out.println(path);
            return;
        }
   
        mazeproblemdiagonals(path+"D", r+1, c);          // Down
        mazeproblemdiagonals(path+"X", r+1, c+1);        // Diagonal
        mazeproblemdiagonals(path+"R", r, c+1);          // Right

    }
     // 7
     // this method will provide answers including diagonal paths in the form of arraylist
       static ArrayList<String> mazeproblemdiagonals12(String path, int r, int c){
        if (r > 2 || c > 2){
            ArrayList<String> list = new ArrayList<>();
            return list;
        }

        if(r == 2 && c == 2){
          ArrayList<String> list = new ArrayList<>();
          list.add(path);
            return list;
        }
   
        ArrayList<String> f =  mazeproblemdiagonals12(path+"D", r+1, c);       // Down
         ArrayList<String> s =  mazeproblemdiagonals12(path+"X", r+1, c+1);    // Diagonal
        ArrayList<String> t =  mazeproblemdiagonals12(path+"R", r, c+1);       // Right
        f.addAll(s);
        f.addAll(t);


        return f;

    }

    // 8 
    // My method 
     static void mazeproblemObstacles(String path, int r, int c){
        if (r > 2 || c > 2){
            return;
        }

        if(r == 2 && c == 2){
            System.out.println(path);
            return;
        }

        if (r==1 && c==1) {                       //Obstacle at (1,1)
            return;
        }
   
         mazeproblemObstacles(path+"D", r+1, c);     // Down
         mazeproblemObstacles(path+"R", r, c+1);     // Right

    }
    // 9
     static void mazeproblemObstacles(String path, int r, int c, boolean[][] maze){

        if (r > maze.length - 1  || c > maze[0].length - 1){
            return;
        }

        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }

        if (!maze[r][c]){
          return;
        }

        mazeproblemObstacles(path+"D", r+1, c,maze);     // Down
        mazeproblemObstacles(path+"R", r, c+1,maze);     // Right
    }

    // 10
    // maze problem with every direction
     static void mazeproblemAlldirections(String path, int r, int c, boolean[][] maze){

        if (r > maze.length - 1  || c > maze[0].length - 1 || r < 0 || c < 0){
            return;
        }

        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }

        if (!maze[r][c]){
          return;
        }

        // this line is to mark the cell false 
        maze[r][c] = false;

        mazeproblemAlldirections(path+"D", r+1, c,maze);     // Down
        mazeproblemAlldirections(path+"R", r, c+1,maze);     // Right
        mazeproblemAlldirections(path+"U", r-1, c,maze);     // Up
        mazeproblemAlldirections(path+"L", r, c-1,maze);     // Left

        // this line is where the function will be over so to again mark the cell true
        // when the function gets removed also remove the changes that were made by that function
         maze[r][c] = true;
    }
// this method will also return the step count 
 static void mazeproblemAlldirectionswithcount(String path, int r, int c, boolean[][] maze, int count){

        if (r > maze.length - 1  || c > maze[0].length - 1 || r < 0 || c < 0){
            return;
        }

        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(path);
            System.out.println(count);
            return;
        }

        if (!maze[r][c]){
          return;
        }

        // this line is to mark the cell false 
        maze[r][c] = false;

        mazeproblemAlldirectionswithcount(path+"D", r+1, c,maze, count+1);     // Down
        mazeproblemAlldirectionswithcount(path+"R", r, c+1,maze, count+1);     // Right
        mazeproblemAlldirectionswithcount(path+"U", r-1, c,maze, count+1);     // Up
        mazeproblemAlldirectionswithcount(path+"L", r, c-1,maze, count+1);     // Left

        // this line is where the function will be over so to again mark the cell true
        // when the function gets removed also remove the changes that were made by that function
         maze[r][c] = true;
    }
// this method will return the path steps and path matrix
 static void mazeproblemAlldirectionsPathstepsandPathmatrix(String path, int r, int c, boolean[][] maze, int[][] Patharr, int steps){

        if (r > maze.length - 1  || c > maze[0].length - 1 || r < 0 || c < 0){
            return;
        }

        if(r == maze.length - 1 && c == maze[0].length - 1){
              Patharr[r][c] = steps;
            System.out.println(path);

            for(int[] arr : Patharr){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
           
            return;
        }

        if (!maze[r][c]){
          return;
        }

        // this line is to mark the cell false 
        maze[r][c] = false;
        Patharr[r][c] = steps;

        mazeproblemAlldirectionsPathstepsandPathmatrix(path+"D", r+1, c,maze, Patharr, steps+1);     // Down
        mazeproblemAlldirectionsPathstepsandPathmatrix(path+"R", r, c+1,maze, Patharr, steps+1);     // Right
        mazeproblemAlldirectionsPathstepsandPathmatrix(path+"U", r-1, c,maze, Patharr, steps+1);     // Up
        mazeproblemAlldirectionsPathstepsandPathmatrix(path+"L", r, c-1,maze, Patharr, steps+1);     // Left

        // this line is where the function will be over so to again mark the cell true
        // when the function gets removed also remove the changes that were made by that function
         maze[r][c] = true;
         Patharr[r][c] = 0;

    }


    
    
}


