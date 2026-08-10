class Solution {
    class Pair{
        int dist;
        int row;
        int col;
        Pair(int dist,int row,int col){
            this.dist=dist;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n= heights.length;
        int m =heights[0].length;
        int [] drow={-1,0,+1,0};
        int [] dcol={0,+1,0,-1};
        int [][] dist= new int [n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)-> x.dist-y.dist);
        dist[0][0]=0;
        pq.offer(new Pair(0,0,0));
        
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int d=curr.dist;
            int r=curr.row;
            int c=curr.col;
            if(r==n-1 && c==m-1) return d;
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int effort=Math.max(Math.abs(heights[r][c]-heights[nrow][ncol]),d);
                    if(effort<dist[nrow][ncol]){
                        dist[nrow][ncol]=effort;
                        pq.offer(new Pair(effort,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}