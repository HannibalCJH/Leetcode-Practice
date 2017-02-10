public class Solution {
    // 时间复杂度O(nlogk)，k是常数所以可以看成O(n)
    // 空间复杂度O(k)
    public int LengthOfLongestSubstringKDistinct(string str, int k) 
    {
        if(str == null || str.Length == 0 || k == 0)
            return 0;
        // C#用SortedList来代替Java的TreeMap
        SortedList lastOccurrence = new SortedList();
        // inWindow跟踪所有在当前子串中的字符并记录它们上一次出现的index
        Dictionary<char, int> inWindow = new Dictionary<char, int>();
        int left = 0;
        int longest = 0;
        for(int right = 0; right < str.Length; right++) 
        {
            char cur = str[right];
            // inWindow子串中的不同字符个数已经达到k且cur在inWindow中不存在
            // 这样如果加入cur的话不同字符个数会达到k+1>k
            if(inWindow.Count == k && !inWindow.ContainsKey(cur)) 
            {
                // 取得inWindow左边界的index即lastOccurrence中最小的index
                int first = Convert.ToInt32(lastOccurrence.GetKey(0));
                // 获取对应的字符
                char firstChar = Convert.ToChar(lastOccurrence[first]);
                // 移除左边界的字符
                inWindow.Remove(firstChar);
                lastOccurrence.Remove(first);
                // 更新左边界
                left = first + 1;
            }
            // 如果子串中还有cur，我们得更新cur的上一次出现的index
            // 步骤是先删除lastOccurrence中cur存的index即cur上一次出现的index，
            // 然后把当前的键值对[cur, right]存入lastOccurrence
            if(inWindow.ContainsKey(cur))
            {
                lastOccurrence.Remove(inWindow[cur]);
                inWindow.Remove(cur);
            }
            // 更新或加入[cur, right]到两个表中
            inWindow.Add(cur, right);
            lastOccurrence.Add(right, cur);
            longest = Math.Max(longest, right - left + 1);
        }
        return longest;
    }
}
