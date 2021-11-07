class Solution {
    
    Map<String, Boolean> cache = new HashMap<String, Boolean>();
    
    public boolean isMatch(String s, String p) {
        
        return dfs(0, 0, s, p);
        
    }
    
    public boolean dfs(int i, int j, String s, String p) {
        if(cache.containsKey(i+""+j))
            return cache.get(i+""+j);
        
        if(i >= s.length() && j >= p.length())
            return true;
        
        if(j >= p.length())
            return false;
        
        boolean matchCase = i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if(j+1 < p.length() && p.charAt(j+1) == '*') {
            if(dfs(i, j+2, s, p) || (matchCase && dfs(i+1, j, s, p))){
            	cache.put(i+""+j, true);
            	return cache.get(i+""+j);
        	}
        } else if(matchCase) {
            cache.put(i+""+j, dfs(i+1, j+1, s, p));
            return cache.get(i+""+j);
        }
         
        cache.put(i+""+j, false);
        return false;
        
    }
}