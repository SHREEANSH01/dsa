class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum =0;
        int left=0;
        int right=cardPoints.length-1;
        int max=0;
        int leftsum=0;
        int rightsum=0;
        for(int i=0;i<k;i++){
            leftsum+=cardPoints[i];
        }
        max=Math.max(leftsum,max);
        for(int i=k-1;i>=0;i--){
            leftsum-=cardPoints[i];
            rightsum+=cardPoints[n-(k-i)];
            max=Math.max(max,rightsum+leftsum);
        }
        return max;
        
    }
}