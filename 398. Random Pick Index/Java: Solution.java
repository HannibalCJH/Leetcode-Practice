public class Solution {
    int[] nums;
    Random rnd;

    public Solution(int[] nums) 
    {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    // 时间复杂度O(n)，空间复杂度O(1)
    public int pick(int target) 
    {
        // 如果不存在则返回下标为-1
        int result = -1;
        // 计数器，记录数组中有几个等于target值
        int count = 0;
        for(int i = 0; i < nums.length; i++) 
        {
            // 等于target值
            if(nums[i] == target)
            {
                // 从0到count取随机数，等于0的概率为1/count，所以取到nums[i]的概率也就是1/count
                // 取到了0就把当前nums[i]的下标赋值个result
                // 注意Random.nextInt函数的参数是上限但是开区间[0,count)
                if(rnd.nextInt(++count) == 0)
                    result = i;
            }
        }
        
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
