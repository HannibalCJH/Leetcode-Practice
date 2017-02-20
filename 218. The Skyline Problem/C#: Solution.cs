public class Solution {
    // 时间复杂度O(nlogn)，空间复杂度O(n)
    public IList<int[]> GetSkyline(int[,] buildings) 
    {
        List<int[]> result = new List<int[]>();
        List<int[]> heights = new List<int[]>();
        
        for(int i = 0; i < buildings.GetLength(0); i++)
        {
            // 左顶点用负数表示高度
            heights.Add(new int[]{buildings[i, 0], -buildings[i, 2]});
            // 右顶点用正数表示高度
            heights.Add(new int[]{buildings[i, 1], buildings[i, 2]});
        }
        
        heights.Sort(new HeightComparer());
        
        // C#没有PriorityQueue，但是可以用SortedSet来做O(logn)排序且用Dictionary记录高度出现的次数
        // 记录高度出现的次数
        Dictionary<int, int> heightCount = new Dictionary<int, int>();
        // 记录最高的高度
        SortedSet<int> sortedHeight = new SortedSet<int>();
        // 初始化为地平线
        sortedHeight.Add(0);
        int prev = 0;
        foreach(int[] height in heights)
        {
            if(height[1] < 0)
            {
                if(!heightCount.ContainsKey(-height[1]))
                {
                    sortedHeight.Add(-height[1]);
                    heightCount.Add(-height[1], 1);
                }
                else
                {
                    heightCount[-height[1]]++;
                }
            }
            else
            {
                heightCount[height[1]]--;
                if(heightCount[height[1]] == 0)
                {
                    sortedHeight.Remove(height[1]);
                    heightCount.Remove(height[1]);
                }
            }
            int cur = sortedHeight.Max;
            if(cur != prev)
            {
                result.Add(new int[]{height[0], cur});
                prev = cur;
            }
        }
        return result;
    }
    
    class HeightComparer : IComparer<int[]>
    {
        public int Compare(int[] bd1, int[] bd2)
        {
            if(bd1[0] == bd2[0])
                return bd1[1] - bd2[1];
            else
                return bd1[0] - bd2[0];
        }
    }
}
