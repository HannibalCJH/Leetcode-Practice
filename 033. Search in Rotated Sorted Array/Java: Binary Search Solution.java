public class Solution {
    // 时间复杂度O(logn)，空间复杂度O(1)
    public int search(int[] nums, int target) 
    {
        if(nums == null || nums.length == 0) 
			return -1;  
		
		// 二分法
        int left = 0, right = nums.length - 1;  
        while(left <= right) 
        {  
            int mid = left + (right - left) / 2;  
            // 找到目标
            if(nums[mid] == target)  
                return mid;  
            // 当前半边是正常顺序, 旋转轴心在另一半
            if(nums[left] <= nums[mid]) 
            {  
            	// 目标在这一半中
                if(nums[left] <= target && target < nums[mid])  
                    right = mid - 1;  
                else 
                    left = mid + 1; 
            } 
            // 当前半边是异常顺序, 旋转轴心在这一半
            else 
            {  
                if(nums[mid] < target && target <= nums[right]) 
                    left = mid + 1;  
                else  
                    right = mid - 1;  
            }  
        }  
        return -1; 
    }
}
