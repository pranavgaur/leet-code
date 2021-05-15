class LRUCache {

    private int capacity = 0; 
    private Set<Integer> set = new LinkedHashSet();
    private Map<Integer, Integer> map = new HashMap();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            set.remove(key);
            set.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(set.size() == capacity) {
                int last = (int)this.set.toArray()[0];
                set.remove(last);
                map.remove(last);
            }
        }
        
        set.remove(key);
        set.add(key);
        map.put(key, value);
            
    }
}