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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisJointSet ds= new DisJointSet(n);
        HashMap<String,Integer> mail=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String m=accounts.get(i).get(j);
                if(!mail.containsKey(m)){
                    mail.put(m,i);
                }else{
                    ds.unionbysize(i,mail.get(m));
                }
            }
        }
        ArrayList<String>[] mergedMail=new ArrayList[n];
        for(int i=0;i<n;i++){
            mergedMail[i]=new ArrayList<String>();
        }
        for(Map.Entry<String,Integer> entry:mail.entrySet()){
            String ml=entry.getKey();
            int node = ds.findUparent(entry.getValue());
            mergedMail[node].add(ml);
        }
        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(mergedMail[i].size()==0)continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it: mergedMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}