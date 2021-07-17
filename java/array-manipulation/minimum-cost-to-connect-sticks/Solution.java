public class Solution {

    public int MinimumCost(List<Integer> sticks) {
        
       int compoundSum = 0;
       
       PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

       for(int i = 0; i<sticks.size(); i++){
           queue.add(sticks.get(i));
       }

       while(queue.size() != 1){
           int p1 = queue.remove();
           int p2 = queue.remove();
           int sum = p1 + p2;
           compoundSum = compoundSum + sum;
           queue.add(sum);
       }

       return compoundSum;

    }
}