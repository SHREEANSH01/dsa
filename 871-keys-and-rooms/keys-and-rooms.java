class Solution {
    public void dfs(List<List<Integer>> rooms,boolean [] vis,int room){
        vis[room]=true;
        for(int nei: rooms.get(room)){
            if(!vis[nei]){
                dfs(rooms,vis,nei);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] vis = new boolean[rooms.size()];
        dfs(rooms,vis,0);
        for(int i=0;i<rooms.size();i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
}