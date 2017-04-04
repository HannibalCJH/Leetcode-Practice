    // 动态规划
    // 时间复杂度O(mn)，空间复杂度O(n)
    public int maximalRectangle(char[][] matrix) 
    {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int m = matrix.length, n = matrix[0].length;
        // 每一格能组成矩形的左右边界和高
        int[] left = new int[n], right = new int[n], height = new int[n];
        // 我们扫描时，左边界从0开始，右边界从每一行的末尾开始，所以首先初始化right为n
        // 注意不是初始化为最右边的坐标即n-1，这样计算一个点时，它的左右边界差值最起码为1，所以最小的面积就是这个点本身
        Arrays.fill(right, n);
        int result = 0;
        // 逐行扫描
        // 每扫描完一行，我们就能够得出从0到i行为止，最大的矩形面积
        for(int i = 0; i < m; i++)
        {
            int cur_left = 0, cur_right = n;
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == '1')
                {
                    // 高度是累加的，对于第j列，从第一行开始，只要每一行的j列为1，那矩形的高度就可以加1
                    height[j]++;
                    // [i, j]的左边界两种情况取较大值：
                    // 1. 这一行连续一串1的最左边的点
                    // 2. 前面0到i-1行为止最右边的点
                    left[j] = Math.max(left[j], cur_left);
                }
                else
                {
                    // 碰到了0，那就把高度重置为0
                    height[j] = 0;
                    // 重置左边界为0
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for(int j = n - 1; j >= 0; j--)
            {
                if(matrix[i][j] == '1')
                {
                    // [i, j]的右边界两种情况取较小值：
                    // 1. 这一行连续一串1的最右边的点
                    // 2. 前面0到i-1行为止最左边的点
                    right[j] = Math.min(right[j], cur_right);
                }
                else
                {
                    // 重置右边界为n
                    right[j] = n;
                    cur_right = j;
                }
            }
            // 计算矩形面积
            for(int j = 0; j < n; j++)
            {
                // 当一个点为0时，虽然左边界为0，右边界为n，看上去好像是整行都是1，但是高度为0，所以最后面积也为0
                result = Math.max(result, (right[j] - left[j]) * height[j]);
            }
        }
        return result;
    }
}
