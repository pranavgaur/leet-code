class Solution {
    public int minCost(int costs[][], int N) {
        
        int dpArray[][] = new int[N][3];
        dpArray[0][0] = costs[0][0];
        dpArray[0][1] = costs[0][1];
        dpArray[0][2] = costs[0][2];
        
        for(int i=1; i<N; i++){
            dpArray[i][0] = costs[i][0] + Math.min(dpArray[i-1][1], dpArray[i-1][2]);
            dpArray[i][1] = costs[i][1] + Math.min(dpArray[i-1][0], dpArray[i-1][2]);
            dpArray[i][2] = costs[i][2] + Math.min(dpArray[i-1][0], dpArray[i-1][1]);
        }
        
        int minCost = Math.min(dpArray[N-1][0], Math.min(dpArray[N-1][1], dpArray[N-1][2]));
        return minCost;
    
    }
}