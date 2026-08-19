class Solution {
    class DisJointSet{
        ArrayList<Integer> parent= new ArrayList<>();
        ArrayList<Integer> size= new ArrayList<>();
        DisJointSet(int n ){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(0);
            }
        }
        public int findUparent(int node){
            if(node==parent.get(node)) return node;
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
            }else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisJointSet ds= new DisJointSet(n);
        int cntextra=0;
        for(int [] it:connections ){
            int u=it[0];
            int v=it[1];
            if(ds.findUparent(u)== ds.findUparent(v)){
                cntextra++;
            }else{
                ds.unionbysize(u,v);
            }
        }
        int cntC=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i)cntC++;
        }
        int ans=cntC-1;
        if(cntextra>=ans) return ans;
        return -1;
    }
}