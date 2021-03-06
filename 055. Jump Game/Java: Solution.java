public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public boolean canJump(int[] nums) 
    {
        if(nums.length < 2)
            return true;
        // 记录从0到i的位置之间的点能跳的最远的距离
        int maxReach = 0;
        for(int i = 0; i < nums.length; i++)
            // 当前的位置还没有到达全局最远的距离，查看从这个点能否跳到比maxReach更远的点
            // 注意数组中的数不是代表这个位置一定要跳的步数，而是可以跳的最远的步数，你可以跳0到nums[i]之间任意的步数
            if(i <= maxReach)
                maxReach = Math.max(maxReach, i + nums[i]);
        // 全局最远的点是不是能到达最后一个位置
        return maxReach >= nums.length - 1;
    }
}
