public class Solution {
    public int HIndex(int[] citations) 
    {
        int length = citations.Length;
        int[] count = new int[length + 1];
        foreach(int num in citations)
        {
            if(num > length)
                count[length]++;
            else
                count[num]++;
        }
        
        int total = 0;
        for(int i = length; i >= 0; i--)
        {
            total += count[i];
            if(total >= i)
                return i;
        }
        return 0;
    }
}
