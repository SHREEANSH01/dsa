class Solution {
    class Pair{
        int wt;
        int node;
        Pair(int wt,int node){
            this.wt=wt;
            this.node=node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int [] dist= new int [n+1];
        for(int i=0;i<=n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] time:times){
            int u=time[0];
            int v=time[1];
            int wt=time[2];
            adj.get(u).add(new Pair(wt,v));
        }
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((a,b)->a.wt-b.wt);
        dist[k]=0;
        pq.offer(new Pair(0,k));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int nd=curr.node;
            int wei=curr.wt;
            for(Pair nei: adj.get(nd)){
                int adjNode=nei.node;
                int weight=nei.wt;
                if(dist[nd]+weight<dist[adjNode]){
                    dist[adjNode]=dist[nd]+weight;
                    pq.offer(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        int time=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            time=Math.max(time,dist[i]);
        }
        
        return time;
    }
}