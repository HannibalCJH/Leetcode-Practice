/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    // 时间复杂度O(n)，空间复杂度O(1)
    int bufferPtr = 0;
    int curr = 0;
    char[] buffer = new char[4];
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) 
    {
        int index = 0;
        while(index < n) 
        {
            // bufferPtr指向buffer开头，说明上一次read()读取的都已经利用上，可以重新再读取
            if(bufferPtr == 0)
                curr = read4(buffer);
            // 文件已经读取完毕，没有更多的字符
            if(curr == 0) 
                break;
            
            while(index < n && bufferPtr < curr)
            {
                buf[index++] = buffer[bufferPtr++];
            }
            
            // 这一次read4()读取的字符都已经利用上
            if(bufferPtr == curr) 
                bufferPtr = 0;
        }
        return index;
    }
}
