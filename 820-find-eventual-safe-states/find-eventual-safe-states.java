class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int it: graph[i]){
                adj.get(i).add(it);
            }
        }
        List<List<Integer>> revAdj=new ArrayList<>();
        for(int i=0;i<V;i++){
            revAdj.add(new ArrayList<>());
        }
        int [] indegree= new int[V];
        for(int i=0;i<V;i++){
            for(int it: adj.get(i)){
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> ans= new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int nei: revAdj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.offer(nei);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}