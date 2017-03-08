class Letter
{
    char letter;
    int count;
    public Letter(char letter, int count)
    {
        this.letter = letter;
        this.count = count;
    }
}

public class Solution {
    // 这是我的做法，设计一个单独的类Letter来存信息
    // 时间复杂度O(nlogn)，空间复杂度O(n)
    public String frequencySort(String s) 
    {
        HashMap<Character, Letter> letters = new HashMap<Character, Letter>();
        // 把所有的字符统计一遍
        for(int i = 0; i < s.length(); i++)
        {
            char cur = s.charAt(i);
            if(letters.containsKey(cur))
            {
                letters.get(cur).count++;
            }
            else
            {
                letters.put(cur, new Letter(cur, 1));
            }
        }
        
        // 根据Letter.count进行排序，出现次数最大的在堆顶
        PriorityQueue<Letter> pq = new PriorityQueue<Letter>(new Comparator<Letter>(){
            public int compare(Letter l1, Letter l2)
            {
                return l2.count - l1.count;
            }
        });
        
        // 把所有的Letter进行排序
        for(Character key : letters.keySet())
        {
            pq.offer(letters.get(key));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {
            Letter cur = pq.poll();
            char ch = cur.letter;
            for(int i = 0; i < cur.count; i++)
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
