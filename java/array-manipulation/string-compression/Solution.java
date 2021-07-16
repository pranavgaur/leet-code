class Solution {
    public int compress(char[] chars) {
        
        int i = 0;
        int index = 0;

        while(i < chars.length){
            int j = i;
            while(j < chars.length && chars[j] == chars[i]){
                j++;
            }

            chars[index++] = chars[i];

            if(j-i>1){
                for(char c: ((j-i)+"").toCharArray())
                    chars[index++] = c;
            }

            i=j;
        }  

        return index;
    }
}