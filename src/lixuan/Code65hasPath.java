package lixuan;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */

//方法：DFS
public class Code65hasPath {
    private int[] dx={0,0,-1,1};
    private int[] dy={1,-1,0,0};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] visited=new boolean[rows][cols];
        char[][] matrixTemp=new char[rows][cols];
        for (int i=0;i<matrix.length;i++){
            matrixTemp[i/cols][i%cols]=matrix[i];
        }
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j]&&dfs(matrixTemp,i,j,str,0,visited)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] matrix, int i, int j, char[] str, int index, boolean[][] visited) {
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||matrix[i][j]!=str[index]){
            return false;
        }
        if(matrix[i][j]==str[index]&&!visited[i][j]){
            if(index==(str.length-1)){
                return true;
            }else if(index<(str.length-1)){
                visited[i][j]=true;
                for (int k=0;k<4;k++){
                    int x=i+dx[k];
                    int y=j+dy[k];
                    if(dfs(matrix,x,y,str,index+1,visited)){
                        return true;
                    }
                }
                visited[i][j]=false;//回溯
            }

        }
        return false;
    }

    //方法二
    /*
    private int[] dx={0,0,-1,1};
    private int[] dy={1,-1,0,0};
    private boolean flag=false;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] visited=new boolean[rows][cols];
        char[][] matrixTemp=new char[rows][cols];
        for (int i=0;i<matrix.length;i++){
            matrixTemp[i/cols][i%cols]=matrix[i];
        }
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j]){
                    dfs(matrixTemp,i,j,str,0,visited);
                }
            }
        }
        return flag;

    }

    private void dfs(char[][] matrix, int i, int j, char[] str, int index, boolean[][] visited) {
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length){
            return;
        }
        if(matrix[i][j]==str[index]&&!visited[i][j]){
            if(index==(str.length-1)){
                flag=true;
                return;
            }else if(index<(str.length-1)){
                visited[i][j]=true;
                for (int k=0;k<4;k++){
                    int x=i+dx[k];
                    int y=j+dy[k];
                    dfs(matrix,x,y,str,index+1,visited);
                }
                visited[i][j]=false;//回溯
            }

        }

    }
    */

}
