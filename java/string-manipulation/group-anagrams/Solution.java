class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String s : strs) {
            if(map.containsKey(sortedString(s))){
                List<String> list = map.get(sortedString(s));
                list.add(s);
                map.put(sortedString(s), list);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(sortedString(s), list);
            }
        }
        return new ArrayList(map.values());
    }
    
    public String sortedString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}