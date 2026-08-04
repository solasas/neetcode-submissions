/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n=intervals.size();
        if(n==0) return 0;
        Collections.sort(intervals,Comparator.comparingInt(a->a.start));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(Interval i : intervals){
            if(!pq.isEmpty() && pq.peek()<=i.start){
                pq.poll();
            }
            pq.offer(i.end);
        }
        return pq.size();
    }
}
