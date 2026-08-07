class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        Pair start=new Pair(startPos[0],startPos[1]);
        Pair home=new Pair(homePos[0],homePos[1]);
        int cost=0;
        // rows to walk
        int rowDiff=home.row-start.row;
        // col to walk
        int colDiff=home.col-start.col;
        if(rowDiff>0){
        for(int i=start.row+1;i<=home.row;i++){
            cost+=rowCosts[i];
        }
        }
        if(rowDiff<0){
            for(int i=start.row-1;i>=home.row;i--){
            cost+=rowCosts[i];
        }
        }
        if(colDiff>0){
        for(int j=start.col+1;j<=home.col;j++){
            cost+=colCosts[j];
        }
        }
        if(colDiff<0){
            for(int j=start.col-1;j>=home.col;j--){
            cost+=colCosts[j];
        }
        }
        return cost;
    }
}