public class Solution {
    // 基本思想：
    // 1. 排序是数组递增
    // 2. 先定下第一个数nums[i]
    // 3. 用两个指针找另外两个数，一个从i+1开始往后，一个从数组末尾往前
    // 时间复杂度O(nlogn + n^2)，空间复杂度O(1)
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 排序，让相同的数排在一起
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) 
        {
            // 如果第一个数就大于0，则不可能有解，三个正数的和不可能等于0
            if(nums[i] > 0)
                break;
            // 只取相同数的第一个，跳过其余出现的这个数
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            // nums[i]为第一个数，接下来找另外两个数
            // 第二个数从i+1位置开始找
            // 第三个数从数组最后开始找，因为和要等于0，如果从i+2找就可能一串负数
            int j = i + 1, k = nums.length - 1;  
            int target = -nums[i];
            while(j < k) 
            {
                // 找到一个组合
                if(nums[j] + nums[k] == target) 
                {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;  // 跳过相同的数
                    while(j < k && nums[k] == nums[k + 1]) k--;  // 跳过相同的数
                }
                // 如果偏大则第三个数往前找，即找小一点的数
                else if(nums[j] + nums[k] > target)
                {
                    k--;
                }
                // 如果偏小则第二个数往后找，即找大一点的数
                else
                {
                    j++;
                }
            }
        }
        return res;
    }
}
