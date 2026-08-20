class Solution {
    class DisJointSet{
        ArrayList<Integer> parent= new ArrayList<>();
        ArrayList<Integer> size= new ArrayList<>();
        DisJointSet(int n){
            for(int i=0;i<=n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int findUparent(int node){
            if(node==parent.get(node)){
                return node;
            }
            int ulp=findUparent(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
        public void unionbysize(int u,int v){
            int ulp_u=findUparent(u);
            int ulp_v=findUparent(v);
            if(ulp_u==ulp_v)return;
            if(size.get(ulp_u)<size.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
            }
            else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            }
        }
    }
    public boolean isValid(int adjr,int adjc,int n){
        return adjr>=0 && adjr<n && adjc>=0 && adjc<n;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisJointSet ds = new DisJointSet(n*n);
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0)continue;
                int [] drow={-1,0,+1,0};
                int [] dcol={0,+1,0,-1};
                for(int i=0;i<4;i++){
                    int adjr=row+drow[i];
                    int adjc=col+dcol[i];
                    if(isValid(adjr,adjc,n) && grid[adjr][adjc]==1){
                        ds.unionbysize(row*n+col,adjr*n+adjc);
                    }
                }
            }
        }
        int mx=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                HashSet<Integer> comp=new HashSet<>();
                int [] drow={-1,0,+1,0};
                int [] dcol={0,+1,0,-1};
                if(grid[row][col]==1)continue;
                for(int i=0;i<4;i++){
                    int adjr=row+drow[i];
                    int adjc=col+dcol[i];
                    if(isValid(adjr,adjc,n)){
                        if(grid[adjr][adjc]==1){
                            comp.add(ds.findUparent(adjr*n+adjc));
                        }
                    }

                }
                int sizeTotal=0;
                for(int it: comp){
                    sizeTotal+=ds.size.get(it);
                }
                mx=Math.max(mx,sizeTotal+1);

            }
        }
        for(int i=0;i<n*n;i++){
            mx=Math.max(mx,ds.size.get(ds.findUparent(i)));
        }
        return mx;
    }
}