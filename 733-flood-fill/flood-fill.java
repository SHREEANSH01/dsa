class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n = image[0].length;
        int [] [] vis = new int [m][n];
        int [][] ans = image;
        int oldcolor= image[sr][sc];

        if(oldcolor==color){
            return ans;
        }
        bfs(image,ans,sr,sc,oldcolor,color,vis);
        return ans ;

    }
    public void bfs(int [][] image,int [][] ans,int sr,int sc,int oldcolor,int color,int [][] vis){
        int m = image.length;
        int n = image[0].length;
        vis[sr][sc]=1;
        Queue<Pair> q = new LinkedList<>();
        ans[sr][sc]=color;
        q.offer(new Pair(sr,sc));
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && image[nrow][ncol]==oldcolor){
                    vis[nrow][ncol]=1;
                    ans[ nrow][ncol]=color;
                    q.offer(new Pair(nrow,ncol));
                }
            }

        }
    }
}