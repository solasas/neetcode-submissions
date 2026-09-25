class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(board,vis,0,i);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board,vis,i,0);
            }
        }
        for(int i=0;i<n;i++){
            if(board[m-1][i]=='O'){
                dfs(board,vis,m-1,i);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O'){
                dfs(board,vis,i,n-1);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(char[][] board,boolean[][] vis,int row,int col){
        int m=board.length;
        int n=board[0].length;
        vis[row][col]=true;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir: directions){
            int newrow=row+dir[0];
            int newcol=col+dir[1];
            if(newrow<0 || newcol<0 || newrow>=m || newcol>=n){
                continue;
            }
            if(vis[newrow][newcol]){
                continue;
            }
            if(board[newrow][newcol]=='O'){
                dfs(board,vis,newrow,newcol);
            }
        }
    }
}
