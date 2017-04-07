public class WordDistance {
    // 哈希表记录单词及它出现的下标
    HashMap<String, List<Integer>> map;
    
    // 时间复杂度O(n)，空间复杂度O(n)
    public WordDistance(String[] words) 
    {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++)
        {
            if(!map.containsKey(words[i]))
            {
                map.put(words[i], new ArrayList<Integer>());
            }
            // 这个单词出现的下标被从小到大有序地加入到列表里
            map.get(words[i]).add(i);
        }
    }
    // 时间复杂度O(min(x, y))，归并排序，x和y分别为两个单词出现的次数
    // 空间复杂度O(n)
    public int shortest(String word1, String word2) 
    {
        // 两个列表都是有序的
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0;
        int minDist = Integer.MAX_VALUE;
        // 因为两个列表都是有序的，我们可以进行归并排序降低复杂度为O(min(x, y))
        while(i < list1.size() && j < list2.size())
        {
            int idx1 = list1.get(i), idx2 = list2.get(j);
            // 我们希望尽量让idx1和idx2越近越好
            // 当idx1小于idx2时，我们保持idx2不动，往后移动idx1尽量使其靠近idx2
            if(idx1 < idx2)
            {
                i++;
            }
            else
            {
                // 当idx1大于等于idx2时，我们保持idx1不动，往后移动idx2尽量使其靠近idx1
                j++;
            }
            // 计算距离
            minDist = Math.min(minDist, Math.abs(idx1 - idx2));
        }
        return minDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
