class Solution {
    class Pair{
        int node;
        int edgewt;
        Pair(int node,int edgewt){
            this.node=node;
            this.edgewt=edgewt;
        }
    }
    class tuple{
        int stop;
        int node;
        int dist;
        tuple(int stop,int node,int dist){
            this.stop=stop;
            this.node=node;
            this.dist=dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []flight: flights){
            int u=flight[0];
            int v=flight[1];
            int edw=flight[2];
            adj.get(u).add(new Pair(v,edw));
        }
        int [] dist=new int [n];
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0,src,0));
        dist[src]=0;
        while(!q.isEmpty()){
            tuple it= q.poll();
            int st=it.stop;
            int nd=it.node;
            int di=it.dist;
            if(st>k)continue;
            for(Pair nei: adj.get(nd)){
                int adjNode=nei.node;
                int w=nei.edgewt;
                if(st<=k && di+w<dist[adjNode]){
                    dist[adjNode]=di+w;
                    q.offer(new tuple(st+1,adjNode,dist[adjNode]));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}