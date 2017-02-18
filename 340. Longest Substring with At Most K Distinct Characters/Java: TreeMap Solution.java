public class Solution {
    // 时间复杂度O(nlogk)，k是常数所以可以看成O(n)
    // 空间复杂度O(k)
    // 利用红黑树TreeMap，不直接跟踪左边界。可以用在输入的stream即一个个字符输入的情况下，这样我们本身就无法跟踪左边界。
    public int lengthOfLongestSubstringKDistinct(String s, int k) 
    {
        if(s == null || s.length() == 0 || k == 0)
            return 0;
            
        TreeMap<Integer, Character> lastOccurrence = new TreeMap<Integer, Character>();
        // inWindow跟踪所有在当前子串中的字符并记录它们上一次出现的index
        Map<Character, Integer> inWindow = new HashMap<Character, Integer>();
        int left = 0;
        int longest = 0;
        for(int right = 0; right < s.length(); right++) 
        {
            char cur = s.charAt(right);
            // inWindow子串中的不同字符个数已经达到k且cur在inWindow中不存在
            // 这样如果加入cur的话不同字符个数会达到k+1>k
            if(inWindow.size() == k && !inWindow.containsKey(cur)) 
            {
                // 取得inWindow左边界的index即lastOccurrence中最小的index
                int first = lastOccurrence.firstKey();
                // 获取对应的字符
                char out = lastOccurrence.get(first);
                // 移除左边界的字符
                inWindow.remove(out);
                lastOccurrence.remove(first);
                // 更新左边界
                left = first + 1;
            }
            // 如果子串中还有cur，我们得更新cur的上一次出现的index
            // 步骤是先删除lastOccurrence中cur存的index即cur上一次出现的index，
            // 然后把当前的键值对[cur, right]存入lastOccurrence
            if(inWindow.containsKey(cur))
                lastOccurrence.remove(inWindow.get(cur));
            // 更新或加入[cur, right]到两个表中
            inWindow.put(cur, right);
            lastOccurrence.put(right, cur);
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
