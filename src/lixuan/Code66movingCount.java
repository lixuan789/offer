package lixuan;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Code66movingCount {

    /**
     * 该题目注意不要进行回溯，因为是遍历出所有的方格，而不是某一条路径
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return dfs(threshold, rows, cols, 0, 0, visited);

    }

    private int dfs(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || numOfSum(i) + numOfSum(j) > threshold) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(threshold, rows, cols, i, j-1, visited)+
                dfs(threshold, rows, cols, i, j+1, visited)+
                dfs(threshold, rows, cols, i+1, j, visited)+
                dfs(threshold, rows, cols, i-1, j, visited)+1;
    }

    private int numOfSum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }


    /*
    private int count = 0;
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        dfs(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private void dfs(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) {
            return;
        }
        if (!visited[i][j]) {
            visited[i][j] = true;
            int sum = 0;
            sum+=numOfSum(i);
            sum+=numOfSum(j);
            if (sum > threshold) {
                return;
            }else {
                count++;
            }
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                dfs(threshold, rows, cols, x, y, visited);
            }
            visited[i][j] = false;

        }

    }

    private int numOfSum(int i) {
        int sum=0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }*/


}
