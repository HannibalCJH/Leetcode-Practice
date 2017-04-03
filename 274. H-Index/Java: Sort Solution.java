public class Solution {
    // 时间复杂度O(nlogn)，空间复杂度O(1)
    public int hIndex(int[] citations) 
	{
	    // 先将数组排序，我们就可以知道对于某个引用数，有多少文献的引用数大于这个数
		Arrays.sort(citations);
		// 记录最大H指数
		int maxH = 0;
		for(int i = 0; i < citations.length; i++)
		{
			// 对于引用数citations[i]，大于该引用数文献的数量是citations.length - i
			int curH = Math.min(citations[i], citations.length - i);
			if(curH > maxH)
				maxH = curH;
		}
		return maxH;
	}
}
