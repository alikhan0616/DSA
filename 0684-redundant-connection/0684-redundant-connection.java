class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        int[] ranks = new int[edges.length + 1];
        
        for(int i = 1 ; i <= edges.length ; i++){
            par[i] = i;
            ranks[i] = 1;
        }

        for(int[] edge : edges){
            int n1 = edge[0];
            int n2 = edge[1];
            if(!union(n1, n2, par, ranks)){
                return edge;
            }
        }
        return new int[]{0};
    }
    private int find(int n, int[] par){
        int p = par[n];
        while(p != par[p]){
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    private boolean union(int n1, int n2, int[] par, int[] ranks){
        int p1 = find(n1, par);
        int p2 = find(n2, par);
        if(p1 == p2){
            return false;
        }
        if(ranks[p1] > ranks[p2]){
           par[p2] = p1;
           ranks[p1] += ranks[p2]; 
        } else {
             par[p1] = p2;
           ranks[p2] += ranks[p1]; 
        }
        return true;
    }
}