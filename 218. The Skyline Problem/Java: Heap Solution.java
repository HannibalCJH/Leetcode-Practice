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
        // 根据横坐标对列表排序，
        // 相同横坐标的点纵坐标小的排在前面，我们希望先加入的是左顶点再是右顶点，
        // 不让会出现问题比如输入的是[0, 2, 3]和[2, 5, 3]，我们会把第一个建筑完全排除后再考虑第二个建筑
        // 那这样虽然两个建筑的高都是3但是因为我们只单独考虑第二个建筑而没有考虑它和上一个建筑的高度关系
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
        // prev用于记录上次key point的高度，初始化为地平线
        int prev = 0;
        for(int[] h : height) 
        {
            // 将左顶点加入堆中
            if(h[1] < 0)
                pq.offer(-h[1]);
            else
            	// 将右顶点对应的左顶点移去
                pq.remove(h[1]);
            // 堆顶是最高的点，只要这个点没被移出堆，说明这个最高的矩形还没结束
            int cur = pq.peek();
            // key point的高度变化，则加入一个新的key point
            // 这样就避免了题目中Notes里的第四点：连续加入高度一样的线段
            // 注意cur每次都是最高的那个key point
            if(prev != cur) 
            {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}
