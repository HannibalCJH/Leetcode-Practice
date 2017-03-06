public class Solution {
    // 时间复杂度O(2^n)，能被n位二进制表示的数有2^n个
    // 空间复杂度O(2^n)
    // 工业中的第i个格雷码是这么生成的：(i >> 1) ^ i
    public List<Integer> grayCode(int n) 
    {
        List<Integer> result = new ArrayList<Integer>();
        // 能被n位二进制表示的数的个数有2^n个
        int size = 1 << n;
        // 比如1011 --> 1110
        // 过程为(1011 >> 1) ^ 1011 --> 1110
        for(int i = 0; i < size; i++) 
            result.add((i >> 1) ^ i);  
        return result;   
    }
}
