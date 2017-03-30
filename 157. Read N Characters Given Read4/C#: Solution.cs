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
        
        while(true)
        {
            int curr = Read4(buffer);
            int currLen = Math.Min(curr, n - index);
            
            for(int i = 0; i < currLen; i++)
            {
                buf[index++] = buffer[i];
            }
            
            if(curr != 4 || index == n)
                break;
        }
        return index;
    }
}
