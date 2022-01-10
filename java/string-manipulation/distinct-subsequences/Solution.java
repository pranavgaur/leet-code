class Solution {
    
    Map<String, Integer> cache = new HashMap<>();
    public int numDistinct(String s, String t) {
        return dfs(0,0,s,t);
    }
    
    
    int dfs(int i, int j, String s, String t) {
        if(cache.containsKey(i+"+"+j))
            return cache.get(i+"+"+j);
        
        if(j == t.length())
            return 1;
        
        if(i == s.length())
            return 0;
        
        if(s.charAt(i) == t.charAt(j)){
            cache.put(i+"+"+j, (dfs(i+1,j+1,s,t) + dfs(i+1, j,s,t)));
        } else {
            cache.put(i+"+"+j, dfs(i+1, j,s,t));
        }
        
        return cache.get(i+"+"+j);
    }
}