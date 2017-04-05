public class Solution {
    // 时间复杂度O(nklogk)，n为数组长度即valid函数的时间，k为数组所有元素和与最大数的差值即二分搜索的区间长度
    // 空间复杂度O(1)
    public int splitArray(int[] nums, int m) 
    {
        // 子数组的和是大于等于数组中的最大值且小于等于所有数的和
        int sum = 0;
        long max = 0;
        for(int num : nums)
        {
            sum += num;
            max = Math.max(num, max);
        }
        // 只要一个子数组那就是原来的数组
        if(m == 1)
            return sum;
        // 把最大数作为左边界，所有数的和作为右边界进行二分搜索
        long left = max, right = sum;
        while(left <= right)
        {
            // 计算中间的数mid作为m个子数组的最大和进行尝试
            long mid = (left + right) / 2;
            // 符合要求，即用mid作为最大和尝试所得的子数组小于等于m，子数组个数有可能不够m，所以我们要减小mid可以让数组切成更多的数组
            if(valid(nums, mid, m))
                right = mid - 1;
                
            else
                // 不符合要求，用mid尝试得到的数组个数大于m，为了减少子数组我们应该让mid更大，这样一个子数组需要更多的数才能达到mid
                left = mid + 1;
        }
        return (int)left;
    }
    
    private boolean valid(int[] nums, long sum, int m)
    {
        // 计算子数组的和
        long total = 0;
        // 统计子数组的个数
        int count = 1;
        for(int num : nums)
        {
            // 加上当前的数
            total += num;
            // 当前子数组的和大于目标和，那我们就找到了一个目标子数组
            if(total > sum)
            {
                // 子数组个数加1
                count++;
                // 当前的数导致了子数组超过目标和，所以这个数应该属于下一个子数组，重置total为当前的数开始一个新的子数组
                total = num;
                // 子数组的个数大于m，不符合要求
                if(count > m)
                    return false;
            }
        }
        // 子数组个数小于等于m，符合要求
        return true;
    }
}
