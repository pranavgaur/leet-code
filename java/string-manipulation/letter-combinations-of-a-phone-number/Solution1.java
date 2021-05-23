class Solution1 {
    public List<String> letterCombinations(String digits) {
        
        String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        char[] chars = digits.toCharArray();       
        List<String> result = new ArrayList();
        
        for(char c: chars){
            char[] c1 = arr[Character.getNumericValue(c)].toCharArray();
            if(result.size()==0){
                for(char c2: c1)
                    result.add(c2+"");
            } else{
                List<String> l1 = new ArrayList();
                 for(char c2: c1){
                     result.stream().forEach(res -> l1.add(res+c2));
                 }
                result = l1;
            }
        }
        return result;
    }
}