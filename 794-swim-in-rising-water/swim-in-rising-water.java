class Solution {
    class Pair{
        int time;
        int row;
        int col;
        Pair(int time,int row,int col){
            this.time=time;
            this.row=row;
            this.col=col;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int [] [] dist = new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=grid[0][0];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.time-y.time);

        pq.offer(new Pair(grid[0][0],0,0));
        int [] drow={-1,0,+1,0};
        int [] dcol={0,+1,0,-1};
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int time= curr.time;
            int r=curr.row;
            int c=curr.col;
            if(time> dist[r][c]){
                continue;
            }
            if(r==n-1 && c==n-1) return time;

            for(int i=0;i<4;i++){
                int nrow= r+drow[i];
                int ncol= c+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n ){
                    int newTime= Math.max(time,grid[nrow][ncol]);

                    if(newTime<dist[nrow][ncol]){
                        dist[nrow][ncol]=newTime;
                        pq.offer(new Pair(newTime,nrow,ncol));
                    }
                }
            }
        }
        return -1;
    }
}