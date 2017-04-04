public class Solution {
    // Bucket Sort
    // 时间复杂度O(n)，空间复杂度O(n)
    public int hIndex(int[] citations) 
	{
	    int length = citations.length;
	    // count[i]表示有多少文章被引用了i次
        int[] count = new int[length + 1];
        
        for(int num : citations)
        {
            // 文章引用次数大于数组长度，就认为它被引用了length次
            if(num > length) 
                count[length]++;
            else
                // 对应次数加1
                count[num]++;
        }
        
        int total = 0;
        // 这里的i可以有两个理解
        // 1. 表示出现的次数，即count数组本身所代表的的意思
        // 2. citations数组里剩下的论文数，一开始是满的即length，代表所有论文
        for(int i = length; i >= 0; i--) 
        {
            // 统计所有被高频引用的论文
            total += count[i];
            // 当统计出来的论文数量第一次大于citations里剩余的论文数时，我们就找到了最大的H
            // 还需要理解的是，我们统计的论文数的出现频率都是大于i的
            if(total >= i)
                return i;
        }
        return 0;
	}
}
