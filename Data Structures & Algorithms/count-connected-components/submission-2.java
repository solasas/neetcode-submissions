class Solution {
    int[] parent;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int components=n;
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            if(uPar(u)!=uPar(v)){
                union(u,v);
                components--;
            }
        }
        return components;
    }
    private int uPar(int node){
        if(node==parent[node]){
            return node;
        }
        return parent[node]=uPar(parent[node]);
    }
    private void union(int u,int v){
        int upar=uPar(u);
        int vpar=uPar(v);
        if(upar==vpar){
            return;
        }
        else if(rank[upar]<rank[vpar]){
            parent[upar]=vpar;
        }
        else if(rank[upar]>rank[vpar]){
            parent[vpar]=upar;
        }
        else{
            parent[vpar]=upar;
            rank[upar]++;
        }
    }
}
