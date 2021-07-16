class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int i=0, j=0;
        List<Integer> res = new ArrayList<Integer>();
        
        int[] arr = new int[26];
        for(int c = 0; c < 26; c++){
            char t = (char)('a' + c);
            arr[c] = s.lastIndexOf(t);
        }
        
        while(i<s.length()){
            j=i;
            for(int k = i; k<=j; k++){
                j = Math.max(j, arr[s.charAt(k) - 'a']);
            }
            res.add(j-i+1);
            i=j+1;
        }
        
        return res;
        
    }
}