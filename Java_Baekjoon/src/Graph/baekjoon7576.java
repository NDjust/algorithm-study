package Graph;

import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    //열, 행
    public Point(int inX, int inY) {
        this.x = inX;
        this.y = inY;
    }
}

public class baekjoon7576 {
    static int[][] container;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N;
    static int M;

    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        Queue<Point> queue = new LinkedList<Point>();
        // Col (x)
        N = Integer.parseInt(st.nextToken());
        // Row (y)
        M = Integer.parseInt(st.nextToken());

        //out of range 를 막기 위해 N + 2, M + 2
        container = new int[M+2][N+2];

        Arrays.fill(container[0], -1);
        Arrays.fill(container[M+1], -1);

        //행 : y
        for(int i = 1; i <= M; i++) {
            String[] input = in.readLine().split(" ");
            //토마토가 올수 없는 자리는 -1
            container[i][0] = -1;
            container[i][N + 1] = -1;

            for(int j = 1; j <= N; j++) {
                int tomato = Integer.parseInt(input[j - 1]);
                container[i][j] = tomato;
                //토마토가 위치해 있는곳을 표시
                if(tomato == 1) {
                    queue.offer(new Point(j, i));
                }
            }
        }

        System.out.println(calcDate(queue));
    }

    public static int calcDate(Queue<Point> queue) {
        int max = 0;
        // N, M에 다다르면 멈춤.
        while(!queue.isEmpty()) {
            Point p = queue.poll();

            //상하 좌우로 움직이기
            for(int i = 0; i < 4; i++) {
                int[] d = move[i];
                int nextX = p.x + d[0];
                int nextY = p.y + d[1];

                //토마토 발견! && 토마토 아직 안익힘
                if(container[nextY][nextX] == 0) {
                    container[nextY][nextX] = container[p.y][p.x] + 1;
                    queue.offer(new Point(nextX, nextY));
                }
            }

        }

        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <=N; j++) {
                //안익힌 토마토가 발견되면 -1
                if(container[i][j] == 0 ) return -1;
                max = Math.max(container[i][j], max);
            }
        }

        return max - 1;
    }

}
