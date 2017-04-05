public class Solution {
    // 时间复杂度O(logn)，空间复杂度O(1)
    public int hIndex(int[] citations) 
    {
	int n = citations.length;
	int left = 0, right = n - 1;
	while(left <= right)
	{
	    int mid = left + (right - left) / 2;
	    // 有n-mid篇论文引用次数大于citations[mid]，说明citations[mid]还可以更大一点，
	    // 我们要找的是最好citations[mid] == n - mid的情况
	    if(citations[mid] < n - mid)
		left = mid + 1;
	    else
	    // citations[mid]太大，没有足够的论文数大于这个引用次数
		right = mid - 1;
	}
	// n - left是left点的H指数
	// 当跳出循环是left指针在right的右边
	return n - left;
    }
}
