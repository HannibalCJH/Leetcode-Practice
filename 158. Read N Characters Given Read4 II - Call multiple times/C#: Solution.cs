/* The Read4 API is defined in the parent class Reader4.
      int Read4(char[] buf); */

public class Solution : Reader4 {
    int bufferPtr = 0;
    int curr = 0;
    char[] buffer = new char[4];
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int Read(char[] buf, int n) 
    {
        int index = 0;
        while(index < n)
        {
            if(bufferPtr == 0)
                curr = Read4(buffer);
            if(curr == 0)
                break;
            
            while(index < n && bufferPtr < curr)
            {
                buf[index++] = buffer[bufferPtr++];
            }
            
            if(bufferPtr == curr)
                bufferPtr = 0;
        }
        return index;
    }
}
