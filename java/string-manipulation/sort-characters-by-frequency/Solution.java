class Solution {
    public String frequencySort(String s) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> heap = new PriorityQueue<Character>((a,b) -> map.get(b)-map.get(a));
        for(char c : map.keySet()) {
            heap.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!heap.isEmpty()) {
            char c = heap.remove();
            for(int i = 0; i<map.get(c); i++)
                sb.append(c);
        }
        
        return sb.toString();
        
    }
}