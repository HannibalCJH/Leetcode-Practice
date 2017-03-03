public class Solution {
    // 时间复杂度O(nlogn)，空间复杂度O(n)
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        if(nums == null || nums.length == 0)
            return new int[0];
        
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++)
        {
            // 移除窗口最左边的数字
            if(i >= k)
                pq.remove(nums[i - k]);
            // 加入右边新的数字
            pq.offer(nums[i]);
            // 堆顶就是最大的窗口值
            if(i >= k - 1)
                result[index++] = pq.peek();
        }
        return result;
    }
}
