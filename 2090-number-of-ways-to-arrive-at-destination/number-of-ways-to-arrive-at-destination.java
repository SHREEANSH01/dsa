class Solution {
    static final int MOD = 1000000007;
    class Pair{
        int node;
        long wt;
        Pair(int node,long wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] road: roads){
            int u = road[0];
            int v = road[1];
            long wei= road[2];
            adj.get(u).add(new Pair(v,wei));
            adj.get(v).add(new Pair(u,wei));
        }
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((a,b)->Long.compare(a.wt,b.wt));
        long [] dist=new long [n];
        int [] ways= new int [n];
        for(int i=0;i<n;i++){
            dist[i]=Long.MAX_VALUE;
            ways[i]=0;
        }
        dist[0]=0;
        ways[0]=1;
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair curr= pq.poll();
            int nd=curr.node;
            long wei=curr.wt;
            if (wei > dist[nd]) {
                continue;
            }
            for(Pair nei: adj.get(nd)){
                int adjNode= nei.node;
                long weight=nei.wt;
                if(dist[nd]+weight<dist[adjNode]){
                    dist[adjNode]=dist[nd]+weight;
                    ways[adjNode]=ways[nd];
                    pq.offer(new Pair(adjNode,dist[adjNode]));
                }else if(dist[nd]+weight==dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[nd]) % MOD;
                }
            }
        }
        return ways[n-1];
    }
}