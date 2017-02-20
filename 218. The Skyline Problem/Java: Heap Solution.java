public class Solution {
  // 时间复杂度O(nlogn)，空间复杂度O(n)
	public List<int[]> getSkyline(int[][] buildings) 
	{
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        // 拆解矩形，构建顶点的列表
        for(int[] building : buildings) 
        {
            // 左顶点存为负数
            height.add(new int[]{building[0], -building[2]});
            // 右顶点存为正数
            height.add(new int[]{building[1], building[2]});
        }
        // 根据横坐标对列表排序，相同横坐标的点纵坐标小的排在前面
        Collections.sort(height, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                if(a[0] != b[0])
                    return a[0] - b[0];
                else
                    return a[1] - b[1];
            }
        });
        // 构建堆，按照纵坐标来判断大小，从大到小排序
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new Comparator<Integer>()
        {
            public int compare(Integer i1, Integer i2)
            {
                return i2 - i1;
            }
        });
        // 将地平线值先加入堆中
        pq.offer(0);
        // prev用于记录上次key point的高度
        int prev = 0;
        for(int[] h : height) 
        {
            // 将左顶点加入堆中
            if(h[1] < 0)
                pq.offer(-h[1]);
            else
            	// 将右顶点对应的左顶点移去
                pq.remove(h[1]);
            int cur = pq.peek();
            // 如果堆的新顶部和上个key point高度不一样，则加入一个新的key point
            if(prev != cur) 
            {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}
