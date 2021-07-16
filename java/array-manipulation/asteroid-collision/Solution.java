class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        
        while(i < n && asteroids[i] < 0){
            stack.push(asteroids[i]);
            i++;
        }
        
        while(i<n){
            if(asteroids[i]<0){
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() + asteroids[i] < 0)
                    stack.pop();
                
                if(!stack.isEmpty() && stack.peek() > 0 && stack.peek() + asteroids[i] == 0) {
                    stack.pop();
                    asteroids[i]=0;
                }
                
                if(!stack.isEmpty() && stack.peek() + asteroids[i] > 0)
                    asteroids[i]=0;
                
                if(asteroids[i]<0)
                    stack.push(asteroids[i]);
                
            } else
                stack.push(asteroids[i]);
            
            i++;
        }
        
        int[] res = new int[stack.size()];
        int j = stack.size() - 1;
        
        while(!stack.isEmpty()){
            res[j--] = stack.pop();
        }
        
        return res;
        
    }
}