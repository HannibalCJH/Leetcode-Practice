public class Solution {
    public int FindKthLargest(int[] nums, int k) 
    {
        SortedDictionary<int, int> pq = new SortedDictionary<int, int>();
        int size = 0;
        for(int i = 0; i < nums.Length; i++)
        {
            if(pq.ContainsKey(nums[i]))
            {
                pq[nums[i]]++;
            }
            else
            {
                pq.Add(nums[i], 1);
            }
            size++;
            if(size > k)
            {
                int key = pq.First().Key;
                if(pq[key] == 1)
                    pq.Remove(key);
                else
                    pq[key]--;
            }
        }
        return pq.First().Key;
    }
}
