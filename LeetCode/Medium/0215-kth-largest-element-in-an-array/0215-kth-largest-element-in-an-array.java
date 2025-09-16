/** solve without sorting */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int num : nums){
            pq.add(num);
        }

        int result = 0;
        for(int i = 0; i < k; i++){
            result = pq.poll();
        }
        
        return result;
    }
}