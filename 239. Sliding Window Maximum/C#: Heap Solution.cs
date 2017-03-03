public class Solution {
    public int[] MaxSlidingWindow(int[] nums, int k) 
    {
        if(nums == null || nums.Length == 0)
            return new int[0];
        
        int[] result = new int[nums.Length - k + 1];
        int index = 0;
        SortedDictionary<int, int> heap = new SortedDictionary<int, int>();
        for(int i = 0; i < nums.Length; i++)
        {
            if(i >= k)
            {
                if(heap[nums[i - k]] > 1)
                    heap[nums[i - k]]--;
                else
                    heap.Remove(nums[i - k]);
            }
            
            if(heap.ContainsKey(nums[i]))
            {
                heap[nums[i]]++;
            }
            else
            {
                heap.Add(nums[i], 1);
            }
            
            if(i >= k - 1)
            {
                result[index++] = heap.Last().Key;
            }
        }
        return result;
    }
}
