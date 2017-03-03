public class Solution {
    public int[] MaxSlidingWindow(int[] nums, int k) 
    {
        if(nums == null || nums.Length == 0)
            return new int[0];
        
        int[] result = new int[nums.Length - k + 1];
        int index = 0;
        // Java和C#的LinkedList类是都是双向的
        LinkedList<int> deque = new LinkedList<int>();
        for(int i = 0; i < nums.Length; i++)
        {
            if(i >= k && deque.First.Value == nums[i - k])
            {
                deque.RemoveFirst();
            }
            
            while(deque.Count > 0 && deque.Last.Value < nums[i])
            {
                deque.RemoveLast();
            }
            deque.AddLast(nums[i]);
            if(i >= k - 1)
            {
                result[index++] = deque.First.Value;
            }
        }
        return result;
    }
}
