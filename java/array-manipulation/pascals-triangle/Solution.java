class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<Integer> currRow = new ArrayList<>();
        List<List<Integer>> triangle = new ArrayList<>();
        
        for(int i = 1; i <= numRows; i++) {
            currRow = new ArrayList<>();
            for(int j = 1; j <= i; j++) {
                if(j==1 || j == i)
                    currRow.add(1);
                else
                    currRow.add(triangle.get(i-2).get(j-2) + triangle.get(i-2).get(j-1));
            }
            triangle.add(currRow);
        }
        
        return triangle;
        
    }
}