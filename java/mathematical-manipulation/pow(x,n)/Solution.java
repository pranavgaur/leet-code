class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        ans = driverFunc(x, n);
        return ans;
    }
    
    public double driverFunc(double x, int n){
        if(n>0){
            if(n%2 == 0)
                return driverFunc(x*x, n/2);
            return x*driverFunc(x, n-1); 
        } else if(n<0){
            if(n%2 == 0)
               return driverFunc((x*x), n/2);
            return (1/x)*driverFunc(x, n+1); 
        } else
            return 1;
    }
}