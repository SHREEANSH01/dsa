class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n=num.length();
        char [] s= num.toCharArray();
        for(char ch : s){
            while(!st.isEmpty() && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);

        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        int i=0;
        while(i<sb.length()-1 && sb.charAt(i)=='0'){
            i++;
        }
        String ans = sb.substring(i);
        return ans.isEmpty() ? "0" : ans;
    }
}