public class Solution {
    public int HIndex(int[] citations) 
    {
        Array.Sort(citations);
        int maxH = 0, curH = 0;
        for(int i = 0; i < citations.Length; i++)
        {
            curH = Math.Min(citations[i], citations.Length - i);
            maxH = Math.Max(curH, maxH);
        }
        return maxH;
    }
}
