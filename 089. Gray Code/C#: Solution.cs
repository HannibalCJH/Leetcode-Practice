public class Solution {
    public IList<int> GrayCode(int n) 
    {
        IList<int> result = new List<int>();
        int size = 1 << n;
        for(int i = 0; i < size; i++)
            result.Add((i >> 1) ^ i);
        return result;
    }
}
