class Solution {
    
    List<List<Integer>> resList = new ArrayList<List<Integer>>();
        
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursiveCaller(candidates, 0, target, new ArrayList<Integer>());
        return resList;
    }
    
    void recursiveCaller(int[] candidates, int i, int target, List<Integer> currList) {
        if (target == 0)
            resList.add(new ArrayList<>(currList));
        else{
            if(i >= candidates.length || target < 0)
                return;
            else {
                for(int j = i; j < candidates.length; j++){
                    if(j == i || candidates[j] != candidates[j-1]){
                        currList.add(candidates[j]);
                        recursiveCaller(candidates, j+1, target-candidates[j], currList);
                        currList.remove(currList.size() - 1);
                    }
                }
            }
        }
    }
}