public class Solution {
    // 埃拉托斯特尼筛法:
    // 如果一个数是另一个数的倍数，那这个数肯定不是质数。利用这个性质，我们可以建立一个质数数组，
    // 从2开始将质数的倍数都标注为不是质数。第一轮将4、6、8等表为非质数，然后遍历到3，发现3没有被标记为非质数，
    // 则将6、9、12等标记为非质数，一直到N为止，再数一遍质数数组中有多少质数。
    // 时间复杂度O(nlog(logn))，空间复杂度O(n)
    public int countPrimes(int n) 
    {
        // 建立质数数组
        boolean[] isPrime = new boolean[n];
        // 初始化为都是质数
	for(int i = 2; i < n; i++)
	    isPrime[i] = true;
	// 循环条件用i*i<n，sqrt(n)太费时
	// 排除合数就留下了质数
	for(int i = 2; i * i < n; i++) 
	{
	    // 已经排除则跳过
	    if(isPrime[i]);
	    {
    		// 讨论i的倍数所以每次都是j+=i
    		// 从i*i开始，前面的i*2，i*3等到都已经被讨论2和3的时候排除了
    		for(int j = i * i; j < n; j += i)
    		    isPrime[j] = false;
	    }
	}
	int count = 0;
	// 再进行一遍遍历统计个数
	for(int i = 2; i < n; i++)
	    if(isPrime[i]) 
		count++;
	return count;
    }
}
