import java.util.List;

public class FindPath {
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path){
        if(maze[x][y]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[x][y]==0){
            maze[x][y]=2;
            if(searchPath(maze,x-1,y,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            if(searchPath(maze,x+1,y,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            if (searchPath(maze,x,y+1,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            if(searchPath(maze,x,y-1,path)){
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}
