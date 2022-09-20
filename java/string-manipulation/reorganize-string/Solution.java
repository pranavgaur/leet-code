class Solution {
    public String reorganizeString(String s) {
        
//         Count character
        Map<Character, Integer> counts = new HashMap<>();
        for(char c: s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c,0)+1);
        }
        
//         Store chars in order of occurence
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> counts.get(b)-counts.get(a));
        maxHeap.addAll(counts.keySet());
        
//         Build the string by removing the chars from the heap
        StringBuilder sb = new StringBuilder();
        while(maxHeap.size() > 1) {
            
            char c1 = maxHeap.remove();
            char c2 = maxHeap.remove();
            
            sb.append(c1);
            sb.append(c2);
            
            counts.put(c1, counts.get(c1)-1);
            counts.put(c2, counts.get(c2)-1);
            
            if(counts.get(c1) > 0)
                maxHeap.add(c1);
            
            if(counts.get(c2) > 0)
                maxHeap.add(c2);
            
        }
        
        if(maxHeap.size() == 1) {
            char c = maxHeap.remove();
            if(counts.get(c) > 1)
                return "";
            sb.append(c);
        }
        
//         return result
        return sb.toString();
        
    }
}