public class Solution {
    // 时间复杂度O(nlogk)，n为数组长度，因为每次加入一个数到堆中都要排序O(logk)
    // 空间复杂度O(k)
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // 维持堆的大小为k，当遍历完所有的元素以后，堆中就是数组中最大的k个元素
        // 第k大的数就是这k个数中最小的也就是堆顶的元素
        for(int i = 0; i < nums.length; i++)
        {
            pq.offer(nums[i]);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }
}
