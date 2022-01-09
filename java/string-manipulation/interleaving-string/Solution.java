class Solution {
    
    Map<String, Boolean> cache = new HashMap<>();
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1.length() + s2.length() != s3.length())
            return false;
        
        return dfs(s1,s2,s3,0,0,0);
        
    }
    
    
    boolean dfs (String s1, String s2, String s3, int p1, int p2, int p3) {

        if(p3 == s3.length()){
            if(p1 == s1.length() && p2 == s2.length())
                return true;
            else
                return false;
        }
        
        String key = p1+"+"+p2+"+"+p3;
        
        if(cache.containsKey(key))
            return cache.get(key);
        
        if(p1 == s1.length()){
            if(s2.charAt(p2) == s3.charAt(p3))
                cache.put(key, dfs(s1,s2,s3,p1,p2+1,p3+1));
            else
                cache.put(key, false);
            return cache.get(key); 
        }
        
        if(p2 == s2.length()){
            if(s1.charAt(p1) == s3.charAt(p3))
                cache.put(key, dfs(s1,s2,s3,p1+1,p2,p3+1));
            else
                cache.put(key, false);
            return cache.get(key); 
        }
        
        Boolean b1 = false;
        Boolean b2 = false;
        
        if(s3.charAt(p3) == s1.charAt(p1)){
             b1 = dfs(s1,s2,s3,p1+1,p2,p3+1);
        }
        
        if(s3.charAt(p3) == s2.charAt(p2)){
             b2 = dfs(s1,s2,s3,p1,p2+1,p3+1);
        }
        
        cache.put(key, (b1||b2));
        
        return (b1 || b2);
        
        
        
        
        
    }
}