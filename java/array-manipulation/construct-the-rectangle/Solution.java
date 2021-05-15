import java.lang.*;

class Solution {
    public int[] constructRectangle(int area) {
        
        if(area == 1)
            return new int[] {1,1};
        else if(area == 0)
            return new int[] {0,0};
        
        int half = (int)Math.sqrt(area);
        int i = 1;
        
        int diff = Integer.MAX_VALUE;
        
        int[] res = {0,0};
        
        while(i <= half) {
            if(area%i==0 ){
                if(diff > Math.abs(i - area/i)){
                    diff = Math.abs(i - area/i);
                    if(i>area/i){
                        res[0] = i;
                        res[1] = area/i;
                    } else{
                        res[1] = i;
                        res[0] = area/i;
                    }
                }
            }
            i++;
        }
        
        return res;
    }
}