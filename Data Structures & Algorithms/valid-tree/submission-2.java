class Solution {
    int[] parent;
    int[] rank;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            if(findUPar(u)==findUPar(v)){
                return false;
            }
            union(u,v);
        }
        return true;
    }
    private int findUPar(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=findUPar(parent[node]);
    }
    private void union(int u,int v){
        int upar_u=findUPar(u);
        int upar_v=findUPar(v);
        if(upar_u==upar_v){
            return;
        }
        else if(rank[upar_u]<rank[upar_v]){
            parent[upar_u]=upar_v;
        }
        else if(rank[upar_u]>rank[upar_v]){
            parent[upar_v]=upar_u;
        }
        else{
            parent[upar_u]=upar_v;
            rank[upar_v]++;
        }
    }
}
