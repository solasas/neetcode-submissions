class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] effort=new int[m][n];
        for(int[] row: effort){
        Arrays.fill(row,Integer.MAX_VALUE);
        }
        effort[0][0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int currEffort=curr[0];
            int row=curr[1];
            int col=curr[2];
            if(row==m-1 && col==n-1){
                return currEffort;
            }
            if(currEffort>effort[row][col]){
                continue;
            }
            for(int[] dir: directions){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if(newRow<0 || newRow>=m || newCol<0 || newCol>=n){
                    continue;
                }
                int edgeEffort=Math.abs(heights[newRow][newCol]-heights[row][col]);
                int newEffort=Math.max(currEffort,edgeEffort);
                if(newEffort<effort[newRow][newCol]){
                    effort[newRow][newCol]=newEffort;
                    pq.add(new int[]{newEffort,newRow,newCol});
                }
            }
            
        }
        return -1;
    }
}