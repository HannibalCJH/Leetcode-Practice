public class Solution {
    // 时间复杂度O(log(m+n))，空间复杂度O(1)
	public boolean searchMatrix(int[][] matrix, int target) 
	{
        if(matrix.length == 0 || matrix[0].length == 0)
        	return false;
        
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        // 双向二分法
        // 先二分行，找到可能包含目标的行
        while(top <= bottom)
        {
        	int midRow = (top + bottom) / 2;
        	if(matrix[midRow][0] > target)
        		bottom = midRow - 1;
        	else if(matrix[midRow][n - 1] < target)
        		top = midRow + 1;
        	else
        	{
        		// 再二分列，就是对这行做一般的二分法
        		while(left <= right)
        		{
        			int midCol = (left + right) / 2;
        			if(matrix[midRow][midCol] == target)
        				return true;
        			else if(matrix[midRow][midCol] < target)
        				left = midCol + 1;
        			else
        				right = midCol - 1;
        		}
        		return false;
        	}
        }
        return false;
    }
}
