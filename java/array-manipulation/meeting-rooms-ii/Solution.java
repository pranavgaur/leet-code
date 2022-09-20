/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here

        List<Integer> startTime = new ArrayList<>();
        List<Integer> endTime = new ArrayList<>();

        intervals.forEach(e -> {
            startTime.add(e.start);
            endTime.add(e.end);
        });

        Collections.sort(startTime);
        Collections.sort(endTime);

        int i = 0, j = 0, count = 0, res = Integer.MIN_VALUE;

        while(i < intervals.size() && j < intervals.size()) {

            if(startTime.get(i) < endTime.get(j)){
                count++;
                i++;
            } else if(startTime.get(i) == endTime.get(j)) {
                i++;
                j++;
            } else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }

        return res;

    }
}