public class Solution {
    // 时间复杂度O(nklogk)，n为字符串数组的长度，k为平均每个字符串的长度
    // 空间复杂度O(n)
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0)
            return result;
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs)
        {
            // 字符串无法直接排序，先转成字符数组
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String key = Arrays.toString(strArray);
            if(map.containsKey(key))
            {
                map.get(key).add(str);
            }
            else
            {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }
        }
        for(String key : map.keySet())
        {
            result.add(map.get(key));
        }
        return result;
    }
}
