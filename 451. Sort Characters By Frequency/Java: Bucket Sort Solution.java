public class Solution {
    // Bucket Sort
    // 时间复杂度O(n)，n为字符串的长度，注意最后一个看似是三层for循环，但是你最后append其实就是n次，我们生成的新字符串长度依然是n
    // 空间复杂度O(n)
    public String frequencySort(String s) 
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // 把所有字符个数统计一遍
        for(int i = 0; i < s.length(); i++)
        {
            char cur = s.charAt(i);
            if(map.containsKey(cur))
            {
                map.put(cur, map.get(cur) + 1);
            }
            else
            {
                map.put(cur, 1);
            }
        }
        
        // buckets数组，长度为字符加1，方便以自然数计算，下标就是出现的次数
        List<Character>[] buckets = new List[s.length() + 1];
        // 对于哈希表里的每个键值对，把键即字符加入到对应频率的bucket中
        for(char key : map.keySet())
        {
            int freq = map.get(key);
            if(buckets[freq] == null)
            {
                buckets[freq] = new ArrayList<Character>();
            }
            buckets[freq].add(key);
        }
        
        StringBuilder sb = new StringBuilder();
        // 从buckets数组的末尾往前扫，这样保证我们先遇到出现频率大的字符
        for(int i = buckets.length - 1; i >= 0; i--)
        {
            if(buckets[i] != null)
            {
                for(char cur : buckets[i])
                {
                    for(int j = 0; j < i; j++)
                    {
                        sb.append(cur);
                    }
                }
            }
        }
        return sb.toString();
    }
}
