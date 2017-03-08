public class Solution {
    // 这个做法是把哈希表的entry放到堆里进行排序，注意关于Map.Entry的用法以及它的方法的应用
    // 时间复杂度O(nlogn)，空间复杂度O(n)
    public String frequencySort(String s) 
    {
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
        // 把所有的字符统计一遍
        for(int i = 0; i < s.length(); i++)
        {
            char cur = s.charAt(i);
            if(letters.containsKey(cur))
            {
                letters.put(cur, letters.get(cur) + 1);
            }
            else
            {
                letters.put(cur, 1);
            }
        }
        
        // 对哈希表的entry根据value进行排序
        PriorityQueue<HashMap.Entry<Character, Integer>> heap = new PriorityQueue<>(new Comparator<HashMap.Entry<Character, Integer>>(){
            public int compare(HashMap.Entry<Character, Integer> entry1, HashMap.Entry<Character, Integer> entry2)
            {
                return entry2.getValue() - entry1.getValue();
            }
        });
        
        // 对哈希表的每个entry进行排序
        heap.addAll(letters.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty())
        {
            HashMap.Entry cur = heap.poll();
            char ch = (char)cur.getKey();
            for(int i = 0; i < (int)cur.getValue(); i++)
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
