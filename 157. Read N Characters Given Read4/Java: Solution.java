/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    // 这道题的题意比较难理解，
    // 1. 所给的API即read4(char[] buf)返回的是这次从文件读取的字符个数，读取4个，但是如果文件中剩余的字符不足4个，那就返回剩余的字符个数
    // 2. read4()的参数buf数组不是传入的文件，相反的它是返回的对应个数的字符数组，比如read4()返回4即读取了4个字符，那么buf就是这被读取的
    //    4个字符。也就是说buf数组用作输出而不是输入
    // 3. 要实现的函数read(char[] buf, int n)中的buf数组也是用作输出的数组，即我们从给定的文件中读取n个字符，并且把这些字符放进buf数组
    // 时间复杂度O(n)，空间复杂度O(1)
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) 
    {
        // read4()的参数，用作返回读取的字符数组
        char[] buffer = new char[4];
        int index = 0;
        
        // 最多读取n个字符
        while(index < n) 
        {
            // 记录读取的字符个数，并且把这些对应的字符传入buffer
            int curr = read4(buffer);
            // 文件已经读取完毕，没有更多的字符
            if(curr == 0) 
                break;
            
            // 把读取的字符放入目标数组buf
            // 有两个限制条件，可能跳出while循环的情况
            // 1. index >= n：目标数组里已经存入了n个字符
            // 2. bufferPtr >= curr：这次read4()读取的字符都已经存入了目标数组buf
            int bufferPtr = 0;
            while(index < n && bufferPtr < curr)
            {
                buf[index++] = buffer[bufferPtr++];
            }
        }
        return index;
    }
}
