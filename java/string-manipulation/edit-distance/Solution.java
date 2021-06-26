class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[][] dpArray = new int[m+1][n+1];

        for(int i = 0; i<=m; i++)
            dpArray[i][0] = i;

        for(int i = 0; i<=n; i++)
            dpArray[0][i] = i;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dpArray[i][j] = dpArray[i-1][j-1];
                else
                    dpArray[i][j] = 1 + Math.min(dpArray[i-1][j-1], Math.min(dpArray[i-1][j], dpArray[i][j-1]));
            }
        }

        return dpArray[m][n];
    }
}