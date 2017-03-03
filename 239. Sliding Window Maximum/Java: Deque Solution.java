public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        if(nums == null || nums.length == 0)
            return new int[0];
        
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            // 每当新数进来时，如果发现队列头部的数，是窗口最左边数，则扔掉
            if(i >= k && !deque.isEmpty() && deque.peekFirst() == nums[i - k])
            {
                deque.pollFirst();
            }
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
            {
                deque.pollLast();
            }
            // 加入新的数
            deque.offerLast(nums[i]);
            // 队列头部就是窗口里最大的
            if(i >= k - 1)
            {
                result[index++] = deque.peekFirst();
            }
        }
        return result;
    }
}
