package lixuan;

import java.util.ArrayList;

public class Code19PrintMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int top=0;//上
        int bottom=matrix.length-1;//下
        int left=0;//左
        int right=matrix[0].length-1;//右
        /*int sum=matrix.length*matrix[0].length;
        int count=0;*/
        ArrayList<Integer> list = new ArrayList<>();
        while (top<=bottom&&left<=right){
            for (int i = left; i <=right ; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            if(top>bottom){
                break;
            }
            for (int i = top; i <= bottom ; i++) {
                list.add(matrix[i][right]);

            }
            right--;
            if(left>right){
                break;
            }
            for (int j=right;j>=left;j--){
                list.add(matrix[bottom][j]);
            }
            bottom--;
            if(top>bottom){
                break;
            }
            for (int j=bottom;j>=top;j--){
                list.add(matrix[j][left]);
            }
            left++;
            if(left>right){
                break;
            }

        }
        return list;
    }

    // 走的方向：向右、向下、向左、向上
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    public ArrayList<Integer> printMatrix1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[][] vis = new boolean[n][m];
        ArrayList<Integer> list = new ArrayList<>();

        int x = 0, y = 0, dir = 0;
        while (x >= 0 && x < n && y >= 0 && y < m && !vis[x][y]) {
            list.add(matrix[x][y]);
            vis[x][y] = true;

            // 试着继续向dir的方向走
            while (x + dx[dir] >= 0 && x + dx[dir] < n && y + dy[dir] >= 0 && y + dy[dir] < m && !vis[x + dx[dir]][y + dy[dir]]) {
                x += dx[dir];
                y += dy[dir];
                list.add(matrix[x][y]);
                vis[x][y] = true;
            }
            // 走不动了换方向
            dir = (dir + 1) % 4;
            x += dx[dir];
            y += dy[dir];
        }
        return list;
    }

    public static void main(String[] args) {
        /*int [][] matrix= {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12,},
                {13, 14, 15, 16}
        };*/
        int [][] matrix= {{1},{2},{3},{4},{5}};
        ArrayList<Integer> list = new ArrayList<>();
        list=printMatrix(matrix);
        for (Integer num : list) {
            System.out.println(num);
        }
    }
}
