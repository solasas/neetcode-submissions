class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean [][] pacific=new boolean[m][n];
        boolean [][] atlantic=new boolean[m][n];
        for(int i=0;i<n;i++){
            dfs(heights,pacific,0,i);
        }
        for(int i=0;i<m;i++){
            dfs(heights,pacific,i,0);
        }
        for(int i=0;i<n;i++){
            dfs(heights,atlantic,m-1,i);
        }
        for(int i=0;i<m;i++){
            dfs(heights,atlantic,i,n-1);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j]&& atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] heights,boolean[][] vis,int r,int c){
        int m=heights.length;
        int n=heights[0].length;
        if(vis[r][c]){
            return;
        }
        vis[r][c]=true;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir:directions){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(nr<0 || nr>=m || nc<0 || nc>=n){
                continue;
            }
            if(heights[nr][nc]<heights[r][c]){
                continue;
            }
            dfs(heights,vis,nr,nc);
        }
    }
}
