/* The Read4 API is defined in the parent class Reader4.
      int Read4(char[] buf); */

public class Solution : Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int Read(char[] buf, int n) 
    {
        char[] buffer = new char[4];
        int index = 0;
        // 最多只读取n个字符
        while(index < n)
        {
            int curr = Read4(buffer);
            // 文件读取完毕，没有更多字符
            if(curr == 0)
                break;
            
            int bufferPtr = 0;
            while(index < n && bufferPtr < curr)
            {
                buf[index++] = buffer[bufferPtr++];
            }
        }
        return index;
    }
}
