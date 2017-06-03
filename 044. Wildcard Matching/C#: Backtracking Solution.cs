public class Solution {
    public bool IsMatch(string s, string p) 
    {
        int i = 0, j = 0;
        int star = -1;
        int sPos = 0;
        while(i < s.Length)
        {
            // p中的字符为'*'
            while(j < p.Length && p[j] == '*')
            {
                // 记录回溯的位置
                // 记录'*'的位置并往前移动
                star = j++;
                // 记录下出现'*'时s字符串中的位置
                sPos = i;
            }
            // 已经遍历完p或者s和p中的字符不匹配
            if(j == p.Length || (s[i] != p[j] && p[j] != '?'))
            {
                // 没有出现过'*'
                if(star < 0)
                    return false;
                else
                {
                    // 只要出现过'*'，就用它匹配所有从sPos位置到i的字符，然后回溯
                    j = star + 1;
                    i = sPos++;
                }
            }
            else
            {
                i++;
                j++;
            }
        }
        // s遍历后如果p还有剩，那剩下的字符必须都是'*'
        while(j < p.Length && p[j] == '*')
        {
            j++;
        }
        return j == p.Length;
    }
}
