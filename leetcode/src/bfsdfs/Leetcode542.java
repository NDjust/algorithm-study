package bfsdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode542 {


    public int[][] updateMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        if(c == 0){
            return matrix;
        }
        LinkedList<int[]> pq=new LinkedList<>();
        int[][] visited = new int[r][c];

        for(int[] l: visited) {
            Arrays.fill(l, -1);
        }

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (matrix[i][j] == 0){
                    pq.addLast(new int[]{i,j});
                    visited[i][j] = 0;
                }
            }
        }

        int[][] dxdy = {
                {0,1},{1,0},
                {0,-1},{-1,0}
        };

        while(pq.size() != 0){
            int size = pq.size();

            while(size-- > 0){
                int[] poll = pq.removeFirst();
                int x = poll[0];
                int y = poll[1];
                for(int i=0;i<4;i++){
                    int dx = x + dxdy[i][0];
                    int dy = y + dxdy[i][1];
                    if(dx >= 0 && dy >= 0 && dx < r && dy < c && matrix[dx][dy] == 1 && visited[dx][dy] == -1) {
                        pq.addLast(new int[]{dx,dy});
                        visited[dx][dy]=visited[x][y]+1;

                    }
                }
            }
        }
        return visited;
    }
}
