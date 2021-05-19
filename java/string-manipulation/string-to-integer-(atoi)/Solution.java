import java.math.BigInteger;

class Solution {
    public int myAtoi(String s) {
        
        boolean positive = true;
        StringBuilder sb = new StringBuilder();
        
        if(s.trim().length() == 0)
            return 0;
        
        // remove leading spaces
        s = s.trim();
        
        // determine final result is - or +
        if(s.charAt(0)=='-')
            positive = false;
        
        // remove the inital + or - sign
        s = (s.charAt(0) == '-' || s.charAt(0) == '+') ? s.substring(1) : s;
         
        
        // iterate through the string until next non digit comes up
        int i = 0;
        
        while(i < s.length()){
            if(!Character.isDigit(s.charAt(i)))
                break;
            sb.append(s.charAt(i));
            i++;
        }
        
        if(sb.length() == 0)
            return 0;
        
        BigInteger maxVal = new BigInteger(Integer.MAX_VALUE+"");
        BigInteger minVal = new BigInteger(Integer.MIN_VALUE+"");
        BigInteger resp = positive ? new BigInteger(sb.toString()) : new BigInteger("-"+sb.toString());
  
        if(resp.compareTo(maxVal) == 1 || resp.compareTo(maxVal) == 0)
            return Integer.MAX_VALUE;
        else if (resp.compareTo(minVal) == -1 || resp.compareTo(minVal) == 0)
            return Integer.MIN_VALUE;  
             
        return Integer.valueOf(resp+"");
    
    }
}