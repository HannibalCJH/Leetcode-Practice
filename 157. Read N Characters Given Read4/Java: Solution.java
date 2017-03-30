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
        
        while(true) 
        {
            // 记录读取的字符个数，并且把这些对应的字符传入buffer
            int curr = read4(buffer);
            // 当前还需要向目标数组放入的字符个数
            // 1. curr < n - index：读取的字符还无法放满n个
            // 2. curr >= n - index： 当前目标数组buf里的字符个数加上curr已经超出要返回的n
            int currLen = Math.min(curr, n - index);
            // 把读取的字符放入目标数组buf
            for(int i = 0; i < currLen; i++) 
            {
                buf[index++] = buffer[i];
            }
            
            // 文件已经读取完毕或者读取的字符已经达到n个
            if(currLen != 4 || index == n) 
                break;
        }
        return index;
    }
}
