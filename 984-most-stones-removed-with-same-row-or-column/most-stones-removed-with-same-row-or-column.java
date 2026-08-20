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
    public int removeStones(int[][] stones) {
        int maxRow=0;
        int maxCol=0;
        int n=stones.length;
        for(int [] stone:stones){
            maxRow=Math.max(stone[0],maxRow);
            maxCol=Math.max(stone[1],maxCol);
        }
        DisJointSet ds = new DisJointSet(maxRow+maxCol+1);
        HashMap<Integer,Integer> edges=new HashMap<>();
        for(int [] stone:stones){
            int nr=stone[0];
            int nc= stone[1]+maxRow+1;
            ds.unionbysize(nr,nc);
            edges.put(nr,1);
            edges.put(nc,1);
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> entry: edges.entrySet()){
            if(ds.findUparent(entry.getKey())==entry.getKey()){
                cnt++;
            }
        }
        return n-cnt;
    }
}