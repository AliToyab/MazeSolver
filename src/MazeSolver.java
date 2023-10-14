import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MazeSolver extends JFrame {
    private int maze[][]=
            {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,1,1,1,1,1,0,1,1,1,1,1},
        {1,0,0,0,0,0,1,1,1,0,1,1,1,1,1},
        {1,0,1,1,0,0,0,1,1,0,1,1,1,1,1},
        {1,0,1,1,1,1,0,1,1,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,1,1,0,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,1,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

    List<Integer> path=new ArrayList<>();

    MazeSolver(){
        setTitle("Maze Solver");
        setSize(640,420);
        FindPath.searchPath(maze,1,1,path);
    }

    @Override
    public void paint(Graphics g) {
        g.translate(50,70);
        for (int i=0;i< maze.length;i++){
            for(int j=0;j< maze[0].length;j++){
                Color color;
                switch (maze[i][j]){
                    case 1:color=Color.BLACK;break;
                    case 9:color=Color.RED;break;
                    default:color=Color.WHITE;break;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.RED);
                g.drawRect(30*j,30*i,30,30);
            }
        }

        for (int i=0;i<path.size();i+=2){
            int pathX=path.get(i);
            int pathY=path.get(i+1);
            g.setColor(Color.CYAN);
            g.fillRect(30*pathY,30*pathX,20,20);
        }
    }

    public static void main(String[] args) {
        MazeSolver view=new MazeSolver();
        view.setVisible(true);
    }
}
