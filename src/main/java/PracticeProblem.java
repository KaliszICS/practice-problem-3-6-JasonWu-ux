import java.util.LinkedList;
import java.util.Queue;

public class PracticeProblem {

	public static void main(String args[]) {

	}
    public static int searchMazeMoves(String[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        
        
        int startRow = rows - 1;
        int startCol = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol, 0}); 
        
        boolean[][] visited = new boolean[rows][cols];
        visited[startRow][startCol] = true;
        
        int[][] directions = {{-1, 0}, {0, 1}}; 
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int moves = current[2];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && 
                    !maze[nr][nc].equals("*") && !visited[nr][nc]) {
                    
                    if (maze[nr][nc].equals("F")) {
                        return moves + 1;
                    }
                    
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, moves + 1});
                }
            }
        }
        
        return -1; 
    }

	public static int noOfPaths(String[][] maze) {
        if (maze == null || maze.length == 0) return 0;
        

        int startRow = maze.length - 1;
        int startCol = 0;
        
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        return countPathsRecursive(maze, startRow, startCol, visited);
    }

    private static int countPathsRecursive(String[][] maze, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= maze.length || c < 0 || c >= maze[0].length || 
            maze[r][c].equals("*")) {
            return 0;
        }

        if (maze[r][c].equals("F")) {
            return 1;
        }

        int totalPaths = 0;
        totalPaths += countPathsRecursive(maze, r - 1, c, visited); // Up
        totalPaths += countPathsRecursive(maze, r, c + 1, visited); // Right

        return totalPaths;
    }
}


