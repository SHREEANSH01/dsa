class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] ans= new int[n];
        Stack<Integer> st =new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int prev=st.pop();
                int in=i-prev;
                ans[prev]=in;
            }
            st.push(i);
        }
        return ans;
       

    }
}