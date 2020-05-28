package dynamic;

public class Triangle {

    private static int max = Integer.MIN_VALUE;
    private static int[][] cache;

    public static int solution(int[][] triangle) {
        cache = new int[triangle.length][triangle.length];

        max = rootSum(0, 0, triangle);
        System.out.println(max);
        return max;
    }

    private static int rootSum(int x, int y, int[][] triangle) {
        if (x == triangle.length) {
            return 0;
        }

        if (cache[x][y] != 0) {
            return cache[x][y];
        }

        return cache[x][y] = triangle[x][y] + Math.max(rootSum(x+1, y, triangle), rootSum(x+1, y+1, triangle));
    }

    public static void main(String[] args) {
        int[][] a = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        solution(a);
    }
}
