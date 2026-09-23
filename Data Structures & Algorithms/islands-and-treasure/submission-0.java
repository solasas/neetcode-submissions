class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> qu=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    qu.add(new int[]{i,j});
                }
            }
        }
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        while(!qu.isEmpty()){
            int[] curr=qu.poll();
            int r=curr[0];
            int c=curr[1];
            for(int[] dir: directions){
                int newrow=r+dir[0];
                int newcol=c+dir[1];
                if(newrow<0 || newrow>=m || newcol<0 || newcol>=n){
                    continue;
                }
                if(grid[newrow][newcol]==-1){
                    continue;
                }
                if(grid[newrow][newcol]!=Integer.MAX_VALUE){
                    continue;
                }
                grid[newrow][newcol]=grid[r][c]+1;
                qu.offer(new int[]{newrow,newcol});
            }
        }
    }
}
